/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pallol.novela;

import com.pallol.novela.entities.Usuario;
import com.pallol.novela.repository.UsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.*;
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
public class UsuarioTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Transactional
    public void usuarioTest() {
        String a = "aaa";

        List<Usuario> lstUsuarios = usuarioRepository.obtieneUsuariosConDetalle();

        assertTrue(lstUsuarios.size() > 0);
    }
    

}
