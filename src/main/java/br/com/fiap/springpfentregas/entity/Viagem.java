package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CP1_VIAGEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEN")
    @SequenceGenerator(
            name = "SQ_VIAGEM",
            sequenceName = "SQ_VIAGEM",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_VIAGEM")
    private Long id;
    @Column(name = "SAIDA_VIAGE")
    private LocalDateTime saida;
    @Column(name = "CHEGADA_VIAGEM")
    private LocalDateTime chegada;
}