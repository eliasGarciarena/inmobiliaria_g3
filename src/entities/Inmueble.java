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
    private String accesibilidad;
    private String caracteristicas;
    private String direccion;
    private Propietario propietario;
    private char estadoLocal;
    private String forma;
    private Inquilino inquilino;
    private float precioTrazado;
    private Persona inspector;
    private int superficieMin;
    private char tipoLocal;
    private String zona;

    public int getId() {
        return id;
    }

    public String getAccesibilidad() {
        return accesibilidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getDireccion() {
        return direccion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public char getEstadoLocal() {
        return estadoLocal;
    }

    public String getForma() {
        return forma;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public float getPrecioTrazado() {
        return precioTrazado;
    }

    public Persona getInspector() {
        return inspector;
    }

    public int getSuperficieMin() {
        return superficieMin;
    }

    public char getTipoLocal() {
        return tipoLocal;
    }

    public String getZona() {
        return zona;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccesibilidad(String accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setEstadoLocal(char estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public void setPrecioTrazado(float precioTrazado) {
        this.precioTrazado = precioTrazado;
    }

    public void setInspector(Persona inspector) {
        this.inspector = inspector;
    }

    public void setSuperficieMin(int superficieMin) {
        this.superficieMin = superficieMin;
    }

    public void setTipoLocal(char tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public void setZona(String zona) {
        this.zona = zona;
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
