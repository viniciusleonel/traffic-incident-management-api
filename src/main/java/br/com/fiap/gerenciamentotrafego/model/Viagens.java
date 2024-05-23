package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;


public class Viagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Viagem")
    private Long idViagens;

    @Column(name = "Distancia", nullable = false)
    private Integer distancia;

    @Column(name = "Vel_Trafego", nullable = false)
    private Integer velTrafego;

}

