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
    private PropietarioData pd;

    public InmuebleData(Conexion conexion) {

        conn = conexion.getConexion();
        pd =new PropietarioData(conexion);
    }

    public boolean AgregarInmueble(Inmueble inmueble) {
        String querySql = "INSERT INTO inmueble (id_propietario, direccion, zona, estado_inmueble, tipo_inmueble, precio, superficie, activo)  VALUES (?,?,?,?,?,?,?,?)";

        boolean insert = true;
        try {
            PreparedStatement ps = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inmueble.getPropietario().getId());
            ps.setString(2, inmueble.getDireccion());
            ps.setString(3, inmueble.getZona());
            ps.setString(4, inmueble.getEstadoInmueble());
            ps.setString(5,inmueble.getTipoInmueble());
            ps.setDouble(6,inmueble.getPrecio());
            ps.setDouble(7, inmueble.getSuperficie());
            ps.setBoolean(8, inmueble.isActivo());
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
                inmueble.setPropietario(pd.obtenerPropietarioXId(resultSet.getInt("id_propietario")));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setZona(resultSet.getString("zona"));
                inmueble.setEstadoInmueble(resultSet.getString("estado_inmueble"));
                inmueble.setTipoInmueble(resultSet.getString("tipo_inmueble"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getDouble("superficie"));
                inmueble.setActivo(resultSet.getBoolean("activo"));
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los inmuebles");
        }

        return inmuebleList;
    }
}
