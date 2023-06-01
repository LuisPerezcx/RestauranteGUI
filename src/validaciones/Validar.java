package validaciones;

import java.util.Scanner;

public class Validar {
    public int validarnum(Scanner scanner){
        if(scanner.hasNextInt()){
            int numint = scanner.nextInt();
            return numint;
        }
        else {
            System.out.println("La entrada no es un número entero válido");
            return -1;
        }
    }
    public double validarDouble(Scanner scanner){
        if (scanner.hasNextDouble()) { // Verifica si la entrada es un double
            double numero = scanner.nextDouble();
            return numero;
        } else {
            System.out.println("La entrada no es un número decimal válido.");
            return -1;
        }
    }
}