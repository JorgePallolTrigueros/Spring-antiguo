/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.repository.CapituloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    public List<Capitulo> muestraCapituloPorNovelaId(int novelaId) {
        List<Capitulo> lstCapitulo = capituloRepository.obtieneCapituloPorNovelaId(novelaId);
        return lstCapitulo;
    }

    public Capitulo creaOActualizaCapitulo(Capitulo Capitulo) {
        return capituloRepository.save(Capitulo);
    }

    public void eliminaCapitulo (Capitulo Capitulo) {
        capituloRepository.delete(Capitulo);
    }

    public List<Capitulo> muestraCapitulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    public List<Capitulo> muestraCapituloporUsuario() {
        List<Capitulo> lstCapitulo = /*UsuarioRepository.obtieneUsuarioPorUsuario("pallol")*/ null;
        return lstCapitulo;
    }


  }
