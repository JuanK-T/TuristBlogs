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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column(name = "nombreUsuario", length = 30, nullable = false)
    private String nombreUsuario;

    @Column(name = "telefonoUsuario", nullable = true)
    private long telefonoUsuario;

    @Column(name = "correoUsuario", length = 40, nullable = true)
    private String correoUsuario;

    @Column(name = "fotoUsuario", nullable = true)
    private String fotoUsuario;

    @Column(name = "usuario", length = 20, nullable = false)
    private String user;

    @Column(name = "contrasena", length = 12, nullable = false)
    private String contrasena;

    @Column(name = "rolUsuario", length = 20, nullable = false)
    private String rolUsuario;

    @Column(name = "fechaCreacion", length = 20, nullable = false)
    private String fechaCreacion;

    @Column(name = "idPaisFK", nullable = true)
    private short idPaisFK;

    @ManyToOne
    @JoinColumn(name = "idPaisFK", insertable = false, updatable = false)
    private Pais codPais;

    @OneToMany(mappedBy = "idUser")
    private List<Anuncio> anuncios;

    @OneToMany(mappedBy = "idUsers")
    private List<Preguntas> questions;

    @OneToMany(mappedBy = "idUsers")
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy = "idUsers")
    private List<Blogs> publicaciones;

    @OneToMany(mappedBy = "idUsers")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "idUsers")
    private List<Respuesta> answer;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, long telefonoUsuario, String correoUsuario, String fotoUsuario,
            String user, String contrasena, String rolUsuario, String fechaCreacion, short idPaisFK, Pais pais) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.correoUsuario = correoUsuario;
        this.fotoUsuario = fotoUsuario;
        this.user = user;
        this.contrasena = contrasena;
        this.rolUsuario = rolUsuario;
        this.fechaCreacion = fechaCreacion;
        this.idPaisFK = idPaisFK;
        this.codPais = pais;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public long getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(long telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion){  
        this.fechaCreacion = fechaCreacion;
    }

    public short getIdPaisFK() {
        return idPaisFK;
    }

    public void setIdPaisFK(short idPaisFK) {
        this.idPaisFK = idPaisFK;
    }

    public Pais getPais(){
        return codPais;
    }

    public void setPais(Pais pais){
        this.codPais = pais;
    }
}
