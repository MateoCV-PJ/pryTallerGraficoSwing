package vista;

import javax.swing.*;

public class frmUsuario extends JFrame {

    public JTextField txtIdUsuario, txtNombre, txtApellido;
    public JPasswordField txtClave;
    public JButton btnAccion, btnLimpiar;

    public JLabel lblId, lblNombre, lblApellido, lblClave;

    public JMenuItem mniGuardar, mniModificar, mniEliminar;

    public frmUsuario() {
        setTitle("Formulario Usuario");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        mniGuardar = new JMenuItem("Guardar");
        mniModificar = new JMenuItem("Modificar");
        mniEliminar = new JMenuItem("Eliminar");
        menuOpciones.add(mniGuardar);
        menuOpciones.add(mniModificar);
        menuOpciones.add(mniEliminar);
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        lblId = new JLabel("ID Usuario:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);
        txtIdUsuario = new JTextField();
        txtIdUsuario.setBounds(130, 20, 200, 25);
        add(txtIdUsuario);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(130, 60, 200, 25);
        add(txtNombre);

        lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 100, 100, 25);
        add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setBounds(130, 100, 200, 25);
        add(txtApellido);

        lblClave = new JLabel("Clave:");
        lblClave.setBounds(20, 140, 100, 25);
        add(lblClave);
        txtClave = new JPasswordField();
        txtClave.setBounds(130, 140, 200, 25);
        add(txtClave);

        btnAccion = new JButton("Acción");
        btnAccion.setBounds(80, 190, 100, 25);
        add(btnAccion);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(300, 190, 80, 25);
        add(btnLimpiar);
    }
}
