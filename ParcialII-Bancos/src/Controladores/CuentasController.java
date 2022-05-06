package Controladores;

import Modelos.CuentasModel;
import Vistas.frmCuentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Samayoa
 */
public class CuentasController implements ActionListener {

    frmCuentas VistaCuentas;
    CuentasModel ModeloCuentas;

    public CuentasController(frmCuentas VistaCuentas, CuentasModel ModeloCuentas) {
        this.VistaCuentas = VistaCuentas;
        this.ModeloCuentas = ModeloCuentas;
        //LEVANTAR LA VISTA CUENTAS Y PONER A LA ESCUCHA LOS BOTONES DE LA VISTA
        this.VistaCuentas.btnCrearCuenta.addActionListener(this);
        this.VistaCuentas.setLocationRelativeTo(null);
        this.VistaCuentas.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.VistaCuentas.btnCrearCuenta) {
            try {
                this.ModeloCuentas.AgregarCuentas(
                        Integer.parseInt(this.VistaCuentas.txtNoCuenta.getText()),
                        Float.parseFloat(this.VistaCuentas.txtSaldoCuenta.getText()),
                        this.VistaCuentas.txtTipoCuenta.getText());
                VistaCuentas.txtNoCuenta.setText("");
                VistaCuentas.txtSaldoCuenta.setText("");
                VistaCuentas.txtTipoCuenta.setText("");
                VistaCuentas.txtNoCuenta.requestFocus();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error... Fallo al crear cuenta: " + ex);
            }
        }
    }

}
