package br.com.mattec.consul;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mattec.consul.dto.EnderecoDto;

class ConsulApplicationTest {

	@Test
	void consumindoApi() {
		RestTemplate template = new RestTemplate();
		// http://viacep.com.br/ws/09320720/json/
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("viacep.com.br")
				.path("ws/09320720/json/")
				.build();
		ResponseEntity<EnderecoDto> entity = template.getForEntity(uri.toUriString(), EnderecoDto.class);
		System.out.println(entity.getBody().getLogradouro());
			}

}
