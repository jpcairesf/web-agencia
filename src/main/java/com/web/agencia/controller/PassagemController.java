package com.web.agencia.controller;

import com.web.agencia.dto.PassagemDto;
import com.web.agencia.model.Passagem;
import com.web.agencia.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/passagem")
@RestController
public class PassagemController {

    private PassagemService passagemService;

    @Autowired
    public PassagemController(PassagemService passagemService) {
        this.passagemService = passagemService;
    }

    @GetMapping
    public List<Passagem> findAll() {
        return passagemService.findAll();
    }

    @GetMapping("/passageiro/{cpf}")
    public List<Passagem> findByCpfPassageiro(@PathVariable("cpf") String cpf) {
        return passagemService.findByCpfPassageiro(cpf);
    }

    @GetMapping("/{id}")
    public Passagem findById(@PathVariable("id") Long id) {
        return passagemService.findById(id);
    }

    @PostMapping
    public Passagem save(@Validated @RequestBody PassagemDto input) {
        return passagemService.save(input);
    }

    @PutMapping("/{id}")
    public Passagem update(@PathVariable("id") Long id, @Validated @RequestBody PassagemDto input) {
        return passagemService.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        passagemService.delete(id);
    }
}
