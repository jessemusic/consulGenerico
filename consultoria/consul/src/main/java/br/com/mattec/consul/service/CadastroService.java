package br.com.mattec.consul.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.AtualizaDto;
import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.Client;
import br.com.mattec.consul.entities.Endereco;
import br.com.mattec.consul.reporitory.ClientRepository;

@Service
public class CadastroService {

	@Autowired
	private ClientService clientService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ClientRepository clientRepository;

	public void insert(CadastraDto cadDto) {
		Client client = Client.builder().nome(cadDto.getNome()).cpf(cadDto.getCpf())
				.numeroEndereco(cadDto.getNumeroEndereco()).complemento(cadDto.getComplemento()).build();
		Optional<Endereco> cep = enderecoService.findByCep(cadDto.getCep());

		if (cep.isPresent()) {
			client.setEndereco(cep.get());
			this.clientService.insert(client);
		} else {
			Endereco endereco = Endereco.builder().cep(cadDto.getCep()).logradouro(cadDto.getLogradouro())
					.bairro(cadDto.getBairro()).localidade(cadDto.getLocalidade()).uf(cadDto.getUf()).build();
			client.setEndereco(endereco);
			this.clientService.insert(client);
			this.enderecoService.insert(endereco);
		}

	}

	public void update(AtualizaDto upDto) {
		Optional<Client> clientId = clientRepository.findById(upDto.getId());
		if (clientId.isPresent()) {
			Client clientAtual = Client.builder().nome(upDto.getNome()).cpf(upDto.getCpf())
					.numeroEndereco(upDto.getNumeroEndereco()).complemento(upDto.getComplemento()).build();
			Endereco enderecoAtual = Endereco.builder().cep(upDto.getCep()).logradouro(upDto.getLogradouro())
					.bairro(upDto.getBairro()).localidade(upDto.getLocalidade()).uf(upDto.getUf()).build();
			clientAtual.setEndereco(enderecoAtual);
			this.clientService.insert(clientAtual);
			this.enderecoService.insert(enderecoAtual);
		}
		
	}

}
