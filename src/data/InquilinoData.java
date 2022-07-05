/*
    InquilinoData
 */
package data;

import entities.Inquilino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.internal.util.dao.PrepareResult;

/**
 *
 * @author Grupo3_LabI
 */
public class InquilinoData {
    private Connection con=null;

    public InquilinoData(Conexion conexion) {
        con=conexion.getConexion();
    }
    
    public boolean agregarInquilino(Inquilino inqui){
        boolean agregar=false;
        try{
            String sql="INSERT INTO inquilino(nombre, apellido, dni, detalle, tipo_inm, telefono, activo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql,RETURN_GENERATED_KEYS);
            ps.setString(1,inqui.getNombre());
            ps.setString(2,inqui.getApellido());
            ps.setLong(3,inqui.getDni());
            ps.setString(4,String.valueOf(inqui.getDetalle()));
            ps.setString(5,inqui.getTipo());
            ps.setLong(6,inqui.getTelefono());
            ps.setBoolean(7,inqui.isActivo());
            ps.executeUpdate();
            ResultSet result=ps.getGeneratedKeys();
            if(result.next()){
                inqui.setId(result.getInt(1));
                agregar=true;
                JOptionPane.showMessageDialog(null, "Se ha agregado con exito el inquilino.");
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al agregar inquilino: "+ ex);
        }
        return agregar;
    }
    public ArrayList<Inquilino> obtenerInquilinos(){
        ArrayList<Inquilino> inquilinos=new ArrayList<Inquilino>();
        try{
            String sql="SELECT * FROM inquilino WHERE activo=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet result=ps.executeQuery();
            Inquilino inqui;
            while(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setDetalle(result.getString("detalle").charAt(0));
                inqui.setTipo(result.getString("tipo_inm"));
                inqui.setTelefono(result.getLong("telefono"));
                inqui.setActivo(result.getBoolean("activo"));
                inquilinos.add(inqui);
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al conseguir lista de INquilinos"+ex);
        }
        return inquilinos;
    }
    public Inquilino obtenerInquilinoXId(int id){
        Inquilino inqui=null;
        try{
            String sql="SELECT * FROM inquilino WHERE id_inquilino=? AND activo=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result=ps.executeQuery();
            while(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setDetalle(result.getString("detalle").charAt(0));
                inqui.setTipo(result.getString("tipo_inm"));
                inqui.setTelefono(result.getLong("telefono"));
                inqui.setActivo(result.getBoolean("activo"));
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al obtener Inquilino por id: "+ex);
        }
        return inqui;
    }
    public Inquilino obtenerInquilinoXDni(long dni){
        Inquilino inqui=null;
        try{
            String sql="SELECT * FROM inquilino WHERE dni=? AND activo=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1, dni);
            ResultSet result= ps.executeQuery();
            if(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setDetalle(result.getString("detalle").charAt(0));
                inqui.setTipo(result.getString("tipo_inm"));
                inqui.setTelefono(result.getLong("telefono"));
                inqui.setActivo(result.getBoolean("activo"));
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al obtener Inquilino por dni"+ex);
        }
        return inqui;
    }
    public boolean modificarInquilino(Inquilino inqui){
        boolean modi=false;
        try{
            String sql="UPDATE inquilino SET nombre=?, apellido=?,dni=?,detalle=?,tipo_inm=?,telefono=?,activo=? WHERE id_inquilino=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, inqui.getNombre());
            ps.setString(2, inqui.getApellido());
            ps.setLong(3, inqui.getDni());
            ps.setString(4, String.valueOf(inqui.getDetalle()));
            ps.setString(5, inqui.getTipo());
            ps.setLong(6, inqui.getTelefono());
            ps.setBoolean(7, inqui.isActivo());
            ps.setInt(8, inqui.getId());
            int result=ps.executeUpdate();
            if(result!=0){
                modi=true;
                JOptionPane.showMessageDialog(null, "El Inquilino fue modificado con exito");
            }
           ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al modificar el Inquilino: "+ ex);
        }
        return modi;
    }
    public boolean borrarInquilino(int id){
        boolean borrado=false;
        try{
            String sql="UPDATE inquilino SET activo=0 WHERE id_inquilino=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()!=0){
                borrado=true;
                JOptionPane.showMessageDialog(null, "Se ha borrado el inquilino con exito");
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(null,"Error al tratar de borrar el inquilino:"+ex);
        }
        return borrado;
    }
}
