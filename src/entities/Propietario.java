/*
    Propietario
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Grupo3_LabI
 */
public class Propietario extends Persona {

    private String domicilio;

    public Propietario(int id, String nombre, String apellido, long dni, long telefono, String domicilio, boolean activo) {
        super(id, nombre, apellido, dni, telefono, activo);
        this.domicilio = domicilio;
    }

    public Propietario(String nombre, String apellido, long dni, long telefono, String domicilio, boolean activo) {
        super(nombre, apellido, dni, telefono, activo);
        this.domicilio = domicilio;
    }

    public Propietario() {
    }

    public String getDomicilio() {
        return domicilio;
    }


    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

}
