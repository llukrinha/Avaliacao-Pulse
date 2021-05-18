package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoJaExistente;
import com.AvaliacaoPulse.pulseavaliacao.exceptions.RecursoNaoEncontradoException;
import com.AvaliacaoPulse.pulseavaliacao.models.Cliente;
import com.AvaliacaoPulse.pulseavaliacao.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.AvaliacaoPulse.pulseavaliacao.utils.CommonUtil.copyValues;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        verificarEndereco(cliente.getEndereco().getId());
        buscaPorCpf(cliente.getCpf());
        verificarEmail(cliente.getEmail());
        verificarNumero(cliente.getNumero());
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Cliente.class, id));
    }

    public Cliente buscaPorCpf(String cpf) {
        return clienteRepository.findAllByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Cliente.class, cpf));
    }

    private void verificarEmail(String email) {
        if (clienteRepository.existsByEmail(email)) {
            throw new RecursoJaExistente(Cliente.class, email);
        }
    }

    private void verificarNumero(String numero) {
        if (clienteRepository.existsByNumero(numero)) {
            throw new RecursoJaExistente(Cliente.class, numero);
        }
    }

    private void verificarEndereco(Long enderecoId) {
        if (clienteRepository.existsByEndereco_Id(enderecoId)) {
            throw new RecursoJaExistente(Cliente.class, enderecoId);
        }
    }

    public Cliente alterar(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(clienteSalvo -> {
                    copyValues(cliente, clienteSalvo, "id");
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new RecursoNaoEncontradoException(Cliente.class, id));
    }

}
