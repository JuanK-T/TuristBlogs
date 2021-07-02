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
@Table(name = "tipoLugar")
public class TipoLugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoLugar;
    
    @Column(name = "tipoLugar", length = 30, nullable = false)
    private String tipoLugar;

    @OneToMany(mappedBy = "tipoL")
    private List<Lugar> lugares;

    public TipoLugar() {
    }
    public TipoLugar(int idTipoLugar, String tipoLugar) {
        this.idTipoLugar = idTipoLugar;
        this.tipoLugar = tipoLugar;
    }
    public int getIdTipoLugar() {
        return idTipoLugar;
    }
    public void setIdTipoLugar(int idTipoLugar) {
        this.idTipoLugar = idTipoLugar;
    }
    public String getTipoLugar() {
        return tipoLugar;
    }
    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }
}
