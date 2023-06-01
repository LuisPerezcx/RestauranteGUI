package ingresar;

import alimentosybebidas.Alimentos;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarAlimentos {
    Validar validar = new Validar();
    public void registrar(ArrayList<Alimentos> lista, Scanner scanner){
        String nombre, descripcion;
        double precio=-1;
        int disponibles=-1;
        System.out.println("- REGISTRAR ALIMENTOS -");
        System.out.println("ingresa nombre comida:");
        nombre = scanner.nextLine();
        System.out.println("ingresa descripcion comida:");
        descripcion = scanner.nextLine();
        while (precio==-1){
            System.out.println("ingresa precio comida:");
            precio = validar.validarDouble(scanner);
            scanner.nextLine();
        }
        while (disponibles==-1){
            System.out.println("ingresa numero de platillos disponibles:");
            disponibles = validar.validarnum(scanner);
            scanner.nextLine();
        }
        lista.add(new Alimentos(nombre,descripcion,precio,disponibles));
    }
}
