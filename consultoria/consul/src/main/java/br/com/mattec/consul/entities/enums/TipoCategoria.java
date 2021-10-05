package br.com.mattec.consul.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCategoria {
	ELETRODOMESTICO(1, "Eletrodomésticos"),
	PRODUTOLIMPEZA(2, "Produto de limpeza");
	
	private Integer cod;
	private String descricao;
	
	public static TipoCategoria toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoCategoria codigos : TipoCategoria.values()) {
			if(cod.equals(codigos.getCod())) {
				return codigos;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
