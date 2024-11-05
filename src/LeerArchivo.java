import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    public static void main(String[] args) {
        String ruta = "D:\\Programación Basica\\ManejoArchivos\\Data\\test.txt";

        try  (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            double suma = 0;
            int count = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            while ((linea = br.readLine()) != null) {
                try {
                    double numero = Double.parseDouble(linea);
                    suma += numero;
                    count++;
                    max = Math.max(max, numero);
                    min = Math.min(min, numero);

                } catch (NumberFormatException e) {
                }
            }

            if (count > 0) {
                System.out.println("Promedio: " + (suma / count));
                System.out.println("Número mayor: " + max);
                System.out.println("Número menor: " + min);
            } else {
                System.out.println("No se encontraron números válidos en el archivo");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
