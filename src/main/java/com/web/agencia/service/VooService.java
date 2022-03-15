package com.web.agencia.service;

import com.web.agencia.dto.VooDto;
import com.web.agencia.model.Voo;
import com.web.agencia.model.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VooService {

    private VooRepository vooRepository;

    @Autowired
    public VooService(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }

    public Voo save(VooDto input) {
        Voo voo = toVoo(input);
        return vooRepository.save(voo);
    }

    public Voo findById(Long id) {
        Optional<Voo> vooOptional = vooRepository.findById(id);
        if (vooOptional.isPresent()) {
            Voo voo = vooOptional.get();
            return voo;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    public List<Voo> findByData(String data) {
        return vooRepository.findByData(LocalDate.parse(data));
    }

    public List<Voo> findAll() {
        return vooRepository.findAll();
    }

    public Voo update(Long id, VooDto input) {
        Optional<Voo> vooOptional = vooRepository.findById(id);
        if (vooOptional.isPresent()) {
            Voo voo = vooOptional.get();
            set(input, voo);
            return voo;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    public void delete(Long id) {
        Optional<Voo> vooOptional = vooRepository.findById(id);
        if (vooOptional.isPresent()) {
            Voo voo = vooOptional.get();
            vooRepository.delete(voo);
            return;
        }
        throw new IllegalArgumentException("Id inválido");
    }

    private void set(VooDto input, Voo voo) {
        voo.setData(input.getData());
        voo.setLocalChegada(input.getLocalChegada());
        voo.setLocalPartida(input.getLocalPartida());
        voo.setHoraChegada(input.getHoraChegada());
        voo.setHoraPartida(input.getHoraPartida());
    }

    private Voo toVoo(VooDto input) {
        Voo voo = new Voo();
        set(input, voo);
        return voo;
    }

}
