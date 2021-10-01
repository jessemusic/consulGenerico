package br.com.mattec.consul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.Client;
import br.com.mattec.consul.service.CadastroService;
import br.com.mattec.consul.service.ClientService;
import br.com.mattec.consul.service.exception.ValidaException;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private CadastroService service;
	
	@Autowired
	private ClientService cliService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody CadastraDto obj) throws ValidaException{
		this.service.insert(obj);
		return ResponseEntity.ok().build();
	
	}
	//busca todos os clientes
	@GetMapping("/findAll")
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok().body(this.cliService.findAll());
	
	}
	//busca todos os clientes com seus endereços
	@GetMapping("/findAllCadastra")
	public ResponseEntity<List<CadastraDto>> FindAllCadastra(){
		return ResponseEntity.ok().body(this.cliService.findAllCadastra());
	}
	//traz uma lista de todos clientes contidos em um único endereço, dado o endereço no path
	@GetMapping("/findClientEnderecoOne")
	public ResponseEntity<List<CadastraDto>> findAllClientEnderecoOne(@RequestParam String rua){
		return ResponseEntity.ok().body(this.cliService.findAllClientEnderecoOne(rua));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> update(@RequestBody CadastraDto obj){
		this.service.update( obj);
		return ResponseEntity.ok().build();
	
	}
	@GetMapping("/findOneWithCpf/{cpf}")
	public ResponseEntity<Optional<CadastraDto>> findByCpfOne(@PathVariable String cpf){
		return ResponseEntity.ok().body(this.cliService.findbyCpfOne(cpf));
	}
	
	
	

}
