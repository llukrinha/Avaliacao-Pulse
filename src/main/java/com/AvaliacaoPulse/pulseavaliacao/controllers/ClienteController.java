package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.Cliente;
import com.AvaliacaoPulse.pulseavaliacao.repositories.ClienteRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        return ok(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorID(@PathVariable Long id) {
        return ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente>buscaPorCPF(@PathVariable String cpf){
        return ok(clienteService.buscaPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return ok(clienteService.alterar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clienteRepository.delete(clienteService.buscarPorId(id));
        return noContent().build();
    }
}

