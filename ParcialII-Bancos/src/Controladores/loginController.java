/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import Modelos.CuentasModel;
import Vistas.frmCuentas;
import Vistas.frmLogin;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Samayoa
 */
public class loginController implements ActionListener {

    frmLogin VistaLogin;
    //BANCOS

    public loginController(frmLogin VistaLogin) {
        this.VistaLogin = VistaLogin;

        this.VistaLogin.setLocationRelativeTo(null);
        this.VistaLogin.btnConectar.addActionListener(this);
        this.VistaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.VistaLogin.btnConectar) {
            try {
                Conexion conect = new Conexion(this.VistaLogin.txtUser.getText(), this.VistaLogin.txtPass.getText());
                if (Conexion.conn.isValid(0)) {
                    this.VistaLogin.dispose();
                    frmPrincipal VistaPrincipal = new frmPrincipal();
                    frmCuentas VistaCuentas = new frmCuentas(VistaPrincipal, true);
                    CuentasModel ModeloCuentas = new CuentasModel();
                    PrincipalController nuevoControladorPrincipal = new PrincipalController(VistaPrincipal);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "NO no  no");
            }
        }
    }

}
