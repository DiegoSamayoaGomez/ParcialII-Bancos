/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.frmLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dmiranda
 */
public class Conexion {

    public static Connection conn = null;

    public Conexion(String user, String pass) {
        try {
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", user, pass);

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", user, pass);
            JOptionPane.showMessageDialog(null, "Se ha conectado Satisfactoriamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexión Fallida..." + e.getMessage());
        }

    }
}
