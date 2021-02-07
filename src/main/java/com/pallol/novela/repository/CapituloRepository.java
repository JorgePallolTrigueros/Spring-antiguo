/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela.repository;

import com.pallol.novela.entities.Capitulo;
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
public interface CapituloRepository extends JpaRepository<Capitulo, Integer> {

    @Query(value = "SELECT ca FROM Capitulo ca JOIN ca.novelaIdFk n WHERE n.novelaId = :idnovela ")
    List<Capitulo> obtieneCapituloPorNovelaId(@Param("idnovela") int idnovela);
    
    

    
    
    
    
}
