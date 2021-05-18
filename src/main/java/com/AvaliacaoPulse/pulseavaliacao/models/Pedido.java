package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa09_pedido")
@SequenceGenerator(name = "PA09_PEDIDO_SEQ",
        sequenceName = "PA09_PEDIDO_SEQ",
        allocationSize = 1)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA09_PEDIDO_SEQ")
    private Long id;

    @Min(value = 1 )
    @Column(name = "pa09_quantidadeitens")
    private Integer quantidadeItens;

    @NotNull
    @Column(name = "pa09_total")
    private BigDecimal total;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa09pa01_cod_produto")
    Produto produto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa09pa08_cod_carrinho")
    private Carrinho carrinho;
}
