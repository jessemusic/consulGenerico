package br.com.mattec.consul.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mattec.consul.entities.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {
	
	
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	private String logradouro;
	private String numeroEndereco;

	private String bairro;
	private String localidade;
	private String uf;
	
	public ClientDto() {
	}
	
	public ClientDto(ClientEntity obj) {
		id = obj.getId();
		nome = obj.getNome();
	}



}
