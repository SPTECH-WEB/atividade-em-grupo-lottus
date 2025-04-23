package com.example.demo.observer;

import org.springframework.stereotype.Component;

@Component
public class SmsObserver implements EntregaObserver {

    public SmsObserver(){}

    @Override
    public void notificar(String mensagem){
        System.out.println("SMS enviado: " + mensagem);
    }
}
