package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoJaExistente;
import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Produto;
import com.AvaliacaoPulse.pulseavaliacao.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        verificarDescricao(produto.getDescricao());
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Produto.class, id));
    }

    private void verificarDescricao(String descricao) {
        if (produtoRepository.existsByDescricao(descricao)) {
            throw new RecursoJaExistente(Produto.class, descricao);
        }
    }

    public Produto alterar(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(produtoSalvo -> {
                    copyValues(produto, produtoSalvo,"id");
                    return produtoRepository.save(produtoSalvo);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(Produto.class, id));
    }
}
