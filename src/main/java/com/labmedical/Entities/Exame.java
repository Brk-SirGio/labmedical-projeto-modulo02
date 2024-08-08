package com.labmedical.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exames")
@Data
@NoArgsConstructor
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_exame", nullable = false, length = 64)
    private String nomeExame;

    @Column(name = "data_exame", nullable = false)
    private LocalDate dataExame;

    @Column(name = "horario_exame", nullable = false)
    private LocalTime horarioExame;

    @Column(name = "tipo_exame", nullable = false, length = 32)
    private String tipoExame;

    @Column(name = "laboratorio", nullable = false, length = 32)
    private String laboratorio;

    @Column(name = "url_documento")
    private String urlDocumento;

    @Column(name = "resultados", length = 1024)
    private String resultados;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
}
