
package com.pallol.novela.controller;


import com.pallol.novela.entities.Personaje;
import org.springframework.ui.Model;
import com.pallol.novela.entities.Novela;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


public class PersonajeRegistroControler {
        // Estos Son Los Controladores del Insert
    
       @GetMapping("/registroPersonaje")
    public String registro(Novela novela, Personaje Personaje, Model model) {
        model.addAttribute("persona", Personaje);
        model.addAttribute("novela", novela);
        return "registroPersonaje";
    } 
     
    
    @GetMapping("/registroPersonaje")
    public ModelAndView formularic() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    //Estos son los controladores del update

           @GetMapping("/registroPersonajeu")
    public String registroPersonajeu(Novela novela, Personaje Personaje, Model model) {
        model.addAttribute("persona", Personaje);
        model.addAttribute("novela", novela);
        return "UpdatePersonaje";
    } 
    
    @GetMapping("/registroPersonaje")
    public ModelAndView registro() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
        //Estos son los controladores del delete

    @GetMapping("/deleteoPersonaje")
    public ModelAndView borrarPersonaje() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    
}
