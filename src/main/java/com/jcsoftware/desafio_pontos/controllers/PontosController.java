package com.jcsoftware.desafio_pontos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jcsoftware.desafio_pontos.entities.dtos.InsertPontoDTO;
import com.jcsoftware.desafio_pontos.entities.dtos.PontoDTO;
import com.jcsoftware.desafio_pontos.services.PontosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/points")
public class PontosController {

	
	@Autowired
	private PontosService service;
	
	@PostMapping()
	public ResponseEntity<PontoDTO> insert(@RequestBody @Valid InsertPontoDTO dto){
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PontoDTO> findById(@PathVariable Long id){
		PontoDTO pontoDTO = service.findById(id);
		return ResponseEntity.ok().body(pontoDTO);
	}
	
	@GetMapping(value="/near")
	public ResponseEntity<List<PontoDTO>> find(@RequestParam(required=true) Long x, @RequestParam(required=true) Long y,@RequestParam(defaultValue = "10") Long distance){
		List<PontoDTO> pontos = service.find(x,y,distance);
        return ResponseEntity.ok().body(pontos);
	}
}
