/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Novela;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author CASA PALLOL
 */
public class NuevaNovelaControler {
    
    
        @GetMapping("/nuevaNovela")
    public String registro(Novela movela, Model model) {
        model.addAttribute("movela", movela);
        return "registro";
    }
    
}
