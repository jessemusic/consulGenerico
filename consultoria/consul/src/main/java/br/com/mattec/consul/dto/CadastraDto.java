package br.com.mattec.consul.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mattec.consul.util.ClientInsertCpfOrCnpj;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@ClientInsertCpfOrCnpj
public class CadastraDto implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	
	private Integer tipo;
	
	@Column(unique = true, updatable = false)
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpfOuCnpj;
	
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String numeroEndereco;
	
	
	@Column(unique = true,updatable = false)
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;

}
