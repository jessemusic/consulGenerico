package br.com.mattec.consul.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.mattec.consul.controller.exceptions.FieldMessageCustom;
import br.com.mattec.consul.dto.CadastraDto;
import br.com.mattec.consul.entities.enums.TipoClient;
import br.com.mattec.consul.service.validation.util.BR;

public class ClientInsertCpfOrCnpjValidator implements ConstraintValidator<ClientInsertCpfOrCnpj, CadastraDto> {

	@Override
	public void initialize(ClientInsertCpfOrCnpj ann) {
	}

	@Override
	public boolean isValid(CadastraDto objDto, ConstraintValidatorContext context) {

		int tem = 0;

		for (TipoClient tc : TipoClient.values()) {
			System.out.println(tc.getCod());
			if (objDto.getTipo() == tc.getCod()) {
				tem += 1;
			} 
		}
		System.out.println(tem + "cógido no body -> " + objDto.getTipo());
		if (tem != 0) {
			List<FieldMessageCustom> list = new ArrayList<>();

			if (objDto.getTipo().equals(TipoClient.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
				list.add(new FieldMessageCustom("cpfOuCnpj", "CPF Inválido"));
			}
			if (objDto.getTipo().equals(TipoClient.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {

				list.add(new FieldMessageCustom("cpfOuCnpj", "CNPJ Inválido"));
			}
			for (FieldMessageCustom e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
						.addConstraintViolation();

			}
			return list.isEmpty();

		}else {
			throw new IllegalArgumentException();
		}

	}
}
