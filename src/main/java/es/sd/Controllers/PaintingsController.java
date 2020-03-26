package es.sd.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaintingsController {

	@RequestMapping(value = "/paintings")
	public String paintings(Model model) {
		return "paintings";
	}
	
	
	
}
