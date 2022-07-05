/*
    PropietarioData
 */
package data;

import entities.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class PropietarioData {
    private Connection con=null;

    public PropietarioData(Conexion conexion) {
        con=conexion.getConexion();
    }
    public boolean agregarPropietario(Propietario propietario){ 
        boolean agrego=false;
        try{
            String sql="INSERT INTO propietario(nombre, apellido, dni, domicilio, telefono, activo)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,propietario.getNombre());
            ps.setString(2,propietario.getApellido());
            ps.setLong(3,propietario.getDni());
            ps.setString(4,propietario.getDomicilio());
            ps.setLong(5,propietario.getTelefono());
            ps.setBoolean(6,propietario.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                propietario.setId(rs.getInt(1));
                agrego=true;
                JOptionPane.showMessageDialog(null,"Propietario agregado con exito" );
            }
            ps.close();
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error al intentar agregar la materia","Error al agregar propietario",JOptionPane.ERROR_MESSAGE );
        }
        
        return true;
    }
    public ArrayList<Propietario> obtenerPropietarios(){
        ArrayList<Propietario> propietarios=new ArrayList<Propietario>();
        try{
            String sql="SELECT * FROM propietario WHERE activo=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet result=ps.executeQuery();
            Propietario prop;
            while(result.next()){
                prop=new Propietario();
                prop.setId(result.getInt("id_propietario"));
                prop.setNombre(result.getString("nombre"));
                prop.setApellido(result.getString("apellido"));
                prop.setDni(result.getLong("dni"));
                prop.setDomicilio(result.getString("domicilio"));
                prop.setTelefono(result.getLong("telefono"));
                prop.setActivo(result.getBoolean("activo"));
                propietarios.add(prop);
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al conseguir lista de propietarios"+ex);
        }
        return propietarios;
    }
    public Propietario obtenerPropietarioXId(int id){
        Propietario prop=null;
        try{
            String sql="SELECT * FROM propietario WHERE id_propietario=? AND activo=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet result=ps.executeQuery();
            while(result.next()){
                prop=new Propietario();
                prop.setId(result.getInt("id_propietario"));
                prop.setNombre(result.getString("nombre"));
                prop.setApellido(result.getString("apellido"));
                prop.setDni(result.getLong("dni"));
                prop.setDomicilio(result.getString("domicilio"));
                prop.setTelefono(result.getLong("telefono"));
                prop.setActivo(result.getBoolean("activo"));
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al obtener propietarion por id: "+ex);
        }
        return prop;
    }
    public Propietario obtenerPropietarioXDni(long dni){
        Propietario prop=null;
        try{
            String sql="SELECT * FROM propietario WHERE dni=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1, dni);
            ResultSet result= ps.executeQuery();
            while(result.next()){
                prop=new Propietario();
                prop.setId(result.getInt("id_propietario"));
                prop.setNombre(result.getString("nombre"));
                prop.setApellido(result.getString("apellido"));
                prop.setDni(result.getLong("dni"));
                prop.setDomicilio(result.getString("domicilio"));
                prop.setTelefono(result.getLong("telefono"));
                prop.setActivo(result.getBoolean("activo"));
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al obtener propietario por id "+ex);
        }
        return prop;
    }
    public boolean modificarPropietario(Propietario prop){
        boolean modi=false;
        try{
            String sql="UPDATE propietario SET nombre=?, apellido=?,dni=?,domicilio=?,"
                    + "telefono=?,activo=? WHERE id_propietario=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, prop.getNombre());
            ps.setString(2, prop.getApellido());
            ps.setLong(3, prop.getDni());
            ps.setString(4, prop.getDomicilio());
            ps.setLong(5, prop.getTelefono());
            ps.setBoolean(6, prop.isActivo());
            ps.setInt(7, prop.getId());
            int result=ps.executeUpdate();
            if(result!=0){
                modi=true;
                JOptionPane.showMessageDialog(null, "El propietario fue modificado con exito");
            }
           ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al modificar el propietario"+ ex);
        }
        return modi;
    }
    public boolean borrarPropietario(int id){
        boolean borrado=false;
        try{
            String sql="UPDATE propietario SET activo=0 WHERE id_propietario=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()!=0){
                borrado=true;
                JOptionPane.showMessageDialog(null, "Se ha borrado el propietario con exito");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al borrar propietario "+ ex);
        }
        return borrado;
    }
}
