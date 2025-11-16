package controlador;

import vista.frmCliente;
import modelo.ModCliente;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CtrCliente implements ActionListener{
    private frmCliente vista;

    public CtrCliente(frmCliente vista) {
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);

        //implementar el resto de botones
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarCliente();
        }
    }

    private void guardarCliente() {
        ModCliente cliente = new ModCliente();

        cliente.setIdCliente(vista.txtIdCliente.getText());
        cliente.setNombre(vista.txtNombre.getText());
        cliente.setApellido(vista.txtApellido.getText());
        cliente.setEmail(vista.txtEmail.getText());
        cliente.setGenero(vista.cmbGenero.getSelectedItem().toString());

        Gson gson = new Gson();
        String json = gson.toJson(cliente);

        try (FileWriter writer = new FileWriter("clientes.json", true)) {
            writer.write(json + "\n");
            System.out.println("Cliente guardado en clientes.json");

            //Limpiar formulario
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

















