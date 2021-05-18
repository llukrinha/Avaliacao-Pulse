package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Cliente;
import com.AvaliacaoPulse.pulseavaliacao.models.Endereco;
import com.AvaliacaoPulse.pulseavaliacao.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Endereco.class, id));
    }

    public Endereco salvar(Long id, Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco alterar(Long id, Endereco endereco) {
        return enderecoRepository.findById(id)
                .map(enderecoSalvo -> {
                    copyValues(endereco, enderecoSalvo, "id");
                    return enderecoRepository.save(endereco);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(Endereco.class, id));
    }
}

