/*
    Main
 */
import data.Conexion;
import data.PropietarioData;
import entities.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class Main {
    public static void main(String[] args) {
        Conexion intento = new Conexion();
        PropietarioData pd=new PropietarioData(intento);
        Propietario p=pd.obtenerPropietarioXDni(3112662);
        System.out.println(p);
        //Propietario prop=new Propietario(3,"Marianela","Carcajada",1368902,266516778,"Barrio nuevo de los ancianos",true);
        //pd.borrarPropietario(1);
        //Propietario buscado=pd.obtenerPropietarioXId(1);
        //System.out.println(buscado);
        //pd.modificarPropietario(prop);
        /*pd.agregarPropietario(prop);
        ArrayList<Propietario> propietarios=pd.obtenerPropietarios();
        for(Propietario prop:propietarios){
            System.out.println(prop);
        }*/
    //    Connection establecida = intento.getConexion();
      /*  if(establecida != null){
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
    */
    }
}
