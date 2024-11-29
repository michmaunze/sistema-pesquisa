package com.grupo4.grupo4;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo4.grupo4.controller.MedicamentoController;
import com.grupo4.grupo4.repository.MedicamentoRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @InjectMocks
    private MedicamentoController medicamentoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPesquisarMedicamentos() throws Exception {
        mockMvc.perform(get("/pesquisar").param("nome", "Aspirina"))
               .andExpect(view().name("resultadoPesquisa"))
               .andExpect(model().attributeExists("medicamentos"));
        
        verify(medicamentoRepository, times(1)).findByNomeContaining("Aspirina");
    }
}