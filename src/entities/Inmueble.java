/*
    Inmueble
 */
package entities;

/**
 *
 * @author Grupo3_LabI
 */
public class Inmueble {

    private int id;
    private Propietario propietario;
    private String direccion;
    private String zona;
    private String tipoInmueble;
    private String estadoInmueble;
    private double precio;
    private double superficie;
    private boolean activo;

    public Inmueble() {
    }

    public Inmueble(int id, Propietario propietario, String direccion, String zona, String tipoInmueble, String estadoInmueble, double precio, double superficie, boolean activo) {
        this.id = id;
        this.propietario = propietario;
        this.direccion = direccion;
        this.zona = zona;
        this.tipoInmueble = tipoInmueble;
        this.estadoInmueble = estadoInmueble;
        this.precio = precio;
        this.superficie = superficie;
        this.activo = activo;
    }

    public Inmueble(Propietario propietario, String direccion, String zona, String tipoInmueble, String estadoInmueble, double precio, double superficie, boolean activo) {
        this.propietario = propietario;
        this.direccion = direccion;
        this.zona = zona;
        this.tipoInmueble = tipoInmueble;
        this.estadoInmueble = estadoInmueble;
        this.precio = precio;
        this.superficie = superficie;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getEstadoInmueble() {
        return estadoInmueble;
    }

    public void setEstadoInmueble(String estadoInmueble) {
        this.estadoInmueble = estadoInmueble;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return getId() + " - " + getDireccion();
    }

    @Override
    public int hashCode() {
        return 75 * 4 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inmueble other = (Inmueble) obj;
        return this.id == other.id;
    }
}
