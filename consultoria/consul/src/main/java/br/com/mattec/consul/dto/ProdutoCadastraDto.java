package br.com.mattec.consul.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoCadastraDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private Long idCategoria;
	

}
