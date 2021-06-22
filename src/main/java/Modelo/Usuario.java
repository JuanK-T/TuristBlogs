package Modelo;

import java.io.InputStream;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private long telefono;
    private String correo;
    private String user;
    private String contrasena;
    private String fechaCreacion;
    private InputStream fotoUsuario;

    //Constructor vacio
    public Usuario(){

    }

    //Se realiza un encapsulamiento
    public Usuario(int idUsuarioIn, String nombreIn, long telefonoIn, String correoIn, String userIn,
                   String contrasenaIn, String fechaCreacionIn, InputStream fotoUsuarioIn){
        super();
        this.idUsuario = idUsuarioIn;
        this.nombre = nombreIn;
        this.telefono = telefonoIn;
        this.correo = correoIn;
        this.user = userIn;
        this.contrasena = contrasenaIn;
        this.fechaCreacion = fechaCreacionIn;
        this.fotoUsuario = fotoUsuarioIn;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public InputStream getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(InputStream fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
}
