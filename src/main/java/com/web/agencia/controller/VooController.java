package com.web.agencia.controller;

import com.web.agencia.dto.VooDto;
import com.web.agencia.model.Voo;
import com.web.agencia.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/voo")
@RestController
public class VooController {

    private VooService vooService;

    @Autowired
    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

    @GetMapping
    public List<Voo> findAll() {
        return vooService.findAll();
    }

    @GetMapping("/data/{data}")
    public List<Voo> findByData(@PathVariable("data") String data) {
        return vooService.findByData(data);
    }

    @GetMapping("/{id}")
    public Voo findById(@PathVariable("id") Long id) {
        return vooService.findById(id);
    }

    @PostMapping
    public Voo save(@Validated @RequestBody VooDto input) {
        return vooService.save(input);
    }

    @PutMapping("/{id}")
    public Voo update(@PathVariable("id") Long id, @Validated @RequestBody VooDto input) {
        return vooService.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        vooService.delete(id);
    }
}
