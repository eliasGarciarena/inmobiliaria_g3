/*
    Inquilino
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Grupo3_LabI
 */
public class Inquilino extends Persona {

    private char detalle;
    private char tipo;
    public ArrayList<Inmueble> propiedades;

    public Inquilino(int id, String nombre, String apellido, long dni, long telefono, char detalle, char tipo, boolean activo) {
        super(id, nombre, apellido, dni, telefono, activo);
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public Inquilino(String nombre, String apellido, long dni, long telefono, char detalle, char tipo, boolean activo) {
        super(nombre, apellido, dni, telefono, activo);
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public Inquilino() {
    }

    public char getDetalle() {
        return detalle;
    }

    public char getTipo() {
        return tipo;
    }

    public ArrayList<Inmueble> getPropiedades() {
        return propiedades;
    }

    public void setDetalle(char detalle) {
        this.detalle = detalle;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setPropiedades(ArrayList<Inmueble> propiedades) {
        this.propiedades = propiedades;
    }
}
