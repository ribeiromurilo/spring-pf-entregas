package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_CP1_PESSOA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(
            name = "SQ_PESSOA",
            sequenceName = "SQ_PESSOA",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PESSOA")
    private Long id;
    @Column(name = "NM_PESSOA")
    private String nome;
    @Column(name = "EMAIL_PESSOA")
    private String email;
    @Column(name = "NASC_PESSOA")
    private LocalDate nascimento;

}