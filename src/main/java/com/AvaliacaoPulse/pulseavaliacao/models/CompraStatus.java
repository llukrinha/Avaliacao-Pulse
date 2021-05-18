package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa11_comprastatus")
@SequenceGenerator(name = "PA11_COMPRASTATUS_SEQ",
        sequenceName = "PA11_COMPRASTATUS_SEQ",
        allocationSize = 1)
public class CompraStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA11_COMPRASTATUS_SEQ")
    @Column(name = "pa11_cod_comprastatus")
    private Long id;

    @NotBlank
    @Column(name = "pa11_descricao")
    private String descricao;
}
