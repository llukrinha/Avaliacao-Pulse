package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

    List<Transportadora> findAllByNome(String nome);

    boolean existsByCnpj(String cnpj);

    Optional<Transportadora> findAllByCnpj(String cnpj);
}
