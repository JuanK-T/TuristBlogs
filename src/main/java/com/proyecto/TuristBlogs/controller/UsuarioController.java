package com.proyecto.TuristBlogs.controller;

import java.util.HashMap;
import java.util.List;

import com.proyecto.TuristBlogs.dto.PaisDto;
import com.proyecto.TuristBlogs.dto.UsuarioDto;
import com.proyecto.TuristBlogs.form.UsuarioForm;
import com.proyecto.TuristBlogs.service.IMSPais;
import com.proyecto.TuristBlogs.service.IMSUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IMSPais paisService;

    @Autowired
    IMSUsuario userService;

    @GetMapping("/show")
    public ModelAndView showUser(){

        //Obtener atravez del servicio
        List<UsuarioDto> usuarios = userService.getAll();
        //
        List<PaisDto> paisDto = paisService.getAll();

        var params = new HashMap<String, Object>();
        //put nos sirve para agregar datos al mapa que trabajamos
        params.put("listUser", usuarios);
        params.put("listPais", paisDto);

        return new ModelAndView("usuario", params);
    }

    @GetMapping("/new")
    public ModelAndView newUsuario(){
        UsuarioForm form = new UsuarioForm();
        form.setUsuarioDto(new UsuarioDto());
        form.setLisPais(paisService.getAll());

        var params = new HashMap<String, Object>();

        params.put("form", form);
        return new ModelAndView("usuarioForm", params);
    }

    @PostMapping(value = "/save")
    public ModelAndView save(UsuarioForm usForm) {
        userService.save(usForm.getUsuarioDto());
        return new ModelAndView("redirect:/usuario/show");
    }

    @GetMapping(value = "/edit/{idUsuario}")
    public ModelAndView editUsuario(@ModelAttribute("idUsuario") Integer idUsuario) {

        UsuarioForm form = new UsuarioForm();
        form.setUsuarioDto(userService.get(idUsuario));
        form.setLisPais(paisService.getAll());
    
        var params = new HashMap<String, Object>();
        params.put("form", form);

        return new ModelAndView("usuarioForm", params);

    }


    @GetMapping(value = "/delete/{idUsuario}")
    public ModelAndView deleteUsuario(@ModelAttribute("idUsuario") Integer idUsuario) {
        userService.delete(idUsuario);
        return new ModelAndView("redirect:/usuario/show");
    }
}
