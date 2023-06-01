package main;

import gui.PrincipalGUI;
import ingresar.RegistrarAlimentos;
import ingresar.RegistrarBebidas;
import menus.MainMenu;
import operaciones.Operaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(new ArrayList<>(),new ArrayList<>(),
                new RegistrarAlimentos(),new RegistrarBebidas(),new Operaciones());
        new PrincipalGUI();
        //mainMenu.menu(scanner);
    }
}
