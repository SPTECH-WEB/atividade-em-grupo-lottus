package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("EXPRESSO")
public class FreteExpresso implements FreteStrategy{
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 0.7;
    }
}
