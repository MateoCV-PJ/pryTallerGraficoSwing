package vista;

import javax.swing.*;

public class frmUsuario extends JFrame {

    public JTextField txtIdUsuario, txtNombre, txtApellido;
    public JPasswordField txtClave;
    public JButton btnGuardar, btnModificar, btnEliminar, btnLimpiar;

    public frmUsuario() {

        setTitle("Formulario Usuario");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblId = new JLabel("ID Usuario:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);
        txtIdUsuario = new JTextField();
        txtIdUsuario.setBounds(130, 20, 200, 25);
        add(txtIdUsuario);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(130, 60, 200, 25);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 100, 100, 25);
        add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setBounds(130, 100, 200, 25);
        add(txtApellido);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(20, 140, 100, 25);
        add(lblClave);
        txtClave = new JPasswordField();
        txtClave.setBounds(130, 140, 200, 25);
        add(txtClave);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 190, 80, 25);
        add(btnGuardar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(110, 190, 90, 25);
        add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(210, 190, 80, 25);
        add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(300, 190, 80, 25);
        add(btnLimpiar);
    }
}
