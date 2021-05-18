package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.CompraStatus;
import com.AvaliacaoPulse.pulseavaliacao.repositories.CompraStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class CompraStatusService {

    private final CompraStatusRepository compraStatusRepository;

    public CompraStatus buscarPorId(Long id) {
        return compraStatusRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(CompraStatus.class, id));
    }

    public CompraStatus alterar(Long id, CompraStatus compraStatus) {
        return compraStatusRepository.findById(id)
                .map(compraStatusSalvo -> {
                    copyValues(compraStatus, compraStatusSalvo, "id");
                    return compraStatusRepository.save(compraStatus);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(CompraStatus.class, id));
    }

}
