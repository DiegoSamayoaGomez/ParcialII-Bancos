package Modelos;

import Vistas.frmCuentas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Samayoa
 */
public class CuentasModel {

    Connection conex;
    frmCuentas VistaCuentas;

    public void AgregarCuentas(int numCuentaP, float saldoCuentaP, String tipoCuentaP) throws SQLException {
        conex = Conexion.conn;
        conex.setAutoCommit(false);
        try {
            JOptionPane.showMessageDialog(null, "ESCUCHANDO...boton AgregarEdificio");
            CallableStatement llamada = conex.prepareCall("{call estudiante.insertarcuentasp(?, ?, ?)}");
            llamada.setInt(1, numCuentaP);
            llamada.setFloat(2, saldoCuentaP);
            llamada.setString(3, tipoCuentaP);
            llamada.execute();
            conex.commit();
            JOptionPane.showMessageDialog(null, "Cuenta CREADA correctamente");

        } catch (Exception ex) {
            conex.rollback();
            JOptionPane.showMessageDialog(null, "Fallo al crear cuenta..." + ex.getMessage());

        }

    }

}
