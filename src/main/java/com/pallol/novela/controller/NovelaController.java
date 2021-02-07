/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.controller;

import com.pallol.novela.entities.Novela;
import com.pallol.novela.service.NovelaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CASA PALLOL
 */
@Controller
public class NovelaController {

    @Autowired
    private NovelaService novelaService;

    @GetMapping("/muestraNovela")
    public ModelAndView muestraNovela( HttpServletRequest request) {
        List<Novela> list = novelaService.muestraNovela();
        ModelAndView model = new ModelAndView("muestra_novela");
        model.addObject("novelas", list);
        
//                SecurityContext context = SecurityContextHolder.getContext();
//        if (context == null)
//            System.out.println("false");
//
//        Authentication authentication = context.getAuthentication();
//        if (authentication == null)
//            System.out.println("false");
//
//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            System.out.println("Auth.getAuth " + auth.getAuthority());
//        }
//        
//        System.out.println("Es admin? " + request.isUserInRole("ADMIN"));
//        System.out.println("Es admin? " + request.isUserInRole("ROLE_ADMIN"));
        
        return model;
    }

    @GetMapping("/muestraNovelaPaginada")
    public ModelAndView muestraNovelaPaginada(@RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        int paginaActual = page.orElse(1);
        int tamanoPagina = size.orElse(5);
        Page<Novela> list = novelaService.muestraNovelaPaginada(PageRequest.of(paginaActual - 1, tamanoPagina));

        ModelAndView model = new ModelAndView("muestra_novela");
        model.addObject("novelas", list);

        int totalPaginas = list.getTotalPages();
        if (totalPaginas > 0) {
            List<Integer> numerosPagina = IntStream.rangeClosed(1, totalPaginas)
                    .boxed()
                    .collect(Collectors.toList());
            model.addObject("numerosPagina", numerosPagina);
        }

        return model;
    }

    @GetMapping("/muestraNovelaporcategoria")
    public ModelAndView muestraNovelaporcategoria() {
        List<Novela> list = novelaService.muestraNovelaPorCategoria();
        ModelAndView model = new ModelAndView("muestra_novelaporcategoria");
        model.addObject("novelas", list);
        return model;
    }

    
    
    
    
    //Protegidas
    
    
    
    
    
    
    
    
    
    
    
    
}
