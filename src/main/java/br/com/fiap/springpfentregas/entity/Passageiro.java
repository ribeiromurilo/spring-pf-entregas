package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CP1_PASSAGEIRO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASSAGEIRO")
    @SequenceGenerator(
            name = "SQ_PASSAGEIRO",
            sequenceName = "SQ_PASSAGEIRO",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_PASSAGEIRO")
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PESSOA_PASSAGEIRO")
    )
    private Pessoa pessoa;
}