package com.proyecto.TuristBlogs.service;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.TuristBlogs.dto.UsuarioDto;
import com.proyecto.TuristBlogs.model.Usuario;
import com.proyecto.TuristBlogs.model.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMSUsuario implements ISUsuario{
    @Autowired
    private UsuarioRepository repoUsuario;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario userEntity = modelMapper.map(usuarioDto, Usuario.class);
        userEntity = repoUsuario.save(userEntity);
        return modelMapper.map(userEntity, UsuarioDto.class);
    }

    @Override
    public UsuarioDto get(Integer id) {
        Usuario userEntity = repoUsuario.getById(id);
        UsuarioDto usuarioDto = modelMapper.map(userEntity, UsuarioDto.class);
        return usuarioDto;
     }

    @Override
    public List<UsuarioDto> getAll() {
        List<Usuario> listUserEntity = repoUsuario.findAll();
        List<UsuarioDto> listUDtoEntity = listUserEntity.stream().map(role -> modelMapper.map(role, UsuarioDto.class)).collect(Collectors.toList());
        return listUDtoEntity;
    }

    @Override
    public void delete(Integer id) {
        repoUsuario.deleteById(id);
    }

    

}
