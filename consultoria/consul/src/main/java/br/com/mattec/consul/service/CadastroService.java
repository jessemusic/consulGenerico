package br.com.mattec.consul.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.client.CepClient;
import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.dto.EnderecoDto;
import br.com.mattec.consul.entities.ClientEntity;
import br.com.mattec.consul.entities.EnderecoEntity;
import br.com.mattec.consul.exceptions.ValidaException;
import br.com.mattec.consul.reporitory.ClientRepository;

@Service
public class CadastroService {

	@Autowired
	private CepClient cepClient;

	@Autowired
	private ClientService clientService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ClientRepository clientRepository;

	public void insert(CadastraDto cadDto) throws ValidaException {
		ClientEntity client = ClientEntity.builder().nome(cadDto.getNome()).tipo(cadDto.getTipo())
				.cpfOuCnpj(cadDto.getCpfOuCnpj())
				.numeroEndereco(cadDto.getNumeroEndereco()).complemento(cadDto.getComplemento()).build();
		Optional<EnderecoEntity> cep = enderecoService.findByCep(cadDto.getCep().replace("-", ""));
		
			Optional<CadastraDto> temCpfOuCnpjNoBanco = clientService.findOneWithCpfOuCnpj(cadDto.getCpfOuCnpj());
			try {
				if (temCpfOuCnpjNoBanco.isPresent())
					throw new ValidaException("CPF ou CNPJ já cadastrado ");

				if (cep.isPresent()) {
					client.setEndereco(cep.get());
					this.clientService.insert(client);
				} else {

					EnderecoEntity endereco = EnderecoEntity.builder().cep(cadDto.getCep().replace("-", ""))
							.logradouro(cadDto.getLogradouro()).bairro(cadDto.getBairro())
							.localidade(cadDto.getLocalidade()).uf(cadDto.getUf()).build();
					client.setEndereco(endereco);
					this.clientService.insert(client);
					this.enderecoService.insert(endereco);
				}
			} catch (ValidaException e) {
				throw new ValidaException(e.getMessage() + " com o número: " + cadDto.getCpfOuCnpj());
			}
		}

	public void update(CadastraDto upDto) {
		Optional<ClientEntity> clientAtual = clientRepository.findByCpfOuCnpj(upDto.getCpfOuCnpj());

		if (clientAtual.isPresent()) {
			clientAtual.get().setNome(upDto.getNome());
			clientAtual.get().setCpfOuCnpj(upDto.getCpfOuCnpj());
			clientAtual.get().setNumeroEndereco(upDto.getNumeroEndereco());
			clientAtual.get().setComplemento(upDto.getComplemento());

			Optional<EnderecoEntity> cep = enderecoService.findByCep(upDto.getCep().replace("-", ""));

			if (cep.isPresent()) {
				clientAtual.get().setEndereco(cep.get());
				this.clientService.insert(clientAtual.get());
			} else {

				ResponseEntity<EnderecoDto> endereco = this.cepClient.getCep(upDto.getCep());

				EnderecoEntity enderecoAtual = EnderecoEntity.builder().cep(endereco.getBody().getCep().replace("-", ""))
						.logradouro(endereco.getBody().getLogradouro()).complemento(endereco.getBody().getComplemento())
						.bairro(endereco.getBody().getBairro()).localidade(endereco.getBody().getLocalidade())
						.uf(endereco.getBody().getUf()).build();
				this.enderecoService.insert(enderecoAtual);
				clientAtual.get().setEndereco(enderecoAtual);
				this.clientService.insert(clientAtual.get());
			}
		}
	}
}
