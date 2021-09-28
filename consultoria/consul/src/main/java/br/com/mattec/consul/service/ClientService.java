package br.com.mattec.consul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.AtualizaDto;
import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.Client;
import br.com.mattec.consul.entities.Endereco;
import br.com.mattec.consul.reporitory.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public Client insert(Client client) {
		return clientRepository.save(client);
	}
	
	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}
	public List<CadastraDto> findAllCadastra(){
		return this.clientRepository.findAllCadastro();	
	}
	
	public List<CadastraDto> findAllClientEnderecoOne(String rua){
		return this.clientRepository.findAllClientEnderecoOne(rua);
	}
	
	
	


	
	
}
