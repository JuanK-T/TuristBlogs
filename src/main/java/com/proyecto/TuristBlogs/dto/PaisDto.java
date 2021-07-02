package com.proyecto.TuristBlogs.dto;

public class PaisDto {
    
    private short idPais;
    private String codigo;
    private String nombrePais;

    public PaisDto() {
    }

    public PaisDto(short idPais, String codigo, String nombrePais) {
        this.idPais = idPais;
        this.codigo = codigo;
        this.nombrePais = nombrePais;
    }

    public short getIdPais() {
        return idPais;
    }

    public void setIdPais(short idPais) {
        this.idPais = idPais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }    
}
