package com.proyecto.TuristBlogs.form;

import java.util.List;

import com.proyecto.TuristBlogs.dto.PaisDto;
import com.proyecto.TuristBlogs.dto.UsuarioDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioForm {
    private UsuarioDto usuarioDto;
    private PaisDto paisDto;
    private List<PaisDto> lisPais;   
}
