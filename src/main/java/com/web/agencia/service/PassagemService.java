package com.web.agencia.service;

import com.web.agencia.dto.PassagemDto;
import com.web.agencia.model.Passageiro;
import com.web.agencia.model.Passagem;
import com.web.agencia.model.Voo;
import com.web.agencia.model.repository.PassageiroRepository;
import com.web.agencia.model.repository.PassagemRepository;
import com.web.agencia.model.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassagemService {

    private PassagemRepository passagemRepository;

    private PassageiroRepository passageiroRepository;

    private VooRepository vooRepository;

    @Autowired
    public PassagemService(PassagemRepository passagemRepository, PassageiroRepository passageiroRepository, VooRepository vooRepository) {
        this.passagemRepository = passagemRepository;
        this.passageiroRepository = passageiroRepository;
        this.vooRepository = vooRepository;
    }

    public Passagem save(PassagemDto input) {
        Optional<Passageiro> passageiroOptional = passageiroRepository.findById(input.getCpfPassageiro());
        Optional<Voo> vooOptional = vooRepository.findById(input.getVooId());
        if (passageiroOptional.isPresent() && vooOptional.isPresent()) {
            Passagem passagem = toPassagem(input);
            return passagemRepository.save(passagem);
        }
        throw new IllegalArgumentException("Dados inválidos");
    }

    public List<Passagem> findAll() {
        return passagemRepository.findAll();
    }

    public Passagem findById(Long id) {
        Optional<Passagem> passagemOptional = passagemRepository.findById(id);
        if (passagemOptional.isPresent()) {
            Passagem passagem = passagemOptional.get();
            return passagem;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    public List<Passagem> findByCpfPassageiro(String cpf) {
        return passagemRepository.findByCpfPassageiro(cpf);
    }

    public Passagem update(Long id, PassagemDto input) {
        Optional<Passagem> passagemOptional = passagemRepository.findById(id);
        if (passagemOptional.isPresent()) {
            Passagem passagem = passagemOptional.get();
            set(input, passagem);
            return passagem;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    public void delete(Long id) {
        Optional<Passagem> passagemOptional = passagemRepository.findById(id);
        if (passagemOptional.isPresent()) {
            Passagem passagem = passagemOptional.get();
            passagemRepository.delete(passagem);
            return;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    private void set(PassagemDto input, Passagem passagem) {
        passagem.setCpfPassageiro(input.getCpfPassageiro());
        passagem.setAssento(input.getAssento());
        passagem.setValor(input.getValor());
        passagem.setVooId(input.getVooId());
    }

    private Passagem toPassagem(PassagemDto input) {
        Passagem passagem = new Passagem();
        set(input, passagem);
        return passagem;
    }
}
