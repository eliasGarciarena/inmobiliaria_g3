/*
    Main
 */
import data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Main {
    public static void main(String[] args) {
        Conexion intento = new Conexion();
        Connection establecida = intento.getConexion();
        if(establecida != null){
            try{
                System.out.println("Conexion establecida con exito!\n\nTABLAS DE LA BD inmobiliaria_g3:\n");
                String sql = "SHOW TABLES";
                PreparedStatement ps = establecida.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println("- " + rs.getString(1));
                }
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR AL EJECUTAR CONSULTA\n" + ex, "Consultar Tablas", JOptionPane.ERROR_MESSAGE);
                System.out.println("ERROR AL EJECUTAR CONSULTA\n" + ex);
            }
            
        } else{
            System.out.println("Upss! Ocurrio un accidente :(");
        }
    }
    
}
