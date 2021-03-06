package br.com.mattec.consul.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDto {
	
	private Long id;
	private String nome;
	private BigDecimal preco;
	private Integer codigoDeBarra;
	private Integer quantidade;
	private String categoria;

}
