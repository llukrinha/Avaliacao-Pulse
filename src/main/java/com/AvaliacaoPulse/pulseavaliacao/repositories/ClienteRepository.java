package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByNome(String nome);

    Optional<Cliente> findAllByCpf(String cpf);

    boolean existsByEndereco_Id(Long enderecoId);

    boolean existsByEmail (String email);

    boolean existsByNumero(String numero);
}
