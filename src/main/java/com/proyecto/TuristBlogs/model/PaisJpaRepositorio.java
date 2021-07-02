package com.proyecto.TuristBlogs.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisJpaRepositorio extends JpaRepository<Pais, Short>{
    
}
