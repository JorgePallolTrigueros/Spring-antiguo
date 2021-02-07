/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela;

import com.pallol.novela.entities.Categoria;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.repository.CategoriaRepository;
import com.pallol.novela.repository.NovelaRepository;
import com.pallol.novela.service.NovelaService;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Jessai
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class NovelaTest {

    @Autowired
    private NovelaRepository novelaRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NovelaService novelaService;

    public NovelaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Transactional
    public void novelaTest() {
        // Consulta Novelas
        List<Novela> lstNovela = novelaRepository.obtieneNovelaPorCategoria(1);

        lstNovela.stream().forEach(novela -> {
            System.out.println(novela.getNombre());
        });

        assertTrue(lstNovela.size() > 0);

        //Inserta novelas
        Categoria categoria = new Categoria();
        categoria.setNombre("Categoria Test");
        categoria = categoriaRepository.save(categoria);
        
        Novela novela = new Novela();
        novela.setAnotacion("AnotacionTestSpring");
        novela.setDescripciong("Descripciong TestSpring");
        novela.setDescripcionp("Descripcionp TestSpring");
        novela.setNombre("Nombre Novela TestSpring");
        novela.setNotas("Notas");
        novela.setImagen("Imagen");
        novela.setPrecio(100);
        novela.setCategoriaIdFk(categoria);
        
        novela = novelaService.creaOActualizaNovela(novela);

        assertTrue(novela.getNovelaId() != null);

        // Actualiza Novela
        novela.setNombre("Nombre Actualiado Test Spring");
        novela = novelaService.creaOActualizaNovela(novela);

        assertTrue("Nombre Actualiado Test Spring".equals(novela.getNombre()));

        // Elimina novela
        novelaService.eliminaNovelaPorId(novela.getNovelaId());
        
        novela = novelaService.muestraNovelaConDetallesPorId(novela.getNovelaId());
        
        assertTrue(novela == null);
        
    }
}
