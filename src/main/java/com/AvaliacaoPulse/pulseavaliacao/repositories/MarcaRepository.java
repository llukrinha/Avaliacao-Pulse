package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    List<Marca> findAllByDescricao(String descricao);
}
