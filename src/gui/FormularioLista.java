package gui;

import alimentosybebidas.Alimentos;
import alimentosybebidas.Bebidas;
import alimentosybebidas.Plantilla;
import menus.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioLista extends JFrame {
    private JList<Plantilla> jList;
    private DefaultListModel<Plantilla> elementos;
    private JPanel panelContenedor, panelBoton, panelLista;
    private JButton btnMostrar,btnEliminar,btnEliminarTodo,btnRegresar;
    public FormularioLista(){
        crearComponentes();
        configurarVentana();
        dibujarCuerpo();
        add(panelContenedor);

        showList();
        eliminar();
        eliminarTodo();
        regresar();

    }
    private void crearComponentes(){

        panelContenedor = new JPanel();
        panelBoton = new JPanel();
        panelLista = new JPanel();
        btnMostrar = new JButton();
        btnEliminar = new JButton();
        jList = new JList<>();
        btnEliminarTodo = new JButton();
        btnRegresar = new JButton();
        btnMostrar.setText("Mostrar");
        btnEliminar.setText("Eliminar");
        btnEliminarTodo.setText("Eliminar Todo");
        btnRegresar.setText("Regresar");
    }
    private void configurarVentana(){
        setTitle("Formulario lista");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(420, 420);
    }
    private void dibujarCuerpo(){
        panelLista.setLayout(new GridLayout(1,0));
        panelLista.add(jList);
        panelLista.setPreferredSize(new Dimension(300,300));

        panelBoton.setLayout(new FlowLayout());
        panelBoton.setPreferredSize(new Dimension(400,50));
        panelBoton.add(btnMostrar);
        panelBoton.add(btnEliminar);
        panelBoton.add(btnEliminarTodo);
        panelBoton.add(btnRegresar);

        panelContenedor.setLayout(new GridLayout(2,0));
        panelContenedor.add(panelLista);
        panelContenedor.add(panelBoton);
    }
    private void showList(){
        btnMostrar.addActionListener(e -> {
            elementos = new DefaultListModel<>();
            for (Alimentos elemento : MainMenu.alimentosArrayList) {
                elementos.addElement(elemento);
            }
            for (Bebidas elemento : MainMenu.bebidasArrayList) {
                elementos.addElement(elemento);
            }
            jList.setModel(elementos);
        });
    }
    private void eliminar(){
        btnEliminar.addActionListener(e -> {
            int elemento = jList.getSelectedIndex();
            elementos.remove(elemento);
        });
    }

    private void eliminarTodo(){
        btnEliminarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementos.removeAllElements();
            }
        });
    }


    private void regresar(){
        btnRegresar.addActionListener(e -> {
            this.setVisible(false);
            new PrincipalGUI();
        });
    }

}
