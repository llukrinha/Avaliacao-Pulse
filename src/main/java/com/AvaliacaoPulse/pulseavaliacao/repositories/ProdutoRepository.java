package com.AvaliacaoPulse.pulseavaliacao.repositories;

import com.AvaliacaoPulse.pulseavaliacao.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByDescricao(String descricao);

    List<Produto> findByMarca_Id(Long marcaId);

    boolean existsByDescricao(String descricao);
}
