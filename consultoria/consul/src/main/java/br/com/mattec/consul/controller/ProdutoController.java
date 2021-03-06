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

import br.com.mattec.consul.dto.ProdutoCadastraDto;
import br.com.mattec.consul.dto.ProdutoDto;
import br.com.mattec.consul.entities.ProdutoEntity;
import br.com.mattec.consul.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;


	@GetMapping("/listProdutos")
	public ResponseEntity<Object> findAllAndCategoria() {
		return ResponseEntity.ok().body(this.service.findAllAndCategoria());

	}
	
	@GetMapping("/findProdutoByAll")
	public ResponseEntity<List<ProdutoDto>> findById() {
		return ResponseEntity.ok().body(this.service.findAll());

	}
	
	@PostMapping("/insert")
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoCadastraDto obj) {
		this.service.insert(obj);
		return ResponseEntity.ok().build();

	}
	

	@GetMapping("/findCodigoDeBarra")
	public ResponseEntity<List<ProdutoEntity>> findAllByOrderByCodigoDeBarraDesc() {
		return ResponseEntity.ok().body(this.service.findCodigoDeBarra());

	}

}
