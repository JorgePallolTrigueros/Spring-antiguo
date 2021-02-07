/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.repository;

import com.pallol.novela.entities.Novela;
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
public interface NovelaRepository extends JpaRepository<Novela, Integer> {

    @Query(value = "SELECT n FROM Novela n JOIN n.categoriaIdFk c WHERE c.categoriaId = :categoriaId")
    List<Novela> obtieneNovelaPorCategoria(@Param("categoriaId") int categoriaId);

    @Query(value = "SELECT n FROM Novela n JOIN n.usuarioNovelaList un JOIN un.usuarioIdFk u WHERE u.codigo = :codigo")
    public List<Novela> obtieneNovelaPorCodigoUsuario(@Param("codigo") String codigo_usuario);

    @Query(value = "SELECT n FROM UsuarioNovela un JOIN un.novelaIdFk n JOIN un.usuarioIdFk u WHERE u.usuarioId = :usuarioId ")
    List<Novela> obtieneNovelaPorUsuarioId(@Param("usuarioId") int usuarioId);

}
