package vista;

import javax.swing.*;

public class frmCliente extends JFrame {
    public JTextField txtIdCliente, txtNombre, txtApellido, txtEmail;
    public JComboBox<String> cmbGenero;
    public JButton btnAccion, btnLimpiar;

    public JLabel lblId, lblNombre, lblApellido, lblEmail, lblGenero;

    public JMenuItem mniGuardar, mniModificar, mniEliminar;

    public frmCliente() {

        setTitle("Formulario Cliente");
        setSize(400, 350);
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

        lblId = new JLabel("ID Cliente:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);
        txtIdCliente = new JTextField();
        txtIdCliente.setBounds(130, 20, 200, 25);
        add(txtIdCliente);

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

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 140, 100, 25);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(130, 140, 200, 25);
        add(txtEmail);

        lblGenero = new JLabel("Género:");
        lblGenero.setBounds(20, 180, 100, 25);
        add(lblGenero);
        cmbGenero = new JComboBox<>(new String[] {"Masculino", "Femenino", "Otro"});
        cmbGenero.setBounds(130, 180, 200, 25);
        add(cmbGenero);

        btnAccion = new JButton("Acción");
        btnAccion.setBounds(80, 230, 100, 25);
        add(btnAccion);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(200, 230, 100, 25);
        add(btnLimpiar);
    }
}
