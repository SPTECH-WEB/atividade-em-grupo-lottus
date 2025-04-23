package com.example.demo.adapter;

public class FreteExterno {
    public Double calcularFreteExterno(double peso) {
        System.out.println("Calculando frete externo para peso: " + peso);

        double valorFrete = peso * 10.0;
        System.out.println("Valor do frete externo: R$ " + valorFrete);
        return valorFrete;
    }
}
