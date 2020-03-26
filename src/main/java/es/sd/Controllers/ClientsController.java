package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientsController {

	@RequestMapping(value = "/clients")
	public String clients(Model model) {
		return "clients";
	}
	
	
}
