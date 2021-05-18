package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa03_cliente")
@SequenceGenerator(name = "PA03_PRODUTO_SEQ",
        sequenceName = "PA01_PRODUTO_SEQ",
        allocationSize = 1)
public class Cliente {

    @Id
    @Column(name = "pa03_cod_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA03_CLIENTE_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "pa03_nome")
    private String nome;

    @NotBlank
    @CPF
    @Column(name = "pa03_cpf")
    private String cpf;

    @NotBlank
    @Column(name = "pa03_numero")
    private String numero;

    @NotNull
    @Email
    @Column(name = "pa03_email")
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pa03pa04_cod_endereco")
    private Endereco endereco;
}
