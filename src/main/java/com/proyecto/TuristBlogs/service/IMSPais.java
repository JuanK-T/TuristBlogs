package com.proyecto.TuristBlogs.service;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.TuristBlogs.dto.PaisDto;
import com.proyecto.TuristBlogs.model.Pais;
import com.proyecto.TuristBlogs.model.PaisJpaRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMSPais implements ISPais {

    @Autowired
    private PaisJpaRepositorio repoPais;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaisDto save(PaisDto pais) {
        //todo lo que me llega de los parametros lo mapeare a la entity
        Pais paisEntity = modelMapper.map(pais, Pais.class);
        //ejecuto la operacion en la capa de persistencia
        repoPais.save(paisEntity);
        //Vuelvo a matear de los entitis a la clase DTO
        return modelMapper.map(paisEntity, PaisDto.class);
    }

    @Override
    public PaisDto get(Short id) {
        Pais paisEntity = repoPais.getById(id);
        PaisDto paisDto = modelMapper.map(paisEntity, PaisDto.class);
        return paisDto;
    }

    @Override
    public List<PaisDto> getAll() {
        List<Pais> listPEntity = repoPais.findAll();
        List<PaisDto> listPDTOEntity = 
            listPEntity.stream().map(role -> modelMapper.map(role, PaisDto.class)).collect(Collectors.toList());
        return listPDTOEntity;
    }

    @Override
    public void delete(Short id) {      
        repoPais.deleteById(id);     
    }
}
