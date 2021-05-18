package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.Produto;
import com.AvaliacaoPulse.pulseavaliacao.repositories.ProdutoRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(@RequestParam(required = false) String descricao) {
        return ok(produtoRepository.findAllByDescricao(descricao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorID(@PathVariable Long id) {
        return ok(produtoService.buscarPorId(id));
    }

    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<List<Produto>> buscarPorMarca(@PathVariable Long marcaId) {
        return ok(produtoRepository.findByMarca_Id(marcaId));
    }
    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid@RequestBody Produto produto) {
        return  ok(produtoService.alterar(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoRepository.delete(produtoService.buscarPorId(id));
        return noContent().build();
    }
}
