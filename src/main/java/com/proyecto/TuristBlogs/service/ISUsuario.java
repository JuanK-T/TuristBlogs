package com.proyecto.TuristBlogs.service;

import java.util.List;

import com.proyecto.TuristBlogs.dto.UsuarioDto;

public interface ISUsuario {
    public UsuarioDto save(UsuarioDto usuarioDto);
    public UsuarioDto get(Integer id);
    public List<UsuarioDto> getAll();
    public void delete(Integer id);
}
