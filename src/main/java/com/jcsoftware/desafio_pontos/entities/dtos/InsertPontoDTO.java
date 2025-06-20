package com.jcsoftware.desafio_pontos.entities.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record InsertPontoDTO(
		
		@NotNull(message="Campo requerido")
		String name,
		@PositiveOrZero(message="Deve ser um número positivo ou zero")
		@NotNull(message="Campo requerido")
		Long x,
		@PositiveOrZero(message="Deve ser um número positivo ou zero")
		@NotNull(message="Campo requerido")
		Long y) {

}
