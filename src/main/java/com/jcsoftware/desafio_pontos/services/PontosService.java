package com.jcsoftware.desafio_pontos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcsoftware.desafio_pontos.entities.Ponto;
import com.jcsoftware.desafio_pontos.entities.dtos.InsertPontoDTO;
import com.jcsoftware.desafio_pontos.entities.dtos.PontoDTO;
import com.jcsoftware.desafio_pontos.repositories.PontosRepository;
import com.jcsoftware.desafio_pontos.services.exceptions.ResourceNotFoundException;

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

	public List<PontoDTO> find(Long x, Long y, Long distance) {
		List<Ponto> pontos = repository.findNear(x, y, distance);
		return pontos.stream().map(PontoDTO::new).toList();
	}

	public PontoDTO findById(Long id) {
		Optional<Ponto> pontoO = repository.findById(id);
		Ponto ponto = pontoO.orElseThrow(() -> new ResourceNotFoundException());
		PontoDTO dto = new PontoDTO(ponto);
		return dto;
	}

}
