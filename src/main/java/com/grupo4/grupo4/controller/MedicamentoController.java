package com.grupo4.grupo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.grupo4.grupo4.repository.MedicamentoRepository;

@Controller
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping("/pesquisar")
    public String pesquisar(@RequestParam(required = false) String nome, 
                            @RequestParam(required = false) String categoria, 
                            Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("medicamentos", medicamentoRepository.findByNomeContaining(nome));
        } else if (categoria != null && !categoria.isEmpty()) {
            model.addAttribute("medicamentos", medicamentoRepository.findByCategoria(categoria));
        }
        return "resultadoPesquisa";
    }
}