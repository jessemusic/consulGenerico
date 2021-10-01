package br.com.mattec.consul.controller.validacao;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ValidaDocumentos {
	
	private String cpfValida;
	
	public boolean ValidaCPF(String cpfValida) {
		boolean validou = false;		
		CPFValidator validaCpf = new CPFValidator();
		try {
			validaCpf.assertValid(cpfValida);
			System.out.println("CFP Válido");
			validou = true;
		} catch (InvalidStateException e) {
			System.out.println("CPF Inválido " + e);
			validou = false;
		}
		return validou;
	}
	
	

}
