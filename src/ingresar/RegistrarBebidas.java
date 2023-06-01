package ingresar;

import alimentosybebidas.Bebidas;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarBebidas {
    Validar validar = new Validar();
    public void registrar(ArrayList<Bebidas> lista, Scanner scanner){
        String nombre, descripcion;
        double precio=-1;
        int disponibles=-1;
        System.out.println("- REGISTRAR BEBIDAS -");
        System.out.println("ingresa nombre de la bebida:");
        nombre = scanner.nextLine();
        System.out.println("ingresa descripcion de la bebida:");
        descripcion = scanner.nextLine();
        while (precio==-1){
            System.out.println("ingresa precio de la bebida:");
            precio = validar.validarDouble(scanner);
            scanner.nextLine();
        }
        while (disponibles==-1){
            System.out.println("ingresa numero de bebidas disponibles:");
            disponibles = validar.validarnum(scanner);
            scanner.nextLine();
        }
        lista.add(new Bebidas(nombre,descripcion,precio,disponibles));
    }
}
