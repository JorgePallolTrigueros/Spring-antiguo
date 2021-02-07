
package com.pallol.novela.controller;


import com.pallol.novela.entities.Galeria;
import org.springframework.ui.Model;
import com.pallol.novela.entities.Novela;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


public class GaleriaRegistroControler {
        // Estos Son Los Controladores del Insert
    
       @GetMapping("/registrogaleria")
    public String registro(Novela novela, Galeria galeria, Model model) {
        model.addAttribute("persona", galeria);
        model.addAttribute("novela", novela);
        return "registrogaleria";
    } 
     
    
    @GetMapping("/registrogaleria")
    public ModelAndView formularic() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    //Estos son los controladores del update

           @GetMapping("/registrogaleriau")
    public String registrogaleriau(Novela novela, Galeria galeria, Model model) {
        model.addAttribute("persona", galeria);
        model.addAttribute("novela", novela);
        return "Updategaleria";
    } 
    
    @GetMapping("/registrogaleria")
    public ModelAndView registro() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
        //Estos son los controladores del delete

    @GetMapping("/deleteogaleria")
    public ModelAndView borrargaleria() {
ModelAndView model = new ModelAndView("protect1/listausuario");
        return model;
    } 
    
    
}
