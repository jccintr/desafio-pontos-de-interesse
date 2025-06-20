package com.jcsoftware.desafio_pontos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jcsoftware.desafio_pontos.entities.Ponto;

public interface PontosRepository extends JpaRepository<Ponto,Long> {

	
	@Query("SELECT p FROM Ponto p WHERE POWER(p.x - :x0, 2) + POWER(p.y - :y0, 2) <= :radius * :radius")
		List<Ponto> findNear(
		    @Param("x0") Long x0,
		    @Param("y0") Long y0,
		    @Param("radius") Long radius
		);
	
}
