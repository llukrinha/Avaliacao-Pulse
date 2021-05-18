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
@Table(name = "pa02_marca")
@SequenceGenerator(name = "PA02_MARCA_SEQ",
        sequenceName = "PA02_MARCA_SEQ",
        allocationSize = 1)
public class Marca {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PA02_MARCA_SEQ"
    )
    @Column(name = "pa02_cod_marca")
    private Long id;

    @NotBlank
    @Column(name = "pa02_descricao")
    private String descricao;
}
