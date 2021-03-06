package br.com.mattec.consul.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class EnderecoEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Column(unique = true,updatable = false)
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
	@JsonBackReference
	@OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ClientEntity> clients;

}
