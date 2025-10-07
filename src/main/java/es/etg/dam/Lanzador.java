package es.etg.dam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {

    public static final String RUTA_FICHERO = "output.txt";
    public static final String[] COMANDO = { "java", "-cp", "target/classes", "es.etg.dam.Suma", "1", "3" };

    public static void main(String[] args) {

        try {

            Process proceso = Runtime.getRuntime().exec(COMANDO);

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = reader.readLine()) != null) {
                output.append(linea).append("\n");
            }

            int exitVal = proceso.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);

                try (BufferedReader br = new BufferedReader(new FileReader(RUTA_FICHERO))) {
                    System.out.println("Contenido del fichero:");
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }

                System.exit(0);
            } else {
                System.exit(1);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(34);
        }
    }

}