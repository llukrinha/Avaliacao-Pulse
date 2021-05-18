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
@Table(name = "pa06_tipoPagamento")
@SequenceGenerator(name = "PA06_TIPOPAGAMENTO_SEQ",
        sequenceName = "PA006_TIPOPAGAMENTO_SEQ",
        allocationSize = 1)
public class TipoPagamento {

    @Id
    @Column(name = "pa06_cod_tipopagamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PA06_TIPOPAGAMENTO_SEQ")
    private  Long id;

    @NotBlank
    @Column(name = "pa06_descricao")
    private String descricao;

}
