package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.Endereco;
import com.AvaliacaoPulse.pulseavaliacao.repositories.EnderecoRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(@RequestParam(required = false) String cep) {
        return ok(enderecoRepository.findAllByCep(cep));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorID(@PathVariable Long id) {
        return ok(enderecoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> criar(@Valid @RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.salvar(endereco);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco endereco) {
        return ok(enderecoService.alterar(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        enderecoRepository.delete(enderecoService.buscarPorId(id));
        return noContent().build();
    }
}
