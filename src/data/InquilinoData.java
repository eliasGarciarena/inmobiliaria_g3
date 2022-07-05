/*
    InquilinoData
 */
package data;

import java.sql.Connection;

/**
 *
 * @author Grupo3_LabI
 */
public class InquilinoData {
    private Connection con=null;

    public InquilinoData(Conexion conexion) {
        con=conexion.getConexion();
    }
    
}
