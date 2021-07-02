package com.proyecto.TuristBlogs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//Esto va a corresponder a la tabla que se llama Pais 
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idPais;

    @Column(name = "codigo", length = 2, nullable = false)
    private String codigo;

    @Column(name = "nombrePais", length = 30, nullable = false)
    private String nombrePais;

    @OneToMany(mappedBy = "codPais")
    private List<Usuario> usuarios;

    public Pais() {
    }

    public Pais(String nombrePais) {
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
