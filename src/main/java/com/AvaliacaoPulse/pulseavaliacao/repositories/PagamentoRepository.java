package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}