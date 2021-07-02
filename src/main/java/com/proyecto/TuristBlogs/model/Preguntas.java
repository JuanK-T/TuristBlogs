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
@Table(name = "preguntas")
public class Preguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column(name = "contenidoPregunta", nullable = false)
    private String contenidoPregunta;

    @Column(name = "fechaPublicacion", nullable = false)
    private String fechaPublicacion;

    @Column(name = "correoPersona", length = 40, nullable = false)
    private String correoPersona;

    @Column(name = "respuesta", nullable = true)
    private String respuesta;

    @Column(name = "idUsuarioFK", nullable = true)
    private int idUsuarioFK;
    
    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUsers;

    public Preguntas() {
    }

    public Preguntas(int idPregunta, String contenidoPregunta, String fechaPublicacion, String correoPersona,
            String respuesta, int idUsuarioFK) {
        this.idPregunta = idPregunta;
        this.contenidoPregunta = contenidoPregunta;
        this.fechaPublicacion = fechaPublicacion;
        this.correoPersona = correoPersona;
        this.respuesta = respuesta;
        this.idUsuarioFK = idUsuarioFK;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getContenidoPregunta() {
        return contenidoPregunta;
    }

    public void setContenidoPregunta(String contenidoPregunta) {
        this.contenidoPregunta = contenidoPregunta;
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
