package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.Marca;
import com.AvaliacaoPulse.pulseavaliacao.repositories.MarcaRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.MarcaService;
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
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepository;
    private final MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodos(@RequestParam(required = false) String descricao) {
        return ok(marcaRepository.findAllByDescricao(descricao));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorID(@PathVariable Long id) {
        return ok(marcaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@Valid @RequestBody Marca marca) {
        Marca novaMarca = marcaService.salvar(marca);
        return new ResponseEntity<>(novaMarca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody Marca marca) {
        return ok(marcaService.salvar(id, marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        marcaRepository.delete(marcaService.buscarPorId(id));
        return noContent().build();
    }
}
