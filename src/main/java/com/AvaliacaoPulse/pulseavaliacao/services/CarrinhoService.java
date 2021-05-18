package com.AvaliacaoPulse.pulseavaliacao.services;

import com.AvaliacaoPulse.pulseavaliacao.repositories.CarrinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarrinhoService {

        private final CarrinhoRepository carrinhoRepository;

}
