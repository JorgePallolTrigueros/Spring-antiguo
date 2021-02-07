/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Galeria;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.repository.GaleriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaleriaService {

    @Autowired
    private GaleriaRepository galeriaRepository;

    public List<Galeria> muestraGaleriaPorNovelaId(int novelaId) {
        List<Galeria> lstGaleria = galeriaRepository.obtieneGaleriaPorNovelaId(novelaId);
        return lstGaleria;
    }

        public Galeria creaOActualizaGaleria(Galeria Galeria) {
        return galeriaRepository.save(Galeria);
    }

    public void eliminaGaleria(Galeria Galeria) {
        galeriaRepository.delete(Galeria);
    }

    
        public Galeria creaOActualizaCapitulo(Galeria Galeria) {
        return galeriaRepository.save(Galeria);
    }

    public void eliminaCapitulo(Galeria Galeria) {
        galeriaRepository.delete(Galeria);
    }


    public List<Galeria> muestraCapituloporUsuario() {
        List<Galeria> lstCapitulo = /*UsuarioRepository.obtieneUsuarioPorUsuario("pallol")*/ null;
        return lstCapitulo;
    }
    
}
