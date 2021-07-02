package com.proyecto.TuristBlogs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etiquetas")
public class Etiquetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtiqueta;

    @Column(name = "nombreEtiqueta", length = 30, nullable = false)
    private String nombreEtiqueta;
    
    public Etiquetas() {
    }

    public Etiquetas(int idEtiqueta, String nombreEtiqueta) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    
}
