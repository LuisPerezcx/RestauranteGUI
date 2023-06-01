package gui;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import menus.MainMenu;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalGUI extends JFrame{
    private JLabel nombre, descripcion, precio, disponibles;
    private JTextField txtNombre, txtDescripcion;
    private JFormattedTextField txtPrecio,txtDisponibles;
    private final NumberFormatter formatter = new NumberFormatter();
    private JPanel panelContainer,panelBtn,panelCuerpo,panelIz,panelDer,panelRadio;
    private JButton btnMostrar, btnTabla,btnAceptar;
    private JRadioButton radio1,radio2;
    private ButtonGroup grupo;
    private static ArrayList<Alimentos> alimentosArrayList;
    private static ArrayList<Bebidas> bebidasArrayList;
    public PrincipalGUI(){
        inicializarComponentes();
        setupFrame();
        setPanelContainer();
        addActionListeners();
    }
    private void inicializarComponentes(){
        btnAceptar = new JButton("Aceptar");
        btnMostrar = new JButton("Mostrar");
        btnTabla = new JButton("Tabla");
        panelCuerpo = new JPanel();
        panelDer = new JPanel();
        panelIz = new JPanel();
        panelBtn = new JPanel();
        panelContainer = new JPanel();
        nombre = new JLabel("Nombre (platillo/bebida): ");
        descripcion = new JLabel("Descripcion (platillo/bebida):");
        precio = new JLabel("Precio (platillo/bebida):");
        disponibles = new JLabel("Disponibles:");
        txtNombre = new JTextField();
        txtDescripcion = new JTextField();

        panelRadio = new JPanel();
        grupo = new ButtonGroup();
        radio1 = new JRadioButton("Alimentos");
        radio2 = new JRadioButton("Bebidas");
        bebidasArrayList = MainMenu.getBebidasArrayList();
        alimentosArrayList = MainMenu.getAlimentosArrayList();

        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false); // No permite valores no válidos
        formatter.setCommitsOnValidEdit(true); // Realiza la edición al validar

        txtPrecio = new JFormattedTextField(formatter);
        txtPrecio.setColumns(10);
        txtDisponibles = new JFormattedTextField(formatter);
        txtPrecio.setColumns(10);
    }

    private void setupFrame(){
        setTitle("Formulario Estudiantes");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(450, 200);
    }

    private void setPanelContainer(){
        panelIz.setLayout(new GridLayout(4,1));
        panelIz.add(nombre);
        panelIz.add(descripcion);
        panelIz.add(precio);
        panelIz.add(disponibles);

        panelDer.setLayout(new GridLayout(4,1));
        panelDer.add(txtNombre);
        panelDer.add(txtDescripcion);
        panelDer.add(txtPrecio);
        panelDer.add(txtDisponibles);

        panelCuerpo.setLayout(new GridLayout(1,2));
        panelCuerpo.setPreferredSize(new Dimension(400,90));
        panelCuerpo.add(panelIz);
        panelCuerpo.add(panelDer);

        grupo.add(radio1);
        grupo.add(radio2);

        panelRadio.setLayout(new FlowLayout());
        panelRadio.add(radio1);
        panelRadio.add(radio2);


        panelBtn.setLayout(new FlowLayout());
        panelBtn.add(btnAceptar);
        panelBtn.add(btnMostrar);
        panelBtn.add(btnTabla);


        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.add(panelCuerpo);
        panelContainer.add(panelRadio);
        panelContainer.add(panelBtn);
        add(panelContainer);
    }
    private void addActionListeners(){
        btnAceptar.addActionListener(new llenarArrayList());
        btnMostrar.addActionListener(e -> {
            setVisible(false);
            new FormularioLista();
        });
        btnTabla.addActionListener(e -> {
            setVisible(false);
            new FormularioTabla();
        });
    }


    private void clearTextFields() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setValue(null);
        txtDisponibles.setValue(null);
    }
    public class llenarArrayList implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(radio1.isSelected() || radio2.isSelected())){
                System.out.println("NINGUN RADIO BUTTON SELECCIONADO");
            }else{
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String precio = txtPrecio.getText();
                String disponibles = txtDisponibles.getText();

                float preciio = Float.parseFloat(precio);
                int disponibless = Integer.parseInt(disponibles);

                if(radio1.isSelected()){
                    alimentosArrayList.add(new Alimentos(nombre,descripcion,preciio,disponibless));
                    mostrarAlimento(alimentosArrayList);
                    clearTextFields();
                }else if (radio2.isSelected()){
                    bebidasArrayList.add(new Bebidas(nombre,descripcion,preciio,disponibless));
                    mostrarBebida(bebidasArrayList);
                    clearTextFields();
                }
            }
        }
    }
    public void mostrarAlimento(ArrayList<Alimentos> lista){
        System.out.println("----------ALIMENTOS----------");
        for (Alimentos alimentos:lista) {
            System.out.println(alimentos);
            System.out.println("*********************************************************");
        }
    }
    public void mostrarBebida(ArrayList<Bebidas> lista){
        System.out.println("----------BEBIDAS----------");
        for (Bebidas alumno:lista) {
            System.out.println(alumno);
            System.out.println("*********************************************************");
        }
    }
}
