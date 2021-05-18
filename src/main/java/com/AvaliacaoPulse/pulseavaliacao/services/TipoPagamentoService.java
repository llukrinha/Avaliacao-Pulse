package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoJaExistente;
import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Cliente;
import com.AvaliacaoPulse.pulseavaliacao.models.TipoPagamento;
import com.AvaliacaoPulse.pulseavaliacao.repositories.TipoPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class TipoPagamentoService {

    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamento salvar(TipoPagamento tipoPagamento){
        verificarDescricao(tipoPagamento.getDescricao());
        return tipoPagamentoRepository.save(tipoPagamento);
    }

    public TipoPagamento buscarPorId(Long id) {
        return tipoPagamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Cliente.class, id));
    }

    private void verificarDescricao(String descricao) {
        if (tipoPagamentoRepository.existsByDescricao(descricao)) {
            throw new RecursoJaExistente(TipoPagamento.class, descricao);
        }
    }

    public TipoPagamento alterar(Long id, TipoPagamento tipoPagamento) {
        return tipoPagamentoRepository.findById(id)
                .map(tipoPagamentoSalvo ->{
                   copyValues(tipoPagamento, tipoPagamentoSalvo, "id");
                   return tipoPagamentoRepository.save(tipoPagamento);
                } ).orElseThrow(() -> new RecursoNaoEncontradoException(TipoPagamento.class, id));
    }
}
