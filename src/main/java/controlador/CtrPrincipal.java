package controlador;

import vista.frmPrincipal;

public class CtrPrincipal {
    private frmPrincipal vista;

    public CtrPrincipal (frmPrincipal vista){
        this.vista = vista;
        iniciarVista();
    }

    private void iniciarVista() {
        vista.setVisible(true);
    }
}
