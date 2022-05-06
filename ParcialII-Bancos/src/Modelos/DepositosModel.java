package Modelos;

import Vistas.frmDepositos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Samayoa
 */
public class DepositosModel {

    Connection conex;
    frmDepositos VistaDepositos;

    //fechaDepositoP date, cantidadDepositoP float, idCuentaP int
    public void AgregarDepositos(String fechaDepositoP, float cantidadDepositoP, int idCuentaP) throws SQLException {
        conex = Conexion.conn;
        conex.setAutoCommit(false);

        try {
            JOptionPane.showMessageDialog(null, "ESCUCHANDO...boton AgregarEdificio");

            CallableStatement llamada = conex.prepareCall("{call estudiante.insertardepositosP(?, ?, ?)}");
            llamada.setString(1, fechaDepositoP);
            llamada.setFloat(2, cantidadDepositoP);
            llamada.setInt(3, idCuentaP);
            llamada.execute();

            conex.commit();
            JOptionPane.showMessageDialog(null, "Deposito INSERTADO correctamente");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fallo al realizar deposito..." + ex.getMessage());
            conex.rollback();
        }

    }

}
