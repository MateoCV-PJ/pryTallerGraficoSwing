package controlador;

import vista.frmCliente;
import vista.frmPrincipal;
import vista.frmUsuario;

import controlador.CtrUsuario;
import controlador.CtrCliente;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CtrPrincipal implements MouseListener {
    private frmPrincipal vista;

    public CtrPrincipal (frmPrincipal vista){
        this.vista = vista;

        this.vista.menuUsuario.addMouseListener(this);
        this.vista.menuCliente.addMouseListener(this);
        this.vista.menuSalir.addMouseListener(this);

        iniciarVista();
    }

    private void iniciarVista() {
        vista.setVisible(true);
    }

    //Manaje la logica de los formularios
    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        //Abrir formulario Usuario
        if (e.getSource() == vista.menuUsuario) {
            frmUsuario frmU = new frmUsuario();
            CtrUsuario ctrU = new CtrUsuario(frmU);
            frmU.setVisible(true);
        }

        //Abrir formulario Cliente
        if (e.getSource() == vista.menuCliente) {
            frmCliente frmC = new frmCliente();
            CtrCliente ctrC = new CtrCliente(frmC);
            frmC.setVisible(true);
        }

        //Salir de la aplicacion
        if (e.getSource() == vista.menuSalir) {
            System.exit(0); //Cierra la aplicacion
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
