package br.com.mattec.consul.entities.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.mattec.consul.dto.EnderecoDto;

@Component
public class CepClient {

	private RestTemplate restTemplate;

	@Value("${client.cep.url}")
	private String cepUrl;

	public ResponseEntity<EnderecoDto> getCep(String cep) {

		this.restTemplate = new RestTemplate();

		ResponseEntity<EnderecoDto> response = restTemplate.getForEntity(cepUrl + cep + "/json", EnderecoDto.class);
		return response;
	}
	

	

}
