/*
    InmuebleData
 */
package data;

import entities.Inmueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo3_LabI
 */
public class InmuebleData {

    private Connection conn = null;

    public InmuebleData(Conexion conexion) {

        conn = conexion.getConexion();

    }

    public boolean AgregarInmueble(Inmueble inmueble) {
        String querySql = "INSERT INTO inmueble (id_inquilino,id_propietario,direccion,zona,estado_inmueble,tipo_inmueble,precio,caracteristicas,superficiemin,forma,activo)  VALUES (?, ?,?,?,?,?,?,?,?,?,? )";

        boolean insert = true;
        try {
            PreparedStatement ps = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inmueble.getInquilino().getId());
            ps.setInt(2, inmueble.getPropietario().getId());
            ps.setString(3, inmueble.getDireccion());
            ps.setString(4, inmueble.getZona());
            ps.setString(5, Character.toString(inmueble.getEstadoLocal()));
            ps.setString(6, Character.toString(inmueble.getTipoLocal()));
            ps.setDouble(7, inmueble.getPrecioTrazado());
            ps.setString(8, inmueble.getCaracteristicas());
            ps.setLong(9, inmueble.getSuperficieMin());
            ps.setString(10, inmueble.getForma());
            ps.setBoolean(10, inmueble.isActivo());

            ps.executeUpdate();

            //Obtenemos el id asignado por la base de datos
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inmueble.setId(rs.getInt(1));
            } else {
                insert = false;
            }
            ps.close();
        } catch (SQLException ex) {
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe un alumno con ese dni ");
            } else {
                JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);
            }
        }
        return insert;
    }

    public ArrayList<Inmueble> ObtenerInmuebles() {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inmueble WHERE activo=1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();                
                inmueble.setId(resultSet.getInt("id_inmueble"));                
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los inmuebles");
        }

        return inmuebleList;
    }
}
