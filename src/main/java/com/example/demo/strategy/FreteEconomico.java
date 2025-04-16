package com.example.demo.strategy;

import com.example.demo.model.Frete;
import org.springframework.stereotype.Component;

@Component("ECONOMICA")
public class FreteEconomico implements FreteStrategy {


    @Override
    public Double calcularFrete(Double peso) {
        return peso * .2;
    }
}
