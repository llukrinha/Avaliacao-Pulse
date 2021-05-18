package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Pagamento;
import com.AvaliacaoPulse.pulseavaliacao.repositories.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Pagamento.class, id));
    }


    public Pagamento alterar(Long id, Pagamento pagamento) {
        return pagamentoRepository.findById(id)
                .map(pagamentoSalvo -> {
                    copyValues(pagamento, pagamentoSalvo, "id");
                    return pagamentoRepository.save(pagamentoSalvo);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(Pagamento.class, id));
    }
}
