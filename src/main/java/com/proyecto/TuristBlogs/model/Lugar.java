package com.proyecto.TuristBlogs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lugar")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;

    @Column(name = "nombreLugar", length = 30, nullable = false)
    private String nombreLugar;

    @Column(name = "idCiudadFK", nullable = false)
    private int idCiudadFK;

    @Column(name = "direccionLugar", length = 50, nullable = false)
    private String direccionLugar;

    @Column(name = "idTipoLugarFK", nullable = false)
    private int idTipoLugarFK;

    @ManyToOne
    @JoinColumn(name = "idCiudadFK", insertable = false, updatable = false)
    private Ciudad ciudades;

    @ManyToOne
    @JoinColumn(name = "idTipoLugarFK", insertable = false, updatable = false)
    private TipoLugar tipoL;
    
    public Lugar() {
    }

    public Lugar(int idLugar, String nombreLugar, int idCiudadFK, String direccionLugar, int idTipoLugarFK) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.idCiudadFK = idCiudadFK;
        this.direccionLugar = direccionLugar;
        this.idTipoLugarFK = idTipoLugarFK;
    }

    public int getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }
    public String getNombreLugar() {
        return nombreLugar;
    }
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    public int getIdCiudadFK() {
        return idCiudadFK;
    }
    public void setIdCiudadFK(int idCiudadFK) {
        this.idCiudadFK = idCiudadFK;
    }
    public String getDireccionLugar() {
        return direccionLugar;
    }
    public void setDireccionLugar(String direccionLugar) {
        this.direccionLugar = direccionLugar;
    }
    public int getIdTipoLugarFK() {
        return idTipoLugarFK;
    }
    public void setIdTipoLugarFK(int idTipoLugarFK) {
        this.idTipoLugarFK = idTipoLugarFK;
    }    
}
