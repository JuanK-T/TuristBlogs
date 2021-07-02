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
@Table(name = "sugerencia")
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSugerencia;

    @Column(name = "contenidoSugerencia", nullable = false)
    private String contenidoSugerencia;

    @Column(name = "fechaPublicacion", nullable = false)
    private String fechaPublicacion;

    @Column(name = "correoPersona", length = 40, nullable = true)
    private String correoPersona;

    @Column(name = "respuesta", nullable = true)
    private String respuesta;

    @Column(name = "idUsuarioFK", nullable = true)
    private int idUsuarioFK;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUsers;
    
    public Sugerencia() {
    }

    public Sugerencia(int idSugerencia, String contenidoSugerencia, String fechaPublicacion, String correoPersona,
            String respuesta, int idUsuarioFK) {
        this.idSugerencia = idSugerencia;
        this.contenidoSugerencia = contenidoSugerencia;
        this.fechaPublicacion = fechaPublicacion;
        this.correoPersona = correoPersona;
        this.respuesta = respuesta;
        this.idUsuarioFK = idUsuarioFK;
    }

    public int getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(int idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getContenidoSugerencia() {
        return contenidoSugerencia;
    }

    public void setContenidoSugerencia(String contenidoSugerencia) {
        this.contenidoSugerencia = contenidoSugerencia;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(int idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }    
}
