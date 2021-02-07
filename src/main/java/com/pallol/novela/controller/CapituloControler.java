/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.service.CapituloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CASA PALLOL
 */

@Controller
public class CapituloControler {
    
   @Autowired
    private CapituloService CapituloService;

    @GetMapping("/muestraCapitulo")
    public ModelAndView muestraCapitulo() {
        List<Capitulo> list = CapituloService.muestraCapitulo();
        ModelAndView model = new ModelAndView("muestra_Capitulo");
        model.addObject("Capitulos", list);
        return model;
    }


    @PostMapping("/creaCapitulo")

    public ModelAndView creaUsuario(Capitulo capitulo, Novela novela) {
        ModelAndView model = new ModelAndView("muestra_usuario");
//
//        Rol rol = rolRepository.getOne(2);
//        Capitulo.setRolIdFk(rol);
//        Capitulo = CapituloService.creaOActualizaCapitulo(Capitulo);
//
//        Novela.setNovelaIdFk(Novela);
//        Novela = NovelaRepository.save(Novela);


        return model;
    }

}