/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NovelaService novelaService;

    public List<Usuario> muestraUsuario() {
        List<Usuario> lstUsuario = usuarioRepository.obtieneUsuariosConDetalle();
        return lstUsuario;
    }

    public Usuario muestraUsuarioPorCodigo(String codigo) {
        return usuarioRepository.findByCodigo(codigo);
    }

    public Usuario muestraUsuarioConDetallesPorId(Integer UsuarioId) {
        Usuario Usuario = null;
        try {
            Usuario = usuarioRepository.getOne(UsuarioId);
        } catch (Exception ex) {

        }
        if (Usuario != null) {

            //  List<Novela> listamovela = novelaService.muestraNovelaPorUsuario(UsuarioId);
            //  Usuario.setUsuarioNovelaList(usuarioNovelaList);.setUsuarioNovelaList(listamovela);
        }
        return Usuario;
    }

    public Usuario creaOActualizaUsuario(Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }

    public void eliminaUsuario(Usuario Usuario) {
        usuarioRepository.delete(Usuario);
    }

    public List<Novela> muestraNovelaporUsuario() {
        List<Novela> lstNovela = /*UsuarioRepository.obtieneUsuarioPorUsuario("pallol")*/ null;
        return lstNovela;
    }

}
