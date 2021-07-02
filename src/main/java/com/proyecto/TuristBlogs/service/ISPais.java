package com.proyecto.TuristBlogs.service;

import java.util.List;

import com.proyecto.TuristBlogs.dto.PaisDto;

public interface ISPais {
    
    public  PaisDto save(PaisDto paisito);//registrar y actualizar
    public PaisDto get(Short id );//consultar un registro por su id
    public List<PaisDto> getAll();//consultar todos los registros
    public void delete(Short id);//eliminar un registro por su id
}
