package controlador;

import vista.frmUsuario;
import modelo.ModUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CtrUsuario implements ActionListener{
    private frmUsuario vista;
    private final String ARCHIVO = "usuarios.json";
    private String accionActual = "NINGUNA";

    public CtrUsuario (frmUsuario vista) {
        this.vista = vista;

        this.vista.mniGuardar.addActionListener(this);
        this.vista.mniModificar.addActionListener(this);
        this.vista.mniEliminar.addActionListener(this);

        this.vista.btnAccion.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);

        prepararVistaGuardar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.mniGuardar) {
            prepararVistaGuardar();
        }

        if (e.getSource() == vista.mniModificar) {
            prepararVistaModificar();
        }

        if (e.getSource() == vista.mniEliminar) {
            prepararVistaEliminar();
        }

        if (e.getSource() == vista.btnAccion) {
            switch (accionActual) {
                case "GUARDAR": guardarUsuario(); break;
                case "MODIFICAR": modificarUsuario(); break;
                case "ELIMINAR": eliminarUsuario(); break;
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }

    private void prepararVistaGuardar(){
        accionActual = "GUARDAR";
        vista.btnAccion.setText("Guardar");
        setVisibilidadCampos(true);
        limpiarCampos();
    }

    private void prepararVistaModificar(){
        accionActual = "MODIFICAR";
        vista.btnAccion.setText("Modificar");
        setVisibilidadCampos(true);
        limpiarCampos();
    }

    private void prepararVistaEliminar(){
        accionActual = "ELIMINAR";
        vista.btnAccion.setText("Eliminar");
        setVisibilidadCampos(false);
        vista.lblId.setVisible(true);
        vista.txtIdUsuario.setVisible(true);
        limpiarCampos();
    }

    private void setVisibilidadCampos(boolean visible) {
        vista.lblId.setVisible(true);
        vista.txtIdUsuario.setVisible(true);

        vista.lblNombre.setVisible(visible);
        vista.txtNombre.setVisible(visible);
        vista.lblApellido.setVisible(visible);
        vista.txtApellido.setVisible(visible);
        vista.lblClave.setVisible(visible);
        vista.txtClave.setVisible(visible);
    }

    private List<ModUsuario> leerListaUsuarios() {
        Gson gson = new Gson();
        List<ModUsuario> lista = new ArrayList<>();
        File f = new File(ARCHIVO);

        if (f.exists()){
            try (Reader reader = new FileReader(f)) {
                Type listType = new TypeToken<ArrayList<ModUsuario>>(){}.getType();
                lista = gson.fromJson(reader, listType);

                //Archivo vacio o mal formado (null), devuelve lista nueva
                if (lista == null) lista = new ArrayList<>();
            } catch (Exception e) {
                System.out.println("Error leyendo el archivo  o formato incompatible: " + e.getMessage());
            }
        }
        return lista;
    }

    private void guardarListaUsuarios(List<ModUsuario> lista) {
        //setPrettyPrinting() da formato al JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(ARCHIVO)){
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos(){
        vista.txtIdUsuario.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtClave.setText("");
    }

    private void guardarUsuario() {
        List<ModUsuario> listaUsuarios = leerListaUsuarios();
        ModUsuario usuario = new ModUsuario();

        usuario.setIdUsuario(vista.txtIdUsuario.getText());
        usuario.setNombre(vista.txtNombre.getText());
        usuario.setApellido(vista.txtApellido.getText());
        usuario.setClave(new String(vista.txtClave.getPassword()));

        listaUsuarios.add(usuario);
        guardarListaUsuarios(listaUsuarios);

        System.out.println("Usuario guardado correctamente.");
        limpiarCampos();
    }

    private void modificarUsuario() {
        String idBuscado = vista.txtIdUsuario.getText();
        List<ModUsuario> listaUsuarios = leerListaUsuarios();
        boolean encontrado = false;

        for (ModUsuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(idBuscado)) {
                usuario.setNombre(vista.txtNombre.getText());
                usuario.setApellido(vista.txtApellido.getText());
                usuario.setClave(new String(vista.txtClave.getPassword()));
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarListaUsuarios(listaUsuarios);
            System.out.println("Usuario modificado.");
            limpiarCampos();
        } else {
            System.out.println("Id no encontrado");
        }

    }

    private void eliminarUsuario() {
        String idBuscado = vista.txtIdUsuario.getText();
        List<ModUsuario> listaUsuarios = leerListaUsuarios();

        boolean eliminado = listaUsuarios
                .removeIf(usuario -> usuario.getIdUsuario().equals(idBuscado));

        if (eliminado) {
            guardarListaUsuarios(listaUsuarios);
            System.out.println("Usuario eliminado.");
            limpiarCampos();
        } else {
            System.out.println("ID no encontrado.");
        }



    }
}











