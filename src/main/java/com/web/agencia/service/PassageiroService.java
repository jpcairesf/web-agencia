package com.web.agencia.service;

import com.web.agencia.dto.PassageiroDto;
import com.web.agencia.model.Passageiro;
import com.web.agencia.model.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {

    private PassageiroRepository passageiroRepository;

    @Autowired
    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }

    public Passageiro save(PassageiroDto input) {
        if (!passageiroRepository.findById(input.getCpf()).isPresent()) {
            Passageiro passageiro = toPassageiro(input);
            return passageiroRepository.save(passageiro);
        }
        throw new IllegalArgumentException("Já existe um passageiro com esse CPF");
    }

    public Passageiro findByCpf(String cpf) {
        Optional<Passageiro> passageiroOptional = passageiroRepository.findById(cpf);
        if (passageiroOptional.isPresent()) {
            Passageiro passageiro = passageiroOptional.get();
            return passageiro;
        }
        throw new IllegalArgumentException("Cpf inválido");
    }

    public List<Passageiro> findAll() {
        return passageiroRepository.findAll();
    }

    public Passageiro update(String cpf, PassageiroDto input) {
        Optional<Passageiro> passageiroOptional = passageiroRepository.findById(cpf);
        if (passageiroOptional.isPresent()) {
            Passageiro passageiro = passageiroOptional.get();
            set(input, passageiro);
            return passageiro;
        }
        throw new IllegalArgumentException("Cpf inválido");
    }

    public void delete(String cpf) {
        Optional<Passageiro> passageiroOptional = passageiroRepository.findById(cpf);
        if(passageiroOptional.isPresent()) {
            Passageiro passageiro = passageiroOptional.get();
            passageiroRepository.delete(passageiro);
            return;
        }
        throw new IllegalArgumentException("Cpf inválido");
    }

    private void set(PassageiroDto input, Passageiro passageiro) {
        passageiro.setCpf(input.getCpf());
        passageiro.setNome(input.getNome());
        passageiro.setDataNascimento(input.getDataNascimento());
        passageiro.setEndereco(input.getEndereco());
        passageiro.setTelefone(input.getTelefone());
    }

    private Passageiro toPassageiro(PassageiroDto input) {
        Passageiro passageiro = new Passageiro();
        set(input, passageiro);
        return passageiro;
    }

}
