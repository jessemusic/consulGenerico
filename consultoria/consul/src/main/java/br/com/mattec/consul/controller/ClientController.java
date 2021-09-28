package br.com.mattec.consul.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.Client;
import br.com.mattec.consul.service.CadastroService;
import br.com.mattec.consul.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private CadastroService service;
	
	@Autowired
	private ClientService cliService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody CadastraDto obj){
		this.service.insert(obj);
		return ResponseEntity.ok().build();
	
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok().body(this.cliService.findAll());
	
	}
	
	@GetMapping("/findAllCadastra")
	public ResponseEntity<List<CadastraDto>> FindAllCadastra(){
		return ResponseEntity.ok().body(this.cliService.findAllCadastra());
	}
	
	@GetMapping("/findClientEnderecoOne")
	public ResponseEntity<List<CadastraDto>> findAllClientEnderecoOne(@RequestParam String rua){
		return ResponseEntity.ok().body(this.cliService.findAllClientEnderecoOne(rua));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Void> update(@PathVariable CadastraDto obj){
		this.service.insert(obj);
		return ResponseEntity.ok().build();
	
	}
	
	
	

}
