
import Controladores.loginController;
import Vistas.frmLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samayoa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmLogin VistaLogin = new frmLogin(null, true);
        loginController nuevoControladorLogin = new loginController(VistaLogin);
    }

}
