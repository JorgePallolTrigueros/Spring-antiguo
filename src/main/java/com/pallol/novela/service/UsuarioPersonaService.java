/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.service;

import com.pallol.novela.entities.Rol;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

@Service
public class UsuarioPersonaService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String codigo) {
        Usuario usuario = usuarioRepository.findByCodigo(codigo);
        if (usuario == null) {
            throw new UsernameNotFoundException(codigo);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Rol rol = usuario.getRolIdFk();
        if (rol != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new org.springframework.security.core.userdetails.User("{noop}"+usuario.getCodigo(), "{noop}"+usuario.getContrasena(), grantedAuthorities);
    }
}
