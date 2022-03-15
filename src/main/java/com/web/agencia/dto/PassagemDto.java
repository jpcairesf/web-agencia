package com.web.agencia.dto;

import java.math.BigDecimal;

public class PassagemDto {

    private String cpfPassageiro;

    private Long vooId;

    private Integer assento;

    private BigDecimal valor;

    public PassagemDto(String cpfPassageiro, Long vooId, Integer assento, BigDecimal valor) {
        this.cpfPassageiro = cpfPassageiro;
        this.vooId = vooId;
        this.assento = assento;
        this.valor = valor;
    }

    public String getCpfPassageiro() {
        return cpfPassageiro;
    }

    public void setCpfPassageiro(String cpfPassageiro) {
        this.cpfPassageiro = cpfPassageiro;
    }

    public Long getVooId() {
        return vooId;
    }

    public void setVooId(Long vooId) {
        this.vooId = vooId;
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
