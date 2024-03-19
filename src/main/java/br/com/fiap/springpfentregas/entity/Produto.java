package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CP1_PRODUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(
            name = "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_PRODUTO")
    private Long id;
    @Column(name = "ETQ_PROUTO")
    private String etiqueta;
    @Column(name = "NM_PRODUTO")
    private String nome;
    @Column(name = "PESO_PRODUTO")
    private float peso;
    @Column(name = "LARG_PRODUTO")
    private float largura;
    @Column(name = "ALT_PRODUTO")
    private float altura;
    @Column(name = "PROF_PRODUTO")
    private float profundidade;
}