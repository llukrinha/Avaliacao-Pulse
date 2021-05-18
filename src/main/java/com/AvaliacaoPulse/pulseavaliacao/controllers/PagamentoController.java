package com.AvaliacaoPulse.pulseavaliacao.controllers;


import com.AvaliacaoPulse.pulseavaliacao.models.Pagamento;
import com.AvaliacaoPulse.pulseavaliacao.repositories.PagamentoRepository;
import com.AvaliacaoPulse.pulseavaliacao.services.PagamentoService;
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
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> buscarTodos() {
        return ok(pagamentoRepository.findAll());
    }


    @PostMapping
    public ResponseEntity<Pagamento> criar(@Valid @RequestBody Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoService.salvar(pagamento);
        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable Long id, @Valid@RequestBody Pagamento pagamento) {
        return  ok(pagamentoService.alterar(id, pagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pagamentoRepository.delete(pagamentoService.buscarPorId(id));
        return noContent().build();
    }
}
