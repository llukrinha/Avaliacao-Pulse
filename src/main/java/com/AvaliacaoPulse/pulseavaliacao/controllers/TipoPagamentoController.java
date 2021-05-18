package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.TipoPagamento;
import com.AvaliacaoPulse.pulseavaliacao.repositories.TipoPagamentoRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.TipoPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@AllArgsConstructor
@RequestMapping("/tipospagamentos")
public class TipoPagamentoController {

    private final TipoPagamentoRepository tipoPagamentoRepository;
    private final TipoPagamentoService tipoPagamentoService;

    @GetMapping("/{descricao}")
    public ResponseEntity<List<TipoPagamento>> buscarTodos(@RequestParam (required = false) String descricao){
        return ok(tipoPagamentoRepository.findAllByDescricao(descricao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoPagamento> buscarPorId(@PathVariable Long id){
        return ok(tipoPagamentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TipoPagamento> criar(@Valid @RequestBody TipoPagamento tipoPagamento){
        TipoPagamento novoTipoPagamento= tipoPagamentoService.salvar(tipoPagamento);
        return new ResponseEntity<>(novoTipoPagamento, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamento> atualizar(@PathVariable Long id, @Valid @RequestBody TipoPagamento tipoPagamento) {
        return ok(tipoPagamentoService.alterar(id, tipoPagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tipoPagamentoRepository.delete(tipoPagamentoService.buscarPorId(id));
        return noContent().build();
    }
}
