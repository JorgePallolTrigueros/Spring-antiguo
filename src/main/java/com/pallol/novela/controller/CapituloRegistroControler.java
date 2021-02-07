
package com.pallol.novela.controller;


import com.pallol.novela.entities.Capitulo;
import org.springframework.ui.Model;
import com.pallol.novela.entities.Novela;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


public class CapituloRegistroControler {
        // Estos Son Los Controladores del Insert
    
       @GetMapping("/registrocapitulo")
    public String registro(Novela novela, Capitulo capitulo, Model model) {
        model.addAttribute("persona", capitulo);
        model.addAttribute("novela", novela);
        return "registrocapitulo";
    } 
     
    
    @GetMapping("/registrocapitulo")
    public ModelAndView formularic() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    //Estos son los controladores del update

           @GetMapping("/registrocapitulou")
    public String registrocapitulou(Novela novela, Capitulo capitulo, Model model) {
        model.addAttribute("persona", capitulo);
        model.addAttribute("novela", novela);
        return "Updatecapitulo";
    } 
    
    @GetMapping("/registrocapitulo")
    public ModelAndView registro() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
        //Estos son los controladores del delete

    @GetMapping("/deleteocapitulo")
    public ModelAndView borrarcapitulo() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    
}
