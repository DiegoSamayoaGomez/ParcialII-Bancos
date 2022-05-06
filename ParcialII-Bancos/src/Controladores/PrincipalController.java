/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.CuentasModel;
import Modelos.DepositosModel;
import Vistas.frmCuentas;
import Vistas.frmDepositos;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samayoa
 */
public class PrincipalController implements ActionListener {

    frmPrincipal VistaPrincipal;
    frmCuentas VistaCuentas;
    frmDepositos VistaDepositos;

    /* frmEdificios VistaEdificios;
   EdificiosModel ModeloEdificios;*/
    public PrincipalController(frmPrincipal VistaPrincipal) {
        this.VistaPrincipal = VistaPrincipal;
        this.VistaPrincipal.btnCuentas.addActionListener(this);
        this.VistaPrincipal.btnDepositos.addActionListener(this);
        this.VistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.VistaPrincipal.btnCuentas) {

            frmCuentas VistaCuentas = new frmCuentas(VistaPrincipal, true);
            CuentasModel ModeloCuentas = new CuentasModel();
            CuentasController ControladorCuentas = new CuentasController(VistaCuentas, ModeloCuentas);
        }

        if (e.getSource() == this.VistaPrincipal.btnDepositos) {
            frmDepositos VistaDepositos = new frmDepositos(VistaPrincipal, true);
            DepositosModel ModeloDepositos = new DepositosModel();
            DepositosController ControladorDepositos = new DepositosController(VistaDepositos, ModeloDepositos);

        }

    }

}
