package com.example.demo.Repository;

import com.example.demo.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreteRepository extends JpaRepository<Frete,Long> {
    List<Frete> findByTipoEntrega(String tipoEntrega);

}
