package com.grupo4.grupo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.grupo4.grupo4.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findByNomeContaining(String nome);
    List<Medicamento> findByCategoria(String categoria);
}