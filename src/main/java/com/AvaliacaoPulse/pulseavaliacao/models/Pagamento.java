package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa07_pagamento")
@SequenceGenerator(name = "PA007_PAGAMENTO_SEQ",
        sequenceName = "PA007_PAGAMENTO_SEQ",
        allocationSize = 1)
public class Pagamento {

    @Id
    @Column(name = "pa07_cod_pagamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PA07_PAGAMENTO_SEQ")
    private Long id;

    @NotNull
    @Column(name = "pa07_total")
    private BigDecimal total;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa07pa04_cod_endereco")
    private Endereco enderecoEntrega;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa07pa05_cod_transportadora")
    private Transportadora transportadora;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa07pa06_cod_tipopagamento")
    private TipoPagamento tipoPagamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa07pa08_cod_carrinho")
    private Carrinho carrinho;

    @OneToOne
    @JoinColumn(name = "pa07pa10_cod_compra")
    private Compra compra;
}
