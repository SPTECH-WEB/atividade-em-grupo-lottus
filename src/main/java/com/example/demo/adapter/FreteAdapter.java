package com.example.demo.adapter;

import com.example.demo.model.Frete;
import com.example.demo.strategy.FreteStrategy;
import org.springframework.stereotype.Component;

@Component("transportadoraExterna")
public class FreteAdapter implements FreteStrategy {

    private final FreteExterno freteExterno;

    public FreteAdapter() {
        this.freteExterno = new FreteExterno();
    }

    @Override
    public Double calcularFrete(Frete frete) {
        return freteExterno.calcularFreteExterno(frete.getPeso());
    }
}