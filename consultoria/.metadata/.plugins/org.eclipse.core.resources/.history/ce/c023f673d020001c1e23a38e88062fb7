package br.com.mattec.consul.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mattec.consul.dto.EnderecoDto;
import br.com.mattec.consul.entities.Endereco;
import br.com.mattec.consul.entities.client.ClientCep;
import br.com.mattec.consul.reporitory.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private ClientCep clientService;

	@Autowired
	public EnderecoRepository enderecoRepository;

// fAZER UM FINDBYCEP MO ENDERECO PARA VER SE O endereço já está no banco de dados.
	public EnderecoDto getCep(String cep) {
		Optional<Endereco> cepDto = enderecoRepository.findByCep(cep);
		if (cepDto.isPresent()) {

			return EnderecoDto.builder().cep(cepDto.get().getCep()).bairro(cepDto.get().getBairro())
					.logradouro(cepDto.get().getLogradouro()).complemento(cepDto.get().getComplemento())
					.localidade(cepDto.get().getLocalidade()).uf(cepDto.get().getUf()).ibge(cepDto.get().getIbge())
					.gia(cepDto.get().getGia()).ddd(cepDto.get().getDdd()).siafi(cepDto.get().getSiafi()).build();
		}else {

			ResponseEntity<EnderecoDto> endereco = this.clientService.getCep(cep);
			return endereco.getBody();
		}
	
	}

	public Endereco insert(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Object findAll() {
		return this.enderecoRepository.findAll();
	}

	public Optional<Endereco> findByCep(String cep) {
		return this.enderecoRepository.findByCep(cep);
	}

}