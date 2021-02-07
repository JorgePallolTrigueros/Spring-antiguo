/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Personaje;
import com.pallol.novela.service.PersonajeService;
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
public class PersonajeControler {
    
   @Autowired
    private PersonajeService PersonajeService;



    @PostMapping("/creaPersonaje")

    public ModelAndView creaPersonaje(Personaje Personaje, Novela novela) {
        ModelAndView model = new ModelAndView("muestra_usuario");
//
//        Rol rol = rolRepository.getOne(2);
//        Personaje.setRolIdFk(rol);
//        Personaje = PersonajeService.creaOActualizaPersonaje(Personaje);
//
//        Novela.setNovelaIdFk(Novela);
//        Novela = NovelaRepository.save(Novela);


        return model;
    }

}