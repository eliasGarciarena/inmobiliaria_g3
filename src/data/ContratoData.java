/*
    ContratoData
 */
package data;

import entities.Contrato_inmueble;
import entities.Inmueble;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class ContratoData {
    private Connection conn = null;
    private InquilinoData inquidata;
    private PropietarioData pd;
    private InmuebleData inmudata;

    public ContratoData(Conexion conexion) {
        conn=conexion.getConexion();
        inquidata=new InquilinoData(conexion);
        inmudata=new InmuebleData(conexion);
    }
    
    
    public boolean agregarContrato(Contrato_inmueble contrato){
        boolean guardado=false;
        try{
            String sql="INSERT INTO `contrato_inmueble`(id_inquilino, id_inmueble, fecha_inicio, fecha_final, marca, observaciones,activo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql,RETURN_GENERATED_KEYS);
            ps.setInt(1, contrato.getInqui().getId());
            ps.setInt(2, contrato.getInmu().getId());
            ps.setDate(3, Date.valueOf(contrato.getFechaInicio()));
            ps.setDate(4, Date.valueOf(contrato.getFechaFinal()));
            ps.setString(5, contrato.getMarca());
            ps.setString(6, contrato.getObservaciones());
            ps.setBoolean(7, contrato.isActivo());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                guardado=true;
                contrato.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha cargado con exito el contrato.");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR con la realizacion del contrato:" +ex);
        }
        return guardado;
    }
    
    public ArrayList<Contrato_inmueble> obtenerContratos(){
        ArrayList<Contrato_inmueble> contratoList= new ArrayList<>();
        try{
            String sql="SELECT * FROM contrato_inmueble WHERE activo=1";
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Contrato_inmueble contra;

            while(rs.next()){
                contra=new Contrato_inmueble();
                contra.setId(rs.getInt("id_contrato"));
                contra.setInqui(inquidata.obtenerInquilinoXId(rs.getInt("id_inquilino")));
                contra.setInmu(inmudata.obtenerInmuebleXId(rs.getInt("id_inmueble")));
                contra.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                contra.setFechaFinal(rs.getDate("fecha_final").toLocalDate());
                contra.setMarca(rs.getString("marca"));
                contra.setObservaciones(rs.getString("observaciones"));
                contra.setActivo(rs.getBoolean("activo"));
                contratoList.add(contra);
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR al obtener todos los contratos:" +ex);
        }
        return contratoList;
    }
    public Contrato_inmueble obtenerContratoXId(int id){
        Contrato_inmueble con=null;
        try{
        String sql="SELECT * FROM contrato_inmueble WHERE id_contrato=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            con=new Contrato_inmueble();
            con.setId(rs.getInt("id_contrato"));
            con.setInqui(inquidata.obtenerInquilinoXId(rs.getInt("id_inquilino")));
            con.setInmu(inmudata.obtenerInmuebleXId(rs.getInt("id_inmueble")));
            con.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
            con.setFechaFinal(rs.getDate("fecha_final").toLocalDate());
            con.setMarca(rs.getString("marca"));
            con.setObservaciones(rs.getString("observaciones"));
            con.setActivo(rs.getBoolean("activo"));
        }
        ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR al obtener el contrato por id"+ex);
        }
        return con;
    }
    public Contrato_inmueble obtenerContratoXInmuebleId(int id){
        Contrato_inmueble contrato=null;
        try{
            String sql="SELECT * FROM contrato_inmueble WHERE id_inmueble=? AND fecha_final>?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id);
            LocalDate fech= LocalDate.now();
            ps.setDate(2, Date.valueOf(fech));
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                contrato=new Contrato_inmueble();
                contrato.setId(rs.getInt("id_contrato"));
                contrato.setInqui(inquidata.obtenerInquilinoXId(rs.getInt("id_inquilino")));
                contrato.setInmu(inmudata.obtenerInmuebleXId(rs.getInt("id_inmueble")));
                contrato.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                contrato.setFechaFinal(rs.getDate("fecha_final").toLocalDate());
                contrato.setMarca(rs.getString("marca"));
                contrato.setObservaciones(rs.getString("observaciones"));
                contrato.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al obtener contrato por id inmueble:"+ ex);
        }
        return contrato;
    }
    public boolean modificacionDeContrato(Contrato_inmueble contrat){
        boolean modific=false;
        try{
            String sql="UPDATE contrato_inmueble SET id_inquilino=?,id_inmueble=?,fecha_inicio=?,fecha_final=?,marca=?,observaciones=?,activo=? WHERE  id_contrato=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, contrat.getInqui().getId());
            ps.setInt(2, contrat.getInmu().getId());
            ps.setDate(3,Date.valueOf(contrat.getFechaInicio()));
            ps.setDate(4,Date.valueOf(contrat.getFechaFinal()));
            ps.setString(5, contrat.getMarca());
            ps.setString(6, contrat.getObservaciones());
            ps.setBoolean(7, contrat.isActivo());
            ps.setInt(8, contrat.getId());
            ps.executeUpdate();
            int rs=ps.executeUpdate();
            if(rs !=0){
                modific=true;
                JOptionPane.showMessageDialog(null, "El contrato fue modificado con exito.");
            }
            ps.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR al modificar el contrato:"+ ex);
        }
        return modific;
    }
    public boolean borrarContrato(int id){
        boolean borra=false;
        try{
            String sql="UPDATE contrato_inmueble SET activo=0 WHERE id_contrato=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rs=ps.executeUpdate();
            if(rs!=0){
                borra=true;
                JOptionPane.showMessageDialog(null, "Se ha borrado con exito el contrato.");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR al intentar borrar el contrato"+ ex);
        }
        return borra;
    }
    public ArrayList<Inmueble> InmueblesAlquilados(){
        ArrayList<Inmueble> inmuebles=null;
        try{
            String sql="SELECT inmueble.* FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND contrato.finalizacion>?";
            LocalDate fech= LocalDate.now();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fech));
            ResultSet rs= ps.executeQuery();
            Inmueble inmu;
            while(rs.next()){
                inmu=new Inmueble();
                inmu.setId(rs.getInt("id_inmueble"));
                inmu.setPropietario(pd.obtenerPropietarioXId(rs.getInt("id_propietario")));
                inmu.setDireccion(rs.getString("direccion"));
                inmu.setZona(rs.getString("Zona"));
                inmu.setEstadoInmueble(rs.getString("estado_inmueble"));
                inmu.setTipoInmueble(rs.getString("tipo_inmueble"));
                inmu.setPrecio(rs.getDouble("precio"));
                inmu.setSuperficie(rs.getDouble("superficie"));
                inmu.setActivo(rs.getBoolean("Activo"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR al traer los inmuebles alquilados al dia:"+ ex);
        }
        return inmuebles;
    }
    public ArrayList<Inmueble> InmueblesNoAlquilados(){
        ArrayList<Inmueble> inmuebles=null;
        try{
            String sql="SELECT inmueble.* FROM contrato , inmueble WHERE \n" +
            "inmueble.activo=1 AND inmueble.idInmueble NOT IN\n" +
            "(SELECT inmueble.idInmueble FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND contrato.finalizacion>?)";
            LocalDate fech= LocalDate.now();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fech));
            ResultSet rs= ps.executeQuery();
            Inmueble inmu;
            while(rs.next()){
                inmu=new Inmueble();
                inmu.setId(rs.getInt("id_inmueble"));
                inmu.setPropietario(pd.obtenerPropietarioXId(rs.getInt("id_propietario")));
                inmu.setDireccion(rs.getString("direccion"));
                inmu.setZona(rs.getString("Zona"));
                inmu.setEstadoInmueble(rs.getString("estado_inmueble"));
                inmu.setTipoInmueble(rs.getString("tipo_inmueble"));
                inmu.setPrecio(rs.getDouble("precio"));
                inmu.setSuperficie(rs.getDouble("superficie"));
                inmu.setActivo(rs.getBoolean("Activo"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR al traer los inmuebles No alquilados:"+ ex);
        }
        return inmuebles;
    }
    
    public ArrayList<Inmueble> obtenerInmueblesAlquiladosXPropietario(Integer id_propietario) {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();
        try {
            String sql="SELECT inmueble.* FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND inmueble.id_propietario=? AND contrato.finalizacion>?";
            LocalDate fech= LocalDate.now();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_propietario);
            ps.setDate(2, Date.valueOf(fech));
            ResultSet resultSet = ps.executeQuery();

            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setId(resultSet.getInt("id_inmueble"));
                inmueble.setPropietario(pd.obtenerPropietarioXId(resultSet.getInt("id_propietario")));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setZona(resultSet.getString("zona"));
                inmueble.setEstadoInmueble(resultSet.getString("estado_inmueble"));
                inmueble.setTipoInmueble(resultSet.getString("tipo_inmueble"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getDouble("superficie"));
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles ALQUILADOS del propietario " + id_propietario + "\n" + ex);
        }

        return inmuebleList;
    }

    public ArrayList<Inmueble> obtenerInmueblesLibresXPropietario(Integer id_propietario) {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();
        try {
            String sql="SELECT inmueble.* FROM contrato , inmueble WHERE \n" +
            "inmueble.activo=1 AND inmueble.id_propietario=? AND inmueble.idInmueble NOT IN\n" +
            "(SELECT inmueble.idInmueble FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND contrato.finalizacion>?)";
            LocalDate fech= LocalDate.now();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_propietario);
            ps.setDate(2, Date.valueOf(fech));
            ResultSet resultSet = ps.executeQuery();

            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setId(resultSet.getInt("id_inmueble"));
                inmueble.setPropietario(pd.obtenerPropietarioXId(resultSet.getInt("id_propietario")));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setZona(resultSet.getString("zona"));
                inmueble.setEstadoInmueble(resultSet.getString("estado_inmueble"));
                inmueble.setTipoInmueble(resultSet.getString("tipo_inmueble"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getDouble("superficie"));
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles LIBRES del propietario " + id_propietario + "\n" + ex);
        }

        return inmuebleList;
    }
}
