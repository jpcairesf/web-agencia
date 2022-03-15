package com.web.agencia.controller;

import com.web.agencia.dto.PassageiroDto;
import com.web.agencia.model.Passageiro;
import com.web.agencia.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/passageiro")
@RestController
public class PassageiroController {

    private PassageiroService passageiroService;

    @Autowired
    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
    }

    @GetMapping
    public List<Passageiro> findAll() {
        return passageiroService.findAll();
    }

    @GetMapping("/{cpf}")
    public Passageiro findByCpf(@PathVariable("cpf") String cpf) {
        return passageiroService.findByCpf(cpf);
    }

    @PostMapping
    public Passageiro save(@Validated @RequestBody PassageiroDto input) {
        return passageiroService.save(input);
    }

    @PutMapping("/{cpf}")
    public Passageiro update(@PathVariable("cpf") String cpf, @Validated @RequestBody PassageiroDto input) {
        return passageiroService.update(cpf, input);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        passageiroService.delete(cpf);
    }
}
