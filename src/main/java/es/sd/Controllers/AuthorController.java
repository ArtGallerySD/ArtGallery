package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

	@RequestMapping(value = "/authors")
	public String authors(Model model) {
		return "authors";
	}
	
}
