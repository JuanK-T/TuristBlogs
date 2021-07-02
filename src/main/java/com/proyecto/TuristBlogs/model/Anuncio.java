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
@Table( name = "anuncio")
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnuncio;

    @Column(name = "mensajeAnuncio", nullable = false)
    private String mensajeAnuncio;

    @Column(name = "imagenAnuncio", nullable = false)
    private String imagenAnuncio;

    @Column(name = "idUsuarioFK", nullable = true)
    private int idUsuarioFK;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUser;

    public Anuncio() {
    }

    public Anuncio(int idAnuncio, String mensajeAnuncio, String imagenAnuncio, int idUsuarioFK) {
        this.idAnuncio = idAnuncio;
        this.mensajeAnuncio = mensajeAnuncio;
        this.imagenAnuncio = imagenAnuncio;
        this.idUsuarioFK = idUsuarioFK;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getMensajeAnuncio() {
        return mensajeAnuncio;
    }

    public void setMensajeAnuncio(String mensajeAnuncio) {
        this.mensajeAnuncio = mensajeAnuncio;
    }

    public String getImagenAnuncio() {
        return imagenAnuncio;
    }

    public void setImagenAnuncio(String imagenAnuncio) {
        this.imagenAnuncio = imagenAnuncio;
    }

    public int getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(int idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }
}
