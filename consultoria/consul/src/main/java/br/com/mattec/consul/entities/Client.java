package br.com.mattec.consul.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

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
@Table(name = "client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	@Column(unique = true, updatable = false)
	@NotEmpty(message = "Preenchimento obrigatório")
	@CPF
	private String cpf;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String numeroEndereco;
	
	private String complemento;
	
	@JsonBackReference 
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
	 private Endereco endereco;
	
	
}
