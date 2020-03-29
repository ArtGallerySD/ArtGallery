package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultasController {

	@RequestMapping(value = "/consultas")
	public String consultas(Model model) {
		return "consultas";
	}

}
