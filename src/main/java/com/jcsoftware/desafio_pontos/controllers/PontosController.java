package com.jcsoftware.desafio_pontos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jcsoftware.desafio_pontos.entities.dtos.InsertPontoDTO;
import com.jcsoftware.desafio_pontos.entities.dtos.PontoDTO;
import com.jcsoftware.desafio_pontos.services.PontosService;

@RestController
@RequestMapping(value = "/pontos")
public class PontosController {

	
	@Autowired
	private PontosService service;
	
	@PostMapping()
	public ResponseEntity<PontoDTO> insert(@RequestBody InsertPontoDTO dto){
		PontoDTO pontoDTO = service.insert(dto);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(pontoDTO.id()).toUri();
			
			return ResponseEntity.created(uri).body(pontoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<PontoDTO>> findAll(){
		List<PontoDTO> pontos = service.findAll();
        return ResponseEntity.ok().body(pontos);
	}
}
