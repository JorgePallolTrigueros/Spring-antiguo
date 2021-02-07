/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.entities.Galeria;
import com.pallol.novela.entities.Personaje;
import com.pallol.novela.repository.CapituloRepository;
import com.pallol.novela.repository.NovelaRepository;
import com.pallol.novela.repository.PersonajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> muestraPersonajePorNovelaId(int novelaId) {
        List<Personaje> lstPersonaje = personajeRepository.obtienePersonajePorNovelaId(novelaId);
        return lstPersonaje;
    }

    
            public Personaje creaOActualizaPersonaje(Personaje Personaje) {
        return personajeRepository.save(Personaje);
    }

    public void eliminaPersonaje(Personaje Personaje) {
        personajeRepository.delete(Personaje);
    }

    
    
    
    
    
}
