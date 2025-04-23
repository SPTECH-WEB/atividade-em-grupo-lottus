package com.example.demo.controller;

import com.example.demo.Service.FreteService;
import com.example.demo.model.Frete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService service;

    public FreteController(FreteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Frete>> listarFretes() {
        List<Frete> fretes = service.findByTipoEntrega(null);
        return ResponseEntity.ok(fretes);
    }

    @PostMapping
    public ResponseEntity<Frete> criarFrete(@RequestBody Frete frete) {
        Frete novoFrete = service.salvar(frete);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFrete);
    }
}