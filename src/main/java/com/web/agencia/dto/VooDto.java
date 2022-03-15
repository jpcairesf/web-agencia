package com.web.agencia.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;

public class VooDto {

    private String localPartida;

    private String localChegada;

    @DateTimeFormat
    private LocalTime horaPartida;

    @DateTimeFormat
    private LocalTime horaChegada;

    @DateTimeFormat
    private LocalDate data;

    public VooDto(String localPartida, String localChegada, LocalTime horaPartida, LocalTime horaChegada, LocalDate data) {
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.data = data;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    public LocalTime getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(LocalTime horaPartida) {
        this.horaPartida = horaPartida;
    }

    public LocalTime getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(LocalTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
