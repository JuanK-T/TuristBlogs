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
@Table(name = "blogs")
public class Blogs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBlogs;

    @Column(name = "tituloBlog", length = 30, nullable = false)
    private String tituloBlog;

    @Column(name = "contenidoBlog", nullable = false)
    private String contenidoBlog;

    @Column(name = "imagenPortada", nullable = true)
    private String imagenPortada;

    @Column(name = "estatusBlog", length = 8, nullable = false)
    private String estatusBlog;

    @Column(name = "visitas", nullable = true)
    private int visitas;

    @Column(name = "fechaCreacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "idUsuarioFK",nullable = false)
    private int idUsuarioFK;

    @Column(name = "idTemaFK", nullable = false)
    private int idTemaFK;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", insertable = false, updatable = false)
    private Usuario idUsers;

    @ManyToOne
    @JoinColumn(name = "idTemaFK", insertable = false, updatable = false)
    private Tema idTem;

    @OneToMany(mappedBy = "publicacion")
    private List<Subtitulos> subtitulo;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;


    public Blogs() {
    }
    public Blogs(int idBlogs, String tituloBlog, String contenidoBlog, String imagenPortada, String estatusBlog,
            int visitas, String fechaCreacion, int idUsuarioFK, int idTemaFK) {
        this.idBlogs = idBlogs;
        this.tituloBlog = tituloBlog;
        this.contenidoBlog = contenidoBlog;
        this.imagenPortada = imagenPortada;
        this.estatusBlog = estatusBlog;
        this.visitas = visitas;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioFK = idUsuarioFK;
        this.idTemaFK = idTemaFK;
    }

    public int getIdBlogs() {
        return idBlogs;
    }
    public void setIdBlogs(int idBlogs) {
        this.idBlogs = idBlogs;
    }
    public String getTituloBlog() {
        return tituloBlog;
    }
    public void setTituloBlog(String tituloBlog) {
        this.tituloBlog = tituloBlog;
    }
    public String getContenidoBlog() {
        return contenidoBlog;
    }
    public void setContenidoBlog(String contenidoBlog) {
        this.contenidoBlog = contenidoBlog;
    }
    public String getImagenPortada() {
        return imagenPortada;
    }
    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }
    public String getEstatusBlog() {
        return estatusBlog;
    }
    public void setEstatusBlog(String estatusBlog) {
        this.estatusBlog = estatusBlog;
    }
    public int getVisitas() {
        return visitas;
    }
    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public int getIdUsuarioFK() {
        return idUsuarioFK;
    }
    public void setIdUsuarioFK(int idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }
    public int getIdTemaFK() {
        return idTemaFK;
    }
    public void setIdTemaFK(int idTemaFK) {
        this.idTemaFK = idTemaFK;
    }    
}
