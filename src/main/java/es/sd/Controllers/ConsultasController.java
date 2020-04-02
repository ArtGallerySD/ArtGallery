package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultasController {

	// MAPEO DE LA PASARELA PARA ACCEDER AL MÓDULO DE CONSULTAS Y MODIFICACIONES

	@RequestMapping(value = "/consultas")
	public String consultas(Model model) {
		return "consultas";
	}

}
