package com.proyecto.TuristBlogs.dto;

import com.proyecto.TuristBlogs.model.Pais;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private int idUsuario;
    private String nombreUsuario;
    private long telefonoUsuario;
    private String correoUsuario;
    private String fotoUsuario;
    private String user;
    private String contrasena;
    private String fechaCreacion;
    private String rolUsuario;
    private short idPaisFK;
    private Pais pais;
}
