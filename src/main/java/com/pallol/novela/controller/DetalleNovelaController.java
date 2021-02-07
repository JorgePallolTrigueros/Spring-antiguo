/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.service.NovelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetalleNovelaController {

    @Autowired
    private NovelaService novelaService;

    @GetMapping("/detalleNovela/{id}")
    public ModelAndView muestraNoveladetalle(@PathVariable("id") int id) {

        Novela novela = novelaService.muestraNovelaConDetallesPorId(id);

        ModelAndView model = new ModelAndView("detallenovela");
        model.addObject("novela", novela);
        return model;
    }

    //añadir una p alfinal
    @GetMapping("/detallenovelap/{id}")
    public ModelAndView muestraNivelaP(@PathVariable("id") int id) {
        Novela novela = novelaService.muestraNovelaConDetallesPorId(id);
        ModelAndView model = new ModelAndView("protect1/detallenovelap");
        model.addObject("novela", novela);
        return model;
    }

    
    
    
    
}
