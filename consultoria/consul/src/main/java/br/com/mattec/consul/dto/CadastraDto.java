package br.com.mattec.consul.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastraDto implements Serializable{
	private static final long serialVersionUID = 1L;

	
	
	private String nome;
	
	private String cpf;
	
	private String numeroEndereco;
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;

}
