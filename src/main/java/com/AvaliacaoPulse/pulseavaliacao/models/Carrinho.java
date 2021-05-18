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
@Table(name = "pa08_carrinho")
@SequenceGenerator(name = "PA08_CARRINHO_SEQ ",
        sequenceName = "PA08_CARRINHO_SEQ ",
        allocationSize = 1)
public class Carrinho {

    @Id
    @Column(name = "pa08_cod_carrinho")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA08_CARRINHO_SEQ ")
    private Long id;

    @Min(value = 0)
    @Column(name = "pa08_quantidadeitens")
    private Integer quantidadeItens;

    @NotNull
    @Column(name = "pa08_total")
    private BigDecimal total;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa08pa03_cod_cliente")
    private Cliente cliente;
}
