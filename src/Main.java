/*
    Main
 */
import data.Conexion;
import java.sql.Connection;

/**
 *
 * @author Grupo3_LabI
 */
public class Main {
    public static void main(String[] args) {
        Conexion intento = new Conexion();
        Connection establecida = intento.getConexion();
        if(establecida != null){
            System.out.println("Conexion establecida con exito!");
        } else{
            System.out.println("Upss! Ocurrio un accidente :(");
        }
    }
    
}
