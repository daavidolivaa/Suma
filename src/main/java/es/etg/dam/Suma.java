package es.etg.dam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Suma {

    public static final String MSG_ERROR = "Solo se pueden usar valores numericos";
    public static final String MSG_ERROR2 = "Hay que insertar dos parametros";
    public static final String MSG_ERROR3 = "Error al escribir el Fichero";
    public static final String RUTA = "output.txt";

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA))) {

            try {
                int n1 = Integer.parseInt(args[0]);
                int n2 = Integer.parseInt(args[1]);

                int min = Math.min(n1, n2);
                int max = Math.max(n1, n2);

                int suma = 0;
                for (int i = min; i <= max; i++) {
                    suma += i;
                }

                writer.write(String.valueOf(suma));

            } catch (NumberFormatException e) {
                writer.write(MSG_ERROR);
                writer.close();
                System.exit(1);
            }

            catch (ArrayIndexOutOfBoundsException e) {
                writer.write(MSG_ERROR2);
                writer.close();
                System.exit(1);
            }

        } catch (IOException e) {
            System.out.println(MSG_ERROR3);
            System.exit(1);
        }

    }
}
