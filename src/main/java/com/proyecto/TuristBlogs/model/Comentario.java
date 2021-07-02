package com.proyecto.TuristBlogs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(name = "comentario", length = 350, nullable = false)
    private String comentario;

    @Column(name = "fechaPublicacion", nullable = false)
    private String fechaPublicacion;

    @Column(name = "idUsuarioFK", nullable = false)
    private int idUsuarioFK;

    @Column(name = "idBlogFK", nullable = false)
    private int idBlogFK;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUsers;

    @ManyToOne
    @JoinColumn(name = "idBlogFK", insertable = false, updatable = false)
    private Blogs publicacion;

    @OneToMany(mappedBy = "comentar")
    private List<Respuesta> answer;
    
    public Comentario() {
    }

    public Comentario(int idComentario, String comentario, String fechaPublicacion, int idUsuarioFK, int idBlogFK) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioFK = idUsuarioFK;
        this.idBlogFK = idBlogFK;
    }
    public int getIdComentario() {
        return idComentario;
    }
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
    public int getIdBlogFK() {
        return idBlogFK;
    }
    public void setIdBlogFK(int idBlogFK) {
        this.idBlogFK = idBlogFK;
    }

    
}
