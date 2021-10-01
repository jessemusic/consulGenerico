package br.com.mattec.consul.util;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ValidaCpfCnpj {
	
	private String cpfValida;
	
	public static boolean ValidaCPF(String cpfValida) {
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