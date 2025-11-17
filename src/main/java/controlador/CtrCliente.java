package controlador;

import vista.frmCliente;
import modelo.ModCliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CtrCliente implements ActionListener{
    private frmCliente vista;
    private final String ARCHIVO = "clientes.json";
    private String accionActual = "NINGUNA";

    public CtrCliente(frmCliente vista) {
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
                case "GUARDAR":
                    guardarCliente();
                    break;
                case "MODIFICAR":
                    modificarCliente();
                    break;
                case "ELIMINAR":
                    eliminarCliente();
                    break;
                default:
                    System.out.println("Seleccione una opción del menú.");
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }

    private void prepararVistaGuardar() {
        accionActual = "GUARDAR";
        vista.btnAccion.setText("Guardar");
        vista.btnAccion.setVisible(true);

        setVisibilidadCampos(true);
        limpiarCampos();
    }

    private void prepararVistaModificar(){
        accionActual = "MODIFICAR";
        vista.btnAccion.setText("Modificar");
        vista.btnAccion.setVisible(true);

        setVisibilidadCampos(true);
        limpiarCampos();
    }

    private void prepararVistaEliminar(){
        accionActual = "Eliminar";
        vista.btnAccion.setText("Eliminar");
        vista.btnAccion.setVisible(true);

        setVisibilidadCampos(false);
        vista.lblId.setVisible(true);
        vista.txtIdCliente.setVisible(true);
        limpiarCampos();
    }

    private void setVisibilidadCampos(boolean visible) {
        vista.lblId.setVisible(true);
        vista.txtIdCliente.setVisible(true);

        vista.lblNombre.setVisible(visible);
        vista.txtNombre.setVisible(visible);
        vista.lblApellido.setVisible(visible);
        vista.txtApellido.setVisible(visible);
        vista.lblEmail.setVisible(visible);
        vista.txtEmail.setVisible(visible);
        vista.lblGenero.setVisible(visible);
        vista.cmbGenero.setVisible(visible);
    }


    private List<ModCliente>  leerListaClientes() {
        Gson gson = new Gson();
        List<ModCliente> lista = new ArrayList<>();
        File f = new File(ARCHIVO);

        if (f.exists()) {
            try (Reader reader = new FileReader(f)) {
                Type listType = new TypeToken<ArrayList<ModCliente>>(){}.getType();
                lista = gson.fromJson(reader, listType);
                if (lista == null) lista = new ArrayList<>();
            } catch (Exception e) {
                System.out.println("Error de lectura: " + e.getMessage());
            }
        }
        return lista;
    }

    private void guardarListaClientes(List<ModCliente> lista) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        vista.txtIdCliente.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtEmail.setText("");
        vista.cmbGenero.setSelectedIndex(0);
    }

    private void guardarCliente() {
        List<ModCliente> listaClientes = leerListaClientes();
        ModCliente cliente = new ModCliente();

        cliente.setIdCliente(vista.txtIdCliente.getText());
        cliente.setNombre(vista.txtNombre.getText());
        cliente.setApellido(vista.txtApellido.getText());
        cliente.setEmail(vista.txtEmail.getText());
        if (vista.cmbGenero.getSelectedItem() != null) {
            cliente.setGenero(vista.cmbGenero.getSelectedItem().toString());
        }

        listaClientes.add(cliente);
        guardarListaClientes(listaClientes);

        System.out.println("Cliente guardado correctamente");
        limpiarCampos();
    }

    private void modificarCliente() {
        String idBuscado = vista.txtIdCliente.getText();
        List<ModCliente> listaClientes = leerListaClientes();
        boolean encontrado = false;

        for (ModCliente cliente : listaClientes) {
            if (cliente.getIdCliente().equals(idBuscado)) {
                cliente.setNombre(vista.txtNombre.getText());
                cliente.setApellido(vista.txtApellido.getText());
                cliente.setEmail(vista.txtEmail.getText());
                if (vista.cmbGenero.getSelectedItem() != null) {
                    cliente.setGenero(vista.cmbGenero.getSelectedItem().toString());
                }
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardarListaClientes(listaClientes);
            System.out.println("Cliente modificado");
            limpiarCampos();
        } else {
            System.out.println("ID no encontrado");
        }
    }

    private void eliminarCliente() {
        String idBuscado = vista.txtIdCliente.getText();
        List<ModCliente> listaClientes = leerListaClientes();

        boolean eliminado = listaClientes.removeIf(cliente -> cliente.getIdCliente().equals(idBuscado));

        if (eliminado) {
            guardarListaClientes(listaClientes);
            System.out.println("Cliente eliminado.");
            limpiarCampos();
        } else {
            System.out.println("ID no enocntrado.");
        }
    }
}

















