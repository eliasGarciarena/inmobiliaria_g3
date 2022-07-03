/*
    Conexion
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Conexion {
    private final String url = "jdbc:mysql://localhost/inmobiliaria_g3";
    private final String usuario = "root";
    private final String password = "universidadg3TUD$";
    private Connection establecida = null;

    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException exc) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DRIVER DE BD\n" + exc.toString());
            System.out.println("ERROR AL CARGAR DRIVER DE BD\n" + exc.toString());
        }
    }

    public Connection getConexion() {
        try {
            if (this.establecida == null) {
                //Establece conexion a db a traves del DriverManager para MariaDB
                this.establecida = DriverManager
                        .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
            }
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTARSE A LA BASE DE DATOS\n" + exc.toString());
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS\n" + exc.toString());
        }
        return this.establecida;
    }
}
