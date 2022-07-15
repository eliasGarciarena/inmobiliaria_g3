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
        pd = new PropietarioData(conexion);
    }

    public boolean AgregarInmueble(Inmueble inmueble) {
        String querySql = "INSERT INTO inmueble (id_propietario, direccion, zona, estado_inmueble, tipo_inmueble, precio, superficie)  VALUES (?,?,?,?,?,?,?)";

        boolean insert = true;
        try {
            PreparedStatement ps = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inmueble.getPropietario().getId());
            ps.setString(2, inmueble.getDireccion());
            ps.setString(3, inmueble.getZona());
            ps.setString(4, inmueble.getEstadoInmueble());
            ps.setString(5, inmueble.getTipoInmueble());
            ps.setDouble(6, inmueble.getPrecio());
            ps.setDouble(7, inmueble.getSuperficie());
            ps.executeUpdate();

            // Obtenemos el id asignado por la base de datos
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inmueble.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha agregado con exito el inmueble");
            } else {
                insert = false;
            }
            ps.close();
        } catch (SQLException ex) {
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe un inmueble con ese ID");
            } else {
                JOptionPane.showMessageDialog(null, "Error de sintaxis\n" + ex);
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
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al obtener todos inmuebles",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return inmuebleList;
    }

    public ArrayList<Inmueble> ObtenerInmueblesAlquilados() {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inmueble WHERE activo=1 AND id_inmueble "
                    + "IN (SELECT id_inmueble FROM contrato_inmueble WHERE activo=1)";
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
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles ALQUILADOS\n" + ex);
        }

        return inmuebleList;
    }

    public ArrayList<Inmueble> ObtenerInmueblesLibres() {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inmueble WHERE activo=1 AND id_inmueble "
                    + "NOT IN (SELECT id_inmueble FROM contrato_inmueble WHERE activo=1)";
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
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles LIBRES");
        }

        return inmuebleList;
    }

    public Inmueble obtenerInmuebleXId(int id) {
        Inmueble inmu = null;
        try {
            String sql = "SELECT * From inmueble WHERE id_inmueble=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inmu = new Inmueble();
                inmu.setId(rs.getInt("id_inmueble"));
                inmu.setPropietario(pd.obtenerPropietarioXId(rs.getInt("id_propietario")));
                inmu.setDireccion(rs.getString("direccion"));
                inmu.setZona(rs.getString("Zona"));
                inmu.setEstadoInmueble(rs.getString("estado_inmueble"));
                inmu.setTipoInmueble(rs.getString("tipo_inmueble"));
                inmu.setPrecio(rs.getDouble("precio"));
                inmu.setSuperficie(rs.getDouble("superficie"));
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inmueble con ID\n" + ex);
        }
        return inmu;
    }

    public ArrayList<Inmueble> ObtenerInmueblesAlquiladosXPropietario(Integer id_propietario) {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inmueble WHERE activo=1 AND id_propietario="
                    + id_propietario + " AND id_inmueble IN (SELECT id_inmueble FROM contrato_inmueble WHERE activo=1)";
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
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles ALQUILADOS del propietario " + id_propietario + "\n" + ex);
        }

        return inmuebleList;
    }

    public ArrayList<Inmueble> ObtenerInmueblesLibresXPropietario(Integer id_propietario) {
        ArrayList<Inmueble> inmuebleList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inmueble WHERE activo=1 AND id_propietario="
                    + id_propietario + " AND id_inmueble NOT IN (SELECT id_inmueble FROM contrato_inmueble WHERE activo=1)";
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
                inmuebleList.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Inmuebles LIBRES del propietario " + id_propietario + "\n" + ex);
        }

        return inmuebleList;
    }

    public boolean modificarInmueble(Inmueble inmu) {
        boolean modi = false;
        try {
            String sql = "UPDATE inmueble SET id_propietario=?,direccion=?,zona=?,estado_inmueble=?,tipo_inmueble=?,precio=?,superficie=? WHERE id_inmueble=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inmu.getPropietario().getId());
            ps.setString(2, inmu.getDireccion());
            ps.setString(3, inmu.getZona());
            ps.setString(4, inmu.getEstadoInmueble());
            ps.setString(5, inmu.getTipoInmueble());
            ps.setDouble(6, inmu.getPrecio());
            ps.setDouble(7, inmu.getSuperficie());
            ps.setInt(8, inmu.getId());
            int rs = ps.executeUpdate();
            if (rs != 0) {
                modi = true;
                JOptionPane.showMessageDialog(null, "Inmueble modificado con exito.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de modificar el Inmueble\n" + ex);
        }
        return modi;
    }

    public boolean borrarInmueble(int id) {
        boolean borrado = false;
        try {
            String sql = "UPDATE inmueble SET activo=0 WHERE id_inmueble=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                borrado = true;
                JOptionPane.showMessageDialog(null, "El inmueble se ha borrado con exito.");
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR al borrar Inmueble\n" + ex);
        }
        return borrado;
    }
}
