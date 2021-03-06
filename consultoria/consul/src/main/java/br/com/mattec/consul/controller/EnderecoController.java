package br.com.mattec.consul.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mattec.consul.dto.EnderecoDto;
import br.com.mattec.consul.entities.EnderecoEntity;
import br.com.mattec.consul.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

		@Autowired
		private EnderecoService service;
	
		@GetMapping("/{cep}")
	    public ResponseEntity<EnderecoDto> getCep(@PathVariable String cep) {

	        EnderecoDto endereco = service.getCep(cep);

	        return endereco != null ? ResponseEntity
	        	.ok().body(endereco) : ResponseEntity.notFound().build(); 
	    }
		
		@GetMapping("/findAll")
		public ResponseEntity<Object> findAll(){
			return ResponseEntity.ok().body(this.service.findAll());
		}
		
				
		@GetMapping("/findCep/{cep}")
		public ResponseEntity<Optional<EnderecoEntity>> findByCep(@PathVariable String cep) {
			return ResponseEntity.ok().body(this.service.findByCep(cep));
		}
		
		
		
		

}
