package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa01_produto")
@SequenceGenerator(name = "PA01_PRODUTO_SEQ",
        sequenceName = "PA01_PRODUTO_SEQ",
        allocationSize = 1)
public class Produto {

    @Id
    @Column(name = "pa01_cod_produto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA01_PRODUTO_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "pa01_descricao")
    private String descricao;

    @NotBlank
    @Column(name = "pa01_valor_unitario")
    private BigDecimal valorUnidade;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pa01pa02_cod_marca")
    private Marca marca;
}
