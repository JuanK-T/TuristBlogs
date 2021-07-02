package com.proyecto.TuristBlogs.controller;

import java.util.HashMap;

import com.proyecto.TuristBlogs.dto.PaisDto;
import com.proyecto.TuristBlogs.form.PaisForm;
import com.proyecto.TuristBlogs.service.ISPais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.var;


@Controller
@RequestMapping("/pais")
public class PaisController {
    
    @Autowired
    ISPais Paservice;

    //ruta
    @GetMapping(value = "/show")
    public ModelAndView show(){ 
        var params = new HashMap<String, Object>();
        params.put("LisPais", Paservice.getAll());
        return new ModelAndView("pais", params);
    }   

    @GetMapping(value = "/new")
    public ModelAndView newPais(){
        //Variable que recibe los parametros que se envairan a la vista
        var params = new HashMap<String, Object>();

        PaisForm form = new PaisForm();
        form.setPaisDto(new PaisDto());
        params.put("form", form);

        //Le envio a la vista todo los datos necesarios para la vista
        return new ModelAndView("paisForm", params);
    }

    @GetMapping("/edit/{idPais}")
    public ModelAndView editPais(@ModelAttribute("idPais") Short idPais){
        var params = new HashMap<String, Object>();
        PaisForm form = new PaisForm();
        form.setPaisDto(Paservice.get(idPais));
        params.put("form", form);
        return new ModelAndView("paisForm", params);
    }


    @PostMapping(value = "/save")
    //este metodo va a recibir los datos del formulario
    public ModelAndView savePais(PaisForm form){
        Paservice.save(form.getPaisDto());
        return new ModelAndView("redirect:/pais/show");
    }

    @GetMapping(value = "/delete/{idPais}")
    public ModelAndView deletePais(@ModelAttribute("idPais") Short idPais){
        Paservice.delete(idPais); 
        return new ModelAndView("redirect:/pais/show");       
    }
}
