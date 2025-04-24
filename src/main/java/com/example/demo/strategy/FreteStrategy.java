package com.example.demo.strategy;
import com.example.demo.model.Frete;

public interface FreteStrategy {

    Double calcularFrete(Frete frete);
}
