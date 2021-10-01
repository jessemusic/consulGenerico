package br.com.mattec.consul.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

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

	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	
	@Column(unique = true, updatable = false)
	@NotEmpty(message = "Preenchimento obrigatório")
	@CPF
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String numeroEndereco;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Column(unique = true,updatable = false)
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
}
