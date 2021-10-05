package br.com.mattec.consul.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@PostMapping("/save")
	public ResponseEntity<Void> save(@Valid @RequestBody Categoria obj) {
		this.service.insert(obj);
		return ResponseEntity.ok().build();

	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Categoria>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());

	}

}