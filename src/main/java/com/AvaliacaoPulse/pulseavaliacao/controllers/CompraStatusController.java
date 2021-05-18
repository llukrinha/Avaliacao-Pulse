package com.AvaliacaoPulse.pulseavaliacao.controllers;

import com.AvaliacaoPulse.pulseavaliacao.models.CompraStatus;
import com.AvaliacaoPulse.pulseavaliacao.services.CompraStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping("/compraStatus")
public class CompraStatusController {

    private final CompraStatusService compraStatusService;

    @GetMapping("/{id}")
    public ResponseEntity <CompraStatus> buscarPorID(@PathVariable Long id) {
        return ok(compraStatusService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraStatus> atualizar(@PathVariable Long id, @Valid @RequestBody CompraStatus compraStatus) {
        return ok(compraStatusService.alterar(id, compraStatus));
    }
}
