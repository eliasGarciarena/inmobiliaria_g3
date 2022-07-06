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

    private long cuit;
    private String nombreGarante;
    private String apellidoGarante;
    private long  dniGarante;

    public Inquilino(int id, String nombre, String apellido, long dni,long cuit, long telefono, boolean activo, String nombreGarante, String apellidoGarante, long dniGarante) {
        super(id, nombre, apellido, dni, telefono, activo);
        this.nombreGarante = nombreGarante;
        this.apellidoGarante = apellidoGarante;
        this.dniGarante = dniGarante;
        this.cuit=cuit;
    }
        public Inquilino(String nombre, String apellido, long dni,long cuit, long telefono, boolean activo,String nombreGarante, String apellidoGarante, long dniGarante) {
        super(nombre, apellido, dni, telefono, activo);
        this.nombreGarante = nombreGarante;
        this.apellidoGarante = apellidoGarante;
        this.dniGarante = dniGarante;
        this.cuit=cuit;
    }


    public Inquilino() {
    }


    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getApellidoGarante() {
        return apellidoGarante;
    }

    public void setApellidoGarante(String apellidoGarante) {
        this.apellidoGarante = apellidoGarante;
    }

    public long getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(long dniGarante) {
        this.dniGarante = dniGarante;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
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
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
