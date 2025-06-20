package com.jcsoftware.desafio_pontos.entities.dtos;

import com.jcsoftware.desafio_pontos.entities.Ponto;

public record PontoDTO(Long id,String name,Long x,Long y) {

	public PontoDTO(Ponto entity) {
		this(
				entity.getId(),
				entity.getName(),
				entity.getX(),
				entity.getY());
			
	}
}