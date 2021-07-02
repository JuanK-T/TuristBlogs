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
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "respuesta", length = 240, nullable = false)
    private String respuesta;

    @Column(name = "fechaPublicacion", nullable = false)
    private String fechaPublicacion;

    @Column(name = "idUsuarioFK", nullable = false)
    private int idUsuarioFK;

    @Column(name = "idComentarioFK", nullable = false)
    private int idComentarioFK;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUsers;

    @ManyToOne
    @JoinColumn(name = "idComentarioFK", insertable = false, updatable = false)
    private Comentario comentar;

    public Respuesta() {
    }
    public Respuesta(int idRespuesta, String respuesta, String fechaPublicacion, int idUsuarioFK, int idComentarioFK) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioFK = idUsuarioFK;
        this.idComentarioFK = idComentarioFK;
    }
    public int getIdRespuesta() {
        return idRespuesta;
    }
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public int getIdUsuarioFK() {
        return idUsuarioFK;
    }
    public void setIdUsuarioFK(int idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }
    public int getIdComentarioFK() {
        return idComentarioFK;
    }
    public void setIdComentarioFK(int idComentarioFK) {
        this.idComentarioFK = idComentarioFK;
    }

    
}
