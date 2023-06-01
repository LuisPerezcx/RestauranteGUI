package operaciones;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class Buscar {
    Validar validar = new Validar();
    public double choiceOrdenar(ArrayList<Alimentos> alimentosList, ArrayList<Bebidas> bebidasList, Scanner scanner){
        double cuenta=0;
        int opc = 0;
        while (opc!=3){
            System.out.println("Que deseas ordenar\n 1) Alimentos\n 2) Bebidas\n[3]Regresar");
            opc = validar.validarnum(scanner);
            scanner.nextLine();
            switch (opc){
                case 1 -> cuenta += findPrecioAlimento(alimentosList,scanner);
                case 2 -> cuenta += findPrecioBebidas(bebidasList,scanner);
                case 3 -> System.out.println();
                default -> System.out.println("opcion invalida");
            }
        }
        return cuenta;
    }
    private double findPrecioAlimento(ArrayList<Alimentos> alimentosList, Scanner scanner){
        System.out.println("Ingresa el Nombre del Alimento");
        String search = scanner.nextLine();
        for (Alimentos alimentos : alimentosList) {
            if (alimentos.getNombre().equals(search) && alimentos.getDisponibles()>0) {
                int disp = alimentos.getDisponibles();
                alimentos.setDisponibles(disp-1);
                System.out.println(alimentos.getNombre() + " Agregado a la cuenta");
                return alimentos.getPrecio();
            }
        }
        System.out.println("EL ALIMENTO NO ESTA DISPONIBLE EN EL MENU");
        return 0;
    }
    private double findPrecioBebidas(ArrayList<Bebidas> bebidasList, Scanner scanner){
        System.out.println("Ingresa el Nombre de la Bebida");
        String search = scanner.nextLine();
        for (Bebidas bebidas : bebidasList) {
            if (bebidas.getNombre().equals(search) && bebidas.getDisponibles()>0) {
                int disp = bebidas.getDisponibles();
                bebidas.setDisponibles(disp-1);
                System.out.println(bebidas.getNombre() + " Agregada a la cuenta");
                return bebidas.getPrecio();
            }
        }
        System.out.println("EL ALIMENTO NO ESTA DISPONIBLE EN EL MENU");
        return 0;
    }
}
