package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CP1_ENDERECO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(
            name = "SQ_ENDERECO",
            sequenceName = "SQ_ENDERECO",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_ENDERECO")
    private Long id;
    @Column(name = "CEP_ENDERECO")
    private String cep;
    @Column(name = "NUM_ENDERECO")
    private String numero;
    @Column(name = "COMPL_ENDERECO")
    private String complemento;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO")
    )
    private Pessoa pessoa;
}