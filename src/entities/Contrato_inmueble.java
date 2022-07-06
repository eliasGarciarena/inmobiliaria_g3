/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Contrato_inmueble {
    private int id;
    private Inquilino inqui;
    private Inmueble inmu;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String marca;
    private String observaciones;
    private boolean activo;

    public Contrato_inmueble(int id, Inquilino inqui, Inmueble inmu, LocalDate fechaInicio, LocalDate fechaFinal, String marca, String observaciones, boolean activo) {
        this.id = id;
        this.inqui = inqui;
        this.inmu = inmu;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.marca = marca;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Contrato_inmueble(Inquilino inqui, Inmueble inmu, LocalDate fechaInicio, LocalDate fechaFinal, String marca, String observaciones, boolean activo) {
        this.inqui = inqui;
        this.inmu = inmu;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.marca = marca;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inquilino getInqui() {
        return inqui;
    }

    public void setInqui(Inquilino inqui) {
        this.inqui = inqui;
    }

    public Inmueble getInmu() {
        return inmu;
    }

    public void setInmu(Inmueble inmu) {
        this.inmu = inmu;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "codigo contrato:"+id+" inquilino:"+inqui.getNombre()+" "+inqui.getApellido()+" Fecha incio:"+fechaInicio+" fecha final contrato:"+fechaFinal; 
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
