package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findAllByCep(String cep);
}
