package br.com.mattec.consul.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FieldMessageCustom  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	

}
