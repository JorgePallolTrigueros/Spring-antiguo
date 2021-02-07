/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.entities.Galeria;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Personaje;
import com.pallol.novela.repository.NovelaRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author CASA PALLOL
 */
@Service
public class NovelaService {

    @Autowired
    private NovelaRepository novelaRepository;

    @Autowired
    private PersonajeService personajeService;

    @Autowired
    private CapituloService capituloService;

    @Autowired
    private GaleriaService galeriaService;

    public List<Novela> muestraNovela() {
        List<Novela> lstNovela = novelaRepository.findAll();
        return lstNovela;
    }

    public Page<Novela> muestraNovelaPaginada(Pageable pageable) {
        List<Novela> universoNovelas = muestraNovela();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Novela> list;

        if (universoNovelas.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, universoNovelas.size());
            list = universoNovelas.subList(startItem, toIndex);
        }

        Page<Novela> bookPage
                = new PageImpl<Novela>(list, PageRequest.of(currentPage, pageSize), universoNovelas.size());

        return bookPage;
    }

    public Novela muestraNovelaConDetallesPorId(Integer novelaId) {
        Novela novela = null;
        try {
            novela = novelaRepository.getOne(novelaId);
        } catch (Exception ex) {

        }
        if (novela != null) {
            List<Personaje> listapersonajes = personajeService.muestraPersonajePorNovelaId(novelaId);
            List<Capitulo> listacapitulos = capituloService.muestraCapituloPorNovelaId(novelaId);
            List<Galeria> listagaleria = galeriaService.muestraGaleriaPorNovelaId(novelaId);

            novela.setPersonajeList(listapersonajes);
            novela.setCapituloList(listacapitulos);
            novela.setGaleriaList(listagaleria);
        }
        return novela;
    }

    public Novela creaOActualizaNovela(Novela novela) {
        return novelaRepository.save(novela);
    }

    public void eliminaNovela(Novela novela) {
        novelaRepository.delete(novela);
    }

    public void eliminaNovelaPorId(Integer novelaId) {
        novelaRepository.deleteById(novelaId);
    }

    public List<Novela> muestraNovelaPorUsuario() {
        List<Novela> lstNovela = /*novelaRepository.obtieneNovelaPorUsuario("pallol")*/ null;
        return lstNovela;
    }

    public List<Novela> muestraNovelaPorCategoria() {
        List<Novela> lstNovela = /*novelaRepository.obtieneNovelaPorCategoria(1)*/ null;
        return lstNovela;
    }

    public List<Novela> muestraNovelaPorCodigoUsuario(String codigo) {
        List<Novela> lstNovela = novelaRepository.obtieneNovelaPorCodigoUsuario(codigo);
        return lstNovela;
    }

    public List<Novela> muestraNovelaPorUsuarioId(int usuarioId) {
        List<Novela> lstNovela = novelaRepository.obtieneNovelaPorUsuarioId(usuarioId);
        return lstNovela;
    }

}
