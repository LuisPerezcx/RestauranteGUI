package gui;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import alimentosybebidas.Plantilla;
import main.Main;
import menus.MainMenu;
import util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class FormularioTabla extends JFrame {
    private JTable jTable;
    private DefaultTableModel modelo;
    private Button btnRegresar;
    private JPanel panelbtn;
    public FormularioTabla (){
        initControl();
        configTable();
        configFrame();
        addActionListeners();
    }
    private void addActionListeners() {
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PrincipalGUI();
        });
    }
    private void initControl(){
        /*
             DefaultTableModel()
             DefaultTableModel(int numRows, int numColumns)
             DefaultTableModel(Object[][] data, Object[] columnNames)
             DefaultTableModel(Object[] columnNames, int numRows)
             DefaultTableModel(Vector columnNames, int numRows)
             DefaultTableModel(Vector data, Vector columNames)
         */
        modelo = new DefaultTableModel();
        //DefaultTableModel modelo1 = new DefaultTableModel(UtilTable.usuarios,UtilTable.titulos);
        //modelo.setDataVector(UtilTable.usuarios,UtilTable.titulos);

        modelo.setColumnIdentifiers(Util.titulos);
        String [] fila = new String[modelo.getColumnCount()];
        // Vector<String> data = new Vector<>(modelo.getColumnCount());
        ArrayList<Bebidas> lista = MainMenu.bebidasArrayList;
        for (Bebidas userTable : lista) {
            fila[0] = userTable.getNombre();
            fila[1] = userTable.getDescripcion();
            fila[2] = String.valueOf(userTable.getPrecio());
            fila[3] = String.valueOf(userTable.getDisponibles());
            modelo.addRow(fila);
        }
        ArrayList<Alimentos> lista1 = MainMenu.alimentosArrayList;
        for (Alimentos userTable : lista1) {
            fila[0] = userTable.getNombre();
            fila[1] = userTable.getDescripcion();
            fila[2] = String.valueOf(userTable.getPrecio());
            fila[3] = String.valueOf(userTable.getDisponibles());
            modelo.addRow(fila);
        }
        panelbtn = new JPanel();
        jTable = new JTable(modelo);
        btnRegresar = new Button("Regresar");

    }
    private void configFrame() {
        setTitle("Tabla de usuarios");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Establecer BoxLayout vertical
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 200);
        setResizable(true);
        setVisible(true);
    }

    private void configTable() {
        jTable.setGridColor(new Color(88, 214, 141));
        jTable.setPreferredScrollableViewportSize(new Dimension(600, 70));
        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane);

        panelbtn.add(btnRegresar); // Agregar el botón al panel
        getContentPane().add(panelbtn); // Agregar el panel al contenedor principal
    }

}