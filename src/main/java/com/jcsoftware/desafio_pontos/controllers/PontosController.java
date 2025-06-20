package com.jcsoftware.desafio_pontos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.desafio_pontos.entities.dtos.PontoDTO;
import com.jcsoftware.desafio_pontos.services.PontosService;

@RestController
@RequestMapping(value = "/pontos")
public class PontosController {

	
	@Autowired
	private PontosService service;
	
	@GetMapping
	public ResponseEntity<List<PontoDTO>> findAll(){
		List<PontoDTO> pontos = service.findAll();
        return ResponseEntity.ok().body(pontos);
	}
}
