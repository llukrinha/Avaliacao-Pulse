package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoJaExistente;
import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Transportadora;
import com.AvaliacaoPulse.pulseavaliacao.repositories.PagamentoRepository;
import com.AvaliacaoPulse.pulseavaliacao.repositories.TransportadoraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class TransportadoraService {

    private final TransportadoraRepository transportadoraRepository;
    private final PagamentoRepository pagamentoRepository;

    public Transportadora salvar(Transportadora transportadora) {
        verificaCnpj(transportadora.getCnpj());
        return transportadoraRepository.save(transportadora);
    }

    public Transportadora buscarPorId(Long id) {
        return transportadoraRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Transportadora.class, id));
    }

    public Transportadora buscaPorCnpj(String cnpj) {
        return transportadoraRepository.findAllByCnpj(cnpj)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Transportadora.class, cnpj));
    }

    private void verificaCnpj(String cnpj) {
        if (transportadoraRepository.existsByCnpj(cnpj)) {
            throw new RecursoJaExistente(Transportadora.class, cnpj);
        }
    }

    public Transportadora alterar(Long id, Transportadora transportadora) {
        return transportadoraRepository.findById(id)
                .map(transportadoraSalva -> {
                    copyValues(transportadora, transportadoraSalva, "id");
                    return transportadoraRepository.save(transportadora);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(Transportadora.class, id));
    }
}
