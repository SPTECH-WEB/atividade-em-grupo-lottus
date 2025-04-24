package com.example.demo.strategy;

import com.example.demo.model.Frete;
import org.springframework.stereotype.Component;

@Component
public class CalculoFreteExpresso implements FreteStrategy {

    @Override
    public Double calcularFrete(Frete frete) {
        return frete.getPeso() * 2.5;
    }
}