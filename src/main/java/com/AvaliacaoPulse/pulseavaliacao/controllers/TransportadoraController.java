package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.Transportadora;
import com.AvaliacaoPulse.pulseavaliacao.repositories.TransportadoraRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.TransportadoraService;
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
@RequestMapping("/transpostadoras")
public class TransportadoraController {

    private final TransportadoraRepository transportadoraRepository;
    private final TransportadoraService transportadoraService;

    @GetMapping("/{nome}")
    public ResponseEntity<List<Transportadora>> buscarTodos(@RequestParam(required = false) String nome) {
        return ok(transportadoraRepository.findAllByNome(nome));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transportadora> buscarPorID(@PathVariable Long id) {
        return ok(transportadoraService.buscarPorId(id));
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Transportadora>buscaPorCNPJ(@PathVariable String cnpj){
        return ok(transportadoraService.buscaPorCnpj(cnpj));
    }

    @PostMapping
    public ResponseEntity<Transportadora> criar(@Valid @RequestBody Transportadora transportadora) {
        Transportadora novaTransportadora = transportadoraService.salvar(transportadora);
        return new ResponseEntity<>(novaTransportadora, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transportadora> atualizar(@PathVariable Long id, @Valid @RequestBody Transportadora transportadora) {
        return ok(transportadoraService.alterar(id, transportadora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        transportadoraRepository.delete(transportadoraService.buscarPorId(id));
        return noContent().build();
    }
}
