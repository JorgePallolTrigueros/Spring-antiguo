
package com.pallol.novela.controller;


import org.springframework.ui.Model;
import com.pallol.novela.entities.Novela;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


public class NovelaRegistroControler {
        // Estos Son Los Controladores del Insert
    
       @GetMapping("/registronovela")
    public String registro(Novela novela, Model model) {
        model.addAttribute("persona", novela);
        model.addAttribute("novela", novela);
        return "registronovela";
    } 
     
    
    @GetMapping("/registronovela")
    public ModelAndView formularic() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    //Estos son los controladores del update

           @GetMapping("/registronovelau")
    public String registronovelau(Novela novela, Model model) {
        model.addAttribute("persona", novela);
        model.addAttribute("novela", novela);
        return "Updatenovela";
    } 
    
    @GetMapping("/registronovela")
    public ModelAndView registro() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
        //Estos son los controladores del delete

    @GetMapping("/deleteonovela")
    public ModelAndView borrarnovela() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    
}
