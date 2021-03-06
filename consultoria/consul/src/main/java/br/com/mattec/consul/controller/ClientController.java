package br.com.mattec.consul.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.dto.ClientDto;
import br.com.mattec.consul.exceptions.ValidaException;
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
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Void> save(@Valid @RequestBody CadastraDto obj) throws ValidaException{
		this.service.insert(obj);
		return ResponseEntity.ok().build();
	
	}
	//busca todos os clientes
	@GetMapping("/listFindAllClient")
	public ResponseEntity<List<ClientDto>> listFindAll(){
		return ResponseEntity.ok().body(this.cliService.findAll().stream()
				.map(ClientDto::new).collect(Collectors.toList()));
	
	}
	//busca todos os clientes com seus endereços
	@GetMapping("/findAllCadastra")
	public ResponseEntity<List<CadastraDto>> FindAllCadastra(){
		return ResponseEntity.ok().body(this.cliService.findAllCadastra());
	}
	//traz uma lista de todos clientes contidos em um único endereço, dado o endereço no path
	@GetMapping("/findClientsEnderecoOne")
	public ResponseEntity<List<CadastraDto>> findClientsEnderecoOne(@RequestParam String rua){
		return ResponseEntity.ok().body(this.cliService.findClientsEnderecoOne(rua));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> update(@Valid @RequestBody CadastraDto obj){
		this.service.update( obj);
		return ResponseEntity.ok().build();
	
	}
	@GetMapping("/findOneWithCpfOuCnpj/{cpfOuCnpj}")
	public ResponseEntity<Optional<CadastraDto>> findOneWithCpfOuCnpj(@PathVariable String cpfOuCnpj){
		return ResponseEntity.ok().body(this.cliService.findOneWithCpfOuCnpj(cpfOuCnpj));
	}
	
}
