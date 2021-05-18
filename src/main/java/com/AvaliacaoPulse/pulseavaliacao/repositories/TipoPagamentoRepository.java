package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {

    List<TipoPagamento> findAllByDescricao(String descricao);

    boolean existsByDescricao(String descricao);
}
