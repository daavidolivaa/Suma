package es.etg.dam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {

    public static void main(String[] args) {

        final String[] comando = { "java", "-cp", "target/classes", "es.etg.dam.Suma", "1", "3" };

        try {

            Process proceso = Runtime.getRuntime().exec(comando);

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
                System.exit(0);
            } else {
                System.exit(1);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(34);
        }
    }

}