package br.com.mattec.consul.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data

@NoArgsConstructor
@Entity
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nomeDaCategoria;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "categorias",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ProdutoEntity> produtos = new ArrayList<>();

	public Categoria(Long id, String nomeDaCategoria) {
		super();
		this.id = id;
		this.nomeDaCategoria = nomeDaCategoria;
	}

	
}
