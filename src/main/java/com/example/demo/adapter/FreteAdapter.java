package com.example.demo.adapter;

import com.example.demo.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

@Service("transportadora-externa")
public class FreteAdapter implements FreteStrategy {

    private final FreteExterno freteExterno;

    public FreteAdapter() {
        this.freteExterno = new FreteExterno();
    }

    @Override
    public Double calcularFrete(Double peso) {
        return freteExterno.calcularFreteExterno(peso);
    }
}
