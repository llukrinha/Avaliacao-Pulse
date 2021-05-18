package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Marca;
import com.AvaliacaoPulse.pulseavaliacao.repositories.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Marca.class, id));
    }

    @Transactional
    public Marca salvar(Long id, Marca marca) {
        return marcaRepository.save(marca);
    }
}
