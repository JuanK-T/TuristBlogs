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
@Table(name = "subtitulos")
public class Subtitulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubtitulo;

    @Column(name = "subtitulo", length = 30, nullable = false)
    private String subtitulo;

    @Column(name = "contenidoSubtitulo", nullable = false)
    private String contenidoSubtitulo;

    @Column(name = "imagen", nullable = true)
    private String imagen;

    @Column(name = "idBlogFK", nullable = false)
    private int idBlogFK;

    @ManyToOne
    @JoinColumn(name = "idBlogFK", insertable = false, updatable = false)
    private Blogs publicacion;

    public Subtitulos() {
    }
    public Subtitulos(int idSubtitulo, String subtitulo, String contenidoSubtitulo, String imagen, int idBlogFK) {
        this.idSubtitulo = idSubtitulo;
        this.subtitulo = subtitulo;
        this.contenidoSubtitulo = contenidoSubtitulo;
        this.imagen = imagen;
        this.idBlogFK = idBlogFK;
    }
    public int getIdSubtitulo() {
        return idSubtitulo;
    }
    public void setIdSubtitulo(int idSubtitulo) {
        this.idSubtitulo = idSubtitulo;
    }
    public String getSubtitulo() {
        return subtitulo;
    }
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
    public String getContenidoSubtitulo() {
        return contenidoSubtitulo;
    }
    public void setContenidoSubtitulo(String contenidoSubtitulo) {
        this.contenidoSubtitulo = contenidoSubtitulo;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public int getIdBlogFK() {
        return idBlogFK;
    }
    public void setIdBlogFK(int idBlogFK) {
        this.idBlogFK = idBlogFK;
    }
    
    
}
