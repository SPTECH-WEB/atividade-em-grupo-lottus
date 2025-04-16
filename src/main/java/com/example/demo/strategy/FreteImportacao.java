package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("IMPORTACAO")
public class FreteImportacao implements FreteStrategy{
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 0.5;
    }
}
