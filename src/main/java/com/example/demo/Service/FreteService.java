package com.example.demo.Service;

import com.example.demo.Repository.FreteRepository;
import com.example.demo.model.Frete;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreteService {
    private final FreteRepository repository;
    public FreteService(FreteRepository repository) {
        this.repository = repository;
    }

    public List<Frete> findByTipoEntrega(String tipoEntrega) {
        return repository.findAll();
    }

    public Optional<Frete> buscarPorID(long id) {
        return repository.findById(id);
    }

    public Frete salvar(Frete frete) {
        return repository.save(frete);
    }

    public void excluir(Frete frete) {
        repository.delete(frete);
    }

}
