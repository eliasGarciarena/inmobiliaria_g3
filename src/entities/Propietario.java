/*
    Propietario
 */
package entities;


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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return getId()+" - "+ getNombre()+" "+getApellido(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
