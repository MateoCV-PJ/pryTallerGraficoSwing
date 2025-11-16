package vista;

import javax.swing.*;

public class frmCliente extends JFrame {
    public JTextField txtIdCliente, txtNombre, txtApellido, txtEmail;
    public JComboBox cmbGenero;
    public JButton btnGuardar, btnModificar, btnEliminar, btnLimpiar;

    public frmCliente() {

        setTitle("Formulario Cliente");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblId = new JLabel("ID Cliente:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);
        txtIdCliente = new JTextField();
        txtIdCliente.setBounds(130, 20, 200, 25);
        add(txtIdCliente);

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

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 140, 100, 25);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(130, 140, 200, 25);
        add(txtEmail);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(20, 180, 100, 25);
        add(lblGenero);
        cmbGenero = new JComboBox<>(new String[] {"Masculino", "Femenino", "Otro"});
        cmbGenero.setBounds(130, 180, 200, 25);
        add(cmbGenero);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 230, 80, 25);
        add(btnGuardar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(110, 230, 90, 25);
        add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(210, 230, 80, 25);

        add(btnEliminar);
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(300, 230, 80, 25);
        add(btnLimpiar);
    }
}
