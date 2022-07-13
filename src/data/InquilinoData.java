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
        System.out.println("Agregar Inquilino");
        boolean agregar=false;
        try{
            String sql="INSERT INTO inquilino(nombre, apellido, dni, cuit, telefono, nombre_Garante, apellido_garante, dni_garante, activo) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql,RETURN_GENERATED_KEYS);
            ps.setString(1,inqui.getNombre());
            ps.setString(2,inqui.getApellido());
            ps.setLong(3,inqui.getDni());
            ps.setLong(4,inqui.getCuit());
            ps.setLong(5,inqui.getTelefono());
            ps.setString(6,inqui.getNombreGarante());
            ps.setString(7,inqui.getApellidoGarante());
            ps.setLong(8,inqui.getDniGarante());
            ps.setBoolean(9,inqui.isActivo());
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
            String sql="SELECT * FROM inquilino";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet result=ps.executeQuery();
            Inquilino inqui;
            while(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setCuit(result.getLong("cuit"));
                inqui.setNombreGarante(result.getString("nombre_garante"));
                inqui.setApellidoGarante(result.getString("apellido_garante"));
                inqui.setDniGarante(result.getLong("dni_garante"));
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

    public ArrayList<Inquilino> obtenerInquilinosActivos(){
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
                inqui.setCuit(result.getLong("cuit"));
                inqui.setNombreGarante(result.getString("nombre_garante"));
                inqui.setApellidoGarante(result.getString("apellido_garante"));
                inqui.setDniGarante(result.getLong("dni_garante"));
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

    public ArrayList<Inquilino> obtenerInquilinosInactivos(){
        ArrayList<Inquilino> inquilinos=new ArrayList<Inquilino>();
        try{
            String sql="SELECT * FROM inquilino WHERE activo=0";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet result=ps.executeQuery();
            Inquilino inqui;
            while(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setCuit(result.getLong("cuit"));
                inqui.setNombreGarante(result.getString("nombre_garante"));
                inqui.setApellidoGarante(result.getString("apellido_garante"));
                inqui.setDniGarante(result.getLong("dni_garante"));
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
            String sql="SELECT * FROM inquilino WHERE id_inquilino=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result=ps.executeQuery();
            while(result.next()){
                inqui=new Inquilino();
                inqui.setId(result.getInt("id_inquilino"));
                inqui.setNombre(result.getString("nombre"));
                inqui.setApellido(result.getString("apellido"));
                inqui.setDni(result.getLong("dni"));
                inqui.setCuit(result.getLong("cuit"));
                inqui.setNombreGarante(result.getString("nombre_garante"));
                inqui.setApellidoGarante(result.getString("apellido_garante"));
                inqui.setDniGarante(result.getLong("dni_garante"));
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
                inqui.setCuit(result.getLong("cuit"));
                inqui.setNombreGarante(result.getString("nombre_garante"));
                inqui.setApellidoGarante(result.getString("apellido_garante"));
                inqui.setDniGarante(result.getLong("dni_garante"));
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
            String sql="UPDATE inquilino SET nombre=?, apellido=?,dni=?,cuit=?,telefono=?,nombre_garante=?,apellido_garante=?,dni_garante=?,activo=? WHERE id_inquilino=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, inqui.getNombre());
            ps.setString(2, inqui.getApellido());
            ps.setLong(3, inqui.getDni());
            ps.setLong(4, inqui.getCuit());
            ps.setLong(5, inqui.getTelefono());
            ps.setString(6, inqui.getNombreGarante());
            ps.setString(7, inqui.getApellidoGarante());
            ps.setLong(8, inqui.getDniGarante());
            ps.setBoolean(9, inqui.isActivo());
            ps.setInt(10, inqui.getId());
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
