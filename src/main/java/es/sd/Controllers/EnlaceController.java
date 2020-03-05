package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnlaceController {
	
	@RequestMapping(value="/mostrar/{comentario}")
	public String ej5(@PathVariable(value="comentario") String comentario, Model model) {
		
		model.addAttribute("comentario", comentario);
		
		return "mostrar";
	}
	
	@RequestMapping(value="/salida/{name}")
	public String pipo(@PathVariable(value="name") String name, Model model) {
		
		model.addAttribute("name", name);
		
		return "mostrar";
	}


}
