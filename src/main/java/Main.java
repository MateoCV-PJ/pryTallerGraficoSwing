import vista.frmPrincipal;
import controlador.CtrPrincipal;

public class Main {
    public static void main(String[] args) {
        frmPrincipal vista = new frmPrincipal();
        CtrPrincipal controlador = new CtrPrincipal(vista);
    }
}
