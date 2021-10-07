package br.com.mattec.consul.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@Entity
public class ProdutoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String codigoDeBarra;
	private LocalDateTime dataDeCompra;
	private LocalDateTime dataDeValidade;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categorias;
	
	public ProdutoEntity(Long id, String nome, BigDecimal preco, String codigoDeBarra, LocalDateTime dataDeCompra,
			LocalDateTime dataDeValidade, Categoria categorias) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.codigoDeBarra = codigoDeBarra;
		this.dataDeCompra = dataDeCompra;
		this.dataDeValidade = dataDeValidade;
		this.categorias = categorias;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(id, other.id);
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public BigDecimal getPreco() {
		return preco;
	}




	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}




	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}




	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}




	public LocalDateTime getDataDeCompra() {
		return dataDeCompra;
	}




	public void setDataDeCompra(LocalDateTime dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}




	public LocalDateTime getDataDeValidade() {
		return dataDeValidade;
	}




	public void setDataDeValidade(LocalDateTime dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}




	public Categoria getCategorias() {
		return categorias;
	}




	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	


}
