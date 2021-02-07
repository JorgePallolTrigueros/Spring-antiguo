/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.repository;

import com.pallol.novela.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CASA PALLOL
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//    @Query(value = "SELECT u FROM Usuario u JOIN FETCH u.personaList p JOIN FETCH u.usuarioNovelaList un JOIN FETCH un.novelaIdFk ")
    @Query(value = "SELECT u FROM Usuario u JOIN FETCH u.personaList pl  ")
    List<Usuario> obtieneUsuariosConDetalle();

    @Query(value = "SELECT u FROM Usuario u JOIN FETCH u.rolIdFk r WHERE u.codigo = :codigo")
    Usuario findByCodigo(@Param("codigo") String codigo);

}
