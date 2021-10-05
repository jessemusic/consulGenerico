package br.com.mattec.consul.mapper;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.mattec.consul.dto.ClientDto;
import br.com.mattec.consul.entities.ClientEntity;
@Component
public class ClientMapper {
	
	public ClientEntity entityto(ClientDto clientDto) {
		
		ClientEntity client = ClientEntity.builder()
				.id(clientDto.getId())
				.nome(clientDto.getNome())
				.numeroEndereco(clientDto.getNumeroEndereco()).build();
		
		return client;
				
	}
	public ClientDto dtoTo(ClientEntity clientEntity) {
		return ClientDto.builder()
				.id(clientEntity.getId())
				.nome(clientEntity.getNome())
				.numeroEndereco(clientEntity.getNumeroEndereco())
				.build();
	}
	public Page<ClientDto> dtoListto(Page<ClientEntity> client){
		return client.map(new Function<ClientEntity, ClientDto>() {

			@Override
			public ClientDto apply(ClientEntity cliEnty) {
				
				return ClientDto.builder()
						.id(cliEnty.getId())
						.nome(cliEnty.getNome())
						.numeroEndereco(cliEnty.getNumeroEndereco())
						.build();
			}
		});
	}

}
