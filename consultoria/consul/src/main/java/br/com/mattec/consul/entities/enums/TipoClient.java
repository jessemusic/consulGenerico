package br.com.mattec.consul.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoClient {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;
	
	public static TipoClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (TipoClient codigos : TipoClient.values()) {
			if(cod.equals(codigos.getCod())) {
				return codigos;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}


