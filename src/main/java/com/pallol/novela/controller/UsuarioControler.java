/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Persona;
import com.pallol.novela.entities.Rol;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.repository.PersonaRepository;
import com.pallol.novela.repository.RolRepository;
import com.pallol.novela.service.NovelaService;
import com.pallol.novela.service.SeguridadService;
import com.pallol.novela.service.UsuarioService;
import com.pallol.novela.validator.UsuarioValidator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NovelaService novelaService;

    @Autowired
    private SeguridadService seguridadService;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioValidator userValidator;

    @GetMapping("/muestraUsuario")
    public ModelAndView muestraUsuario() {
        List<Usuario> list = usuarioService.muestraUsuario();
        ModelAndView model = new ModelAndView("muestra_usuario");
        model.addObject("usuarios", list);

        for (Usuario usuario : list) {
            List<Novela> lstNovela = novelaService.muestraNovelaPorUsuarioId(usuario.getUsuarioId());
            model.addObject("usuarios" + usuario.getUsuarioId(), lstNovela);
        }

        return model;
    }

    // Protegido
    @GetMapping("/listaUsuario")
    public ModelAndView muestraListaUsuarios() {
        List<Usuario> list = usuarioService.muestraUsuario();
        ModelAndView model = new ModelAndView("protect1/listausuario");
        model.addObject("usuarios", list);
        for (Usuario usuario : list) {
            List<Novela> lstNovela = novelaService.muestraNovelaPorUsuarioId(usuario.getUsuarioId());
            model.addObject("usuarios" + usuario.getUsuarioId(), lstNovela);
        }
        return model;
    }

    @PostMapping("/creaUsuario")
    public ModelAndView creaUsuario(Usuario usuario, Persona persona) {
        ModelAndView model = new ModelAndView("muestra_usuario");

        Rol rol = rolRepository.getOne(2);
        usuario.setRolIdFk(rol);
        usuario = usuarioService.creaOActualizaUsuario(usuario);

        persona.setUsuarioIdFk(usuario);
        persona = personaRepository.save(persona);

        seguridadService.autoLogin(usuario.getCodigo(), usuario.getContrasena());

        return model;
    }

    @GetMapping("/registro")
    public String registration(Usuario usuario, Persona persona, Model model) {
        model.addAttribute("persona", persona);
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

}
