package com.jcsoftware.desafio_pontos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.desafio_pontos.entities.Ponto;

public interface PontosRepository extends JpaRepository<Ponto,Long> {

}
