package vista;

import javax.swing.*;
import java.awt.event.*;

public class frmPrincipal extends JFrame {
    private JMenuBar menuBar;
    public JMenu menuUsuario, menuCliente, menuSalir;

    public frmPrincipal() {

        setTitle("Aplicación MVC - Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuUsuario = new JMenu("Usuario");
        menuCliente = new JMenu("Cliente");
        menuSalir = new JMenu("Salir");

        menuBar.add(menuUsuario);
        menuBar.add(menuCliente);
        menuBar.add(menuSalir);
        setJMenuBar(menuBar);
    }
}