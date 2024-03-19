package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "TB_CP1_VIAGEM")
public class Viagem {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
        @SequenceGenerator(name = "SQ_VIAGEM", sequenceName = "SQ_VIAGEM", allocationSize = 1)
        @Column(name = "ID_VIAGEM")
        private Long id;

        @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinTable(name = "TB_CP1_VIAGEM_PASSAGEIRO", joinColumns = {
                        @JoinColumn(name = "VIAGEM", referencedColumnName = "ID_VIAGEM", foreignKey = @ForeignKey(name = "FK_PASSAGEIRO_VIAGEM")

                        )
        }, inverseJoinColumns = {
                        @JoinColumn(name = "PASSAGEIRO", referencedColumnName = "ID_PASSAGEIRO", foreignKey = @ForeignKey(name = "FK_VIAGEM_PASSAGEIRO"))
        })
        @Builder.Default
        private Set<Passageiro> passageiros = new LinkedHashSet<>();

        @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinColumn(name = "CLIENTE", referencedColumnName = "ID_PESSOA", foreignKey = @ForeignKey(name = "FK_VIAGEM_PESSOA"))

        private Pessoa cliente;

        @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinColumn(name = "ORIGEM", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_ENDERECO_ORIGEM"))

        private Endereco origem;

        @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinColumn(name = "DESTINO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_ENDERECO_DESTINO"))

        private Endereco destino;

        @Column(name = "SAIDA_VIAGEM")
        private LocalDateTime saida;

        @Column(name = "CHEGADA_VIAGEM")
        private LocalDateTime chegada;

        @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
        @JoinTable(name = "TB_CP1_VIAGEM_PRODUTO", joinColumns = {
                        @JoinColumn(name = "VIAGEM", referencedColumnName = "ID_VIAGEM", foreignKey = @ForeignKey(name = "FK_PRODUTO_VIAGEM")

                        )
        }, inverseJoinColumns = {
                        @JoinColumn(name = "PRODUTO", referencedColumnName = "ID_PRODUTO", foreignKey = @ForeignKey(name = "FK_VIAGEM_PRODUTO"))
        })
        @Builder.Default
        private Set<Produto> produtos = new LinkedHashSet<>();

}