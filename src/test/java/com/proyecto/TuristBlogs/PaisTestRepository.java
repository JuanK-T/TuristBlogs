package com.proyecto.TuristBlogs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.proyecto.TuristBlogs.model.Pais;
import com.proyecto.TuristBlogs.model.PaisJpaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase
public class PaisTestRepository {

    @Autowired
    PaisJpaRepositorio paisJpaRepositorio;
    
    public void paisTest(){
        Pais pais1 = new Pais("Colombia");  
        paisJpaRepositorio.save(pais1);
        paisJpaRepositorio.flush();

    }
}
