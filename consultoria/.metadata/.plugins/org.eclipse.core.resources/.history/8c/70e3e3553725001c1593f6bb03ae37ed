package br.com.mattec.consul.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mattec.consul.entities.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	
	public ClienteDto() {
	}
	
	public ClienteDto(Client obj) {
		id = obj.getId();
		nome = obj.getNome();
	}



}
