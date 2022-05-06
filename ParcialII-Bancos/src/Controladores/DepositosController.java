package Controladores;

import Modelos.CuentasModel;
import Modelos.DepositosModel;
import Vistas.frmCuentas;
import Vistas.frmDepositos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Samayoa
 */
public class DepositosController implements ActionListener {

    frmDepositos VistaDepositos;
    DepositosModel ModeloDepositos;

    public DepositosController(frmDepositos VistaDepositos, DepositosModel ModeloDepositos) {
        this.VistaDepositos = VistaDepositos;
        this.ModeloDepositos = ModeloDepositos;

        this.VistaDepositos.btnDepositos.addActionListener(this);
        this.VistaDepositos.setLocationRelativeTo(null);
        this.VistaDepositos.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.VistaDepositos.btnDepositos) {
            try {

                this.ModeloDepositos.AgregarDepositos(
                        this.VistaDepositos.txtFechaDeposito.getText(),
                        Float.parseFloat(this.VistaDepositos.txtCantidadDeposito.getText()),
                        Integer.parseInt(this.VistaDepositos.txtIdCuentaDeposito.getText()));
                System.out.println(this.VistaDepositos.txtFechaDeposito.getText()
                        + Float.parseFloat(this.VistaDepositos.txtCantidadDeposito.getText())
                        + Integer.parseInt(this.VistaDepositos.txtIdCuentaDeposito.getText()));

                VistaDepositos.txtFechaDeposito.setText("");
                VistaDepositos.txtCantidadDeposito.setText("");
                VistaDepositos.txtIdCuentaDeposito.setText("");
                VistaDepositos.txtFechaDeposito.requestFocus();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fallo al realizar deposito... " + ex);
            }
        }
    }

}
