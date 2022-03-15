package com.web.agencia.controller;

import com.web.agencia.model.Voo;
import com.web.agencia.service.VooService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/home")
@RestController
public class HomeController {

    private VooService vooService;

    public HomeController(VooService vooService) {
        this.vooService = vooService;
    }

    @GetMapping
    public List<Voo> getVoos() {
        return vooService.findByData(LocalDate.now().toString());
    }
}
