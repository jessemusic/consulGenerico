package br.com.mattec.consul.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.mattec.consul.entities.enums.TipoClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
@Setter
@Getter
public class ClientEntity {
	
	
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=150,message = "O tamanho de ser entre 5 e 120 caracteres")
	private String nome;
	
	@Column(unique = true, updatable = false)
	private String cpfOuCnpj;
	
	private Integer tipo;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String numeroEndereco;
	
	private String complemento;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
	 private EnderecoEntity endereco;
	
	@OneToMany(mappedBy ="cliente")
	private List<PedidoEntity> pedidos;
	
	public ClientEntity(Long id,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 5, max = 150, message = "O tamanho de ser entre 5 e 120 caracteres") String nome,
			@NotEmpty(message = "Preenchimento obrigatório") String cpfOuCnpj, TipoClient tipo,
			@NotEmpty(message = "Preenchimento obrigatório") String numeroEndereco, String complemento,
			EnderecoEntity endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo==null) ? null :tipo.getCod();
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.endereco = endereco;
	}

	
	public TipoClient getTipo() {
		return TipoClient.toEnum(tipo);
	}
	
	public void setTipo(TipoClient tipo) {
		this.tipo = tipo.getCod();
		
	}

	


}
