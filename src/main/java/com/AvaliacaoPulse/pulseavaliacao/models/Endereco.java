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
@Table(name = "pa04_endereco")
@SequenceGenerator(name = "PA04_ENDERECO_SEQ",
        sequenceName = "PA04_ENDERECO_SEQ",
        allocationSize = 1)
public class Endereco {

    @Id
    @Column(name = "pa04_cod_endereco")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA04_ENDERECO_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "pa04_cep")
    private  String cep;

    @NotBlank
    @Column(name = "pa04_bairro")
    private  String bairro;

    @NotBlank
    @Column(name = "pa04_rua")
    private String rua;

    @NotBlank
    @Column(name = "pa04_numero")
    private  String numero;

    @NotNull
    @Column(name = "pa04_complemento")
    private String complemento;
}
