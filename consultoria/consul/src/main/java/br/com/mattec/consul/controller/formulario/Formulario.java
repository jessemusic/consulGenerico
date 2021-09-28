package br.com.mattec.consul.controller.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Formulario {
	
	@GetMapping("/formulario")
	public ModelAndView exibirFormulario() {
		return new ModelAndView("index");
	}

}
