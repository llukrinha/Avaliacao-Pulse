package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa10_compra")
@SequenceGenerator(name = "PA10_COMPRA_SEQ",
        sequenceName = "PA10_COMPRA_SEQ",
        allocationSize = 1)
public class Compra {

    @Id
    @Column(name = "pa10_cod_compra")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA10_COMPRA_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "pa10_codrastreio")
    private String codRastreio;

    @NotBlank
    @Column(name = "pa10_numeropedido")
    private String numeroPedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa10pa11_cod_comprastatus")
    private CompraStatus compraStatus;

}
