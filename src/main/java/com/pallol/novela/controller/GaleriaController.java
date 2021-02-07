/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.entities.Novela;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CASA PALLOL
 */
@Controller
public class GaleriaController {
    
    
    
    
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
