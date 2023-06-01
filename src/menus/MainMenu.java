package menus;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import ingresar.RegistrarAlimentos;
import ingresar.RegistrarBebidas;
import operaciones.Operaciones;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static ArrayList<Alimentos> alimentosArrayList;
    public static ArrayList<Bebidas> bebidasArrayList;
    public RegistrarAlimentos registrarAlimentos;
    public RegistrarBebidas registrarBebidas;
    public Operaciones operaciones;

    Validar validar = new Validar();

    public MainMenu(ArrayList<Alimentos> alimentosArrayList, ArrayList<Bebidas> bebidasArrayList,
                    RegistrarAlimentos registrarAlimentos, RegistrarBebidas registrarBebidas,
                    Operaciones operaciones) {
        MainMenu.alimentosArrayList = alimentosArrayList;
        MainMenu.bebidasArrayList = bebidasArrayList;
        this.registrarAlimentos = registrarAlimentos;
        this.registrarBebidas = registrarBebidas;
        this.operaciones = operaciones;
    }
    public void menu(Scanner scanner){
        int opc=1;
        double cuenta=0;
        while (opc!=6){
            opc = menuSelect(scanner);
            switch (opc){
                case 1 -> registrarAlimentos.registrar(alimentosArrayList,scanner);
                case 2 -> registrarBebidas.registrar(bebidasArrayList,scanner);
                case 3 -> Operaciones.mostrar(alimentosArrayList,bebidasArrayList);
                case 4 -> cuenta = operaciones.realizarPedido(alimentosArrayList,bebidasArrayList,scanner);
                case 5 -> cuenta = operaciones.pagar(cuenta,scanner);
                case 6 -> System.out.println();
                default -> System.out.println("Opcion Invalida, ingresa nuevamente");
            }
        }
    }

    public static ArrayList<Alimentos> getAlimentosArrayList() {
        return alimentosArrayList;
    }

    public static ArrayList<Bebidas> getBebidasArrayList() {
        return bebidasArrayList;
    }

    private int menuSelect(Scanner scanner){
        System.out.println("""
                ---------------------------------------------\s
                Seleccione una opcion:\s
                1.- Registrar Alimentos \s
                2.- Registrar Bebidas\s
                3.- Mostrar Menu\s
                4.- Realizar pedido\s
                5.- Pagar pedido\s
                5.- Salir\s
                pulsa 0 para salir
                """);
        int n=validar.validarnum(scanner);
        scanner.nextLine();
        return n;
    }
}

