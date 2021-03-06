package br.com.mattec.consul.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDoPedido;
	private LocalDateTime dataDoPedido;
	private Integer quantidadeDeItens;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ProdutoEntity> produtoId;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClientEntity cliente;

	public PedidoEntity(Long id, Integer numeroDoPedido, LocalDateTime dataDoPedido, Integer quantidadeDeItens,
			ClientEntity cliente) {
		super();
		this.id = id;
		this.numeroDoPedido = numeroDoPedido;
		this.dataDoPedido = dataDoPedido;
		this.quantidadeDeItens = quantidadeDeItens;
		this.cliente = cliente;
	}
	
	
	
}
