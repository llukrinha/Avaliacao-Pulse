package com.AvaliacaoPulse.pulseavaliacao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pa05_transportadora")
@SequenceGenerator(name = "PA05_TRANSPORTADORA_SEQ",
        sequenceName = "PA05_TRANSPORTADORA_SEQ",
        allocationSize = 1)
public class Transportadora {

    @Id
    @Column(name = "pa05_cod_transportadora")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA05_TRANSPORTADORA_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "pa05_nome")
    private String nome;

    @NotBlank
    @CNPJ
    @Column(name = "pa05_cnpj")
    private String cnpj;

    @NotNull
    @Column(name = "pa05_frete_valor")
    private BigDecimal freteValor;
}
