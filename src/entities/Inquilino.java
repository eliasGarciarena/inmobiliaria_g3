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
    private String tipo;

    public Inquilino(int id, String nombre, String apellido, long dni, long telefono, char detalle, String tipo, boolean activo) {
        super(id, nombre, apellido, dni, telefono, activo);
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public Inquilino(String nombre, String apellido, long dni, long telefono, char detalle, String tipo, boolean activo) {
        super(nombre, apellido, dni, telefono, activo);
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public Inquilino() {
    }

    public char getDetalle() {
        return detalle;
    }

    public String getTipo() {
        return tipo;
    }


    public void setDetalle(char detalle) {
        this.detalle = detalle;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
