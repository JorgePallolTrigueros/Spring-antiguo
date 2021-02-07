/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Product;
import com.pallol.novela.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CASA PALLOL
 */
@Controller
public class ProcuctoControler {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/muestraproducto")
    public ModelAndView muestraUsuario() {
        List<Product> list = productoService.muestraProducto();
        ModelAndView model = new ModelAndView("muestra_producto");
        model.addObject("productos", list);
        return model;
    }

}
