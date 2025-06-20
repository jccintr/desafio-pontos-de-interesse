package com.jcsoftware.desafio_pontos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcsoftware.desafio_pontos.entities.Ponto;
import com.jcsoftware.desafio_pontos.entities.dtos.InsertPontoDTO;
import com.jcsoftware.desafio_pontos.entities.dtos.PontoDTO;
import com.jcsoftware.desafio_pontos.repositories.PontosRepository;

@Service
public class PontosService {
	
	@Autowired
	private PontosRepository repository;

	public List<PontoDTO> findAll() {
		
		List<Ponto> pontos = repository.findAll();
		return pontos.stream().map(PontoDTO::new).toList();
		
	}

	public PontoDTO insert(InsertPontoDTO dto) {
		Ponto newPonto = new Ponto();
		newPonto.setName(dto.name());
		newPonto.setX(dto.x());
		newPonto.setY(dto.y());
		newPonto = repository.save(newPonto);
		return new PontoDTO(newPonto);
	}

	public List<PontoDTO> find(Long x, Long y) {
		List<Ponto> pontos = repository.findNear(x, y, 10L);
		return pontos.stream().map(PontoDTO::new).toList();
	}

}
