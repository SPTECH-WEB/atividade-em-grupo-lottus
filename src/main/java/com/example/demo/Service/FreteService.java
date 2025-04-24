package com.example.demo.Service;

import com.example.demo.Repository.FreteRepository;
import com.example.demo.model.Frete;
import com.example.demo.observer.EntregaObserver;
import com.example.demo.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreteService {
    private final FreteRepository repository;
    private final List<FreteStrategy> strategies;
    private final List<EntregaObserver> observers;

    public FreteService(FreteRepository repository, List<FreteStrategy> strategies, List<EntregaObserver> observers) {
        this.repository = repository;
        this.strategies = strategies;
        this.observers = observers;
    }

    public List<Frete> listarTodos() {
        return repository.findAll();
    }

    public Optional<Frete> buscarPorId(long id) {
        return repository.findById(id);
    }

    public List<Frete> buscarPorTipoEntrega(String tipoEntrega) {
        return repository.findByTipoEntrega(tipoEntrega);
    }

    public Frete salvarFrete(Frete frete) {
        FreteStrategy strategy = strategies.stream()
                .filter(s -> s.getClass().getSimpleName().equalsIgnoreCase("CalculoFrete" + frete.getTipoEntrega()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de entrega não suportado"));

        double valor = strategy.calcularFrete(frete);
        frete.setValor(valor);

        Frete freteSalvo = repository.save(frete);

        notificarObservers("Frete criado com valor: " + valor);
        return freteSalvo;
    }

    public void excluirFrete(Frete frete) {
        repository.delete(frete);
        notificarObservers("Frete excluído: " + frete.getId());
    }

    private void notificarObservers(String mensagem) {
        observers.forEach(observer -> observer.notificar(mensagem));
    }
}