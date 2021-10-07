package br.com.mattec.consul.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.mattec.consul.entities.Categoria;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ProdutoDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String codigoDeBarra;
	private LocalDateTime dataDeCompra;
	private LocalDateTime dataDeValidade;
	private String nomeCategoria;
	
	
	

}
