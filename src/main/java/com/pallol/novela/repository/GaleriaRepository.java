/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.repository;

import com.pallol.novela.entities.Galeria;
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
public interface GaleriaRepository extends JpaRepository<Galeria, Integer> {

    @Query(value = "SELECT g FROM Galeria g JOIN g.novelaIdFk n WHERE n.novelaId = :idnovela ")
    List<Galeria> obtieneGaleriaPorNovelaId(@Param("idnovela") int idnovela);

}
