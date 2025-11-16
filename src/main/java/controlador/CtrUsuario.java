package controlador;

import vista.frmUsuario;
import modelo.ModUsuario;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CtrUsuario implements ActionListener{
    private frmUsuario vista;

    public CtrUsuario (frmUsuario vista) {
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);
        // (Aquí puedes añadir listeners para Modificar, Eliminar, Limpiar)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarUsuario();
        }

        //las funciones del resto de botones
    }

    private void guardarUsuario() {
        ModUsuario usuario = new ModUsuario();

        usuario.setIdUsuario(vista.txtIdUsuario.getText());
        usuario.setNombre(vista.txtNombre.getText());
        usuario.setApellido(vista.txtApellido.getText());
        usuario.setClave(new String(vista.txtClave.getPassword()));

        Gson gson = new Gson();
        String json = gson.toJson(usuario);

        try (FileWriter writer = new FileWriter("usuarios.json", true)){
            writer.write(json + "\n");
            System.out.println("Usuario guardado en usuarios.json");

            //limpiar formulario

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}











