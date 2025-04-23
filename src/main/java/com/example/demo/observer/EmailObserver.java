package com.example.demo.observer;

import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements EntregaObserver{

    public EmailObserver() {}

    @Override
    public void notificar(String mensagem) {
        System.out.println("Email enviado: " + mensagem);
    }
}
