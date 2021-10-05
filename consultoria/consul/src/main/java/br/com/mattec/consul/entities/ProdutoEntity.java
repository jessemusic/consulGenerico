package br.com.mattec.consul.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoEntity {
	
	private Long id;
	private String nomeProduto;
	private BigDecimal valorProduto;
	private String codigoDeBarra;
	private LocalDateTime dataDeCompra;
	private LocalDateTime dataDeValidade;
	private Categoria categoriaId;
	

}
