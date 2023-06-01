package operaciones;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class Operaciones {
    Validar validar = new Validar();
    Buscar buscar = new Buscar();
    public static void mostrar(ArrayList<Alimentos> alimentosList, ArrayList<Bebidas> bebidasList){
        System.out.println("----------------- M E N U -----------------");
        System.out.println("-------- MENU ALIMENTOS --------");
        for (Alimentos alimentos:alimentosList) {
            System.out.println(alimentos);
        }
        System.out.println("-------- MENU BEBIDAS ---------");
        for (Bebidas bebidas:bebidasList) {
            System.out.println(bebidas);
        }
    }
    public double realizarPedido(ArrayList<Alimentos> alimentosList, ArrayList<Bebidas> bebidasList, Scanner scanner){
        double cuenta;
        cuenta = buscar.choiceOrdenar(alimentosList,bebidasList,scanner);
        return cuenta;
    }
    public double pagar(double cuenta,Scanner scanner){
        if(cuenta!=0){
            System.out.println("TOTAL CUENTA: $" + cuenta);
            System.out.println("ingresa pago");
            double pago=-1;
            while (pago==-1){
                pago = validar.validarDouble(scanner);
                scanner.nextLine();
            }
            if(pago==cuenta){
                System.out.println("- PAGADO -");
                return 0;
            } else if (pago>cuenta){
                System.out.println("cambio:" + (pago-cuenta) + "\n- PAGADO -");
                return 0;
            }else{
                System.out.println("Pago incorrecto");
                return cuenta;
            }
        }else{
            System.out.println("Primero ordena algo!");
            return cuenta;
        }
    }

}
