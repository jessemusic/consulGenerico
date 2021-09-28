package br.com.mattec.consul.dto;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaDto extends CadastraDto {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long id;
}
