package es.sd.Controllers;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@PostConstruct
	public void init() {
		/*
		 * Autor p1 = new Autor("rodrigamerXXX", "Rodrigo", "Sanchez"); Autor p2 = new
		 * Autor("loliSlayerX", "Jesús-Alberto", "De las Heras"); repPersonas.save(p1);
		 * repPersonas.save(p2);
		 * 
		 * Cliente hola = new Cliente("Hola...", "XXXX"); Cliente adios = new
		 * Cliente("Adios...", "XXXX"); hola.setAutor(p1); adios.setAutor(p2);
		 * repAnuncios.save(hola); repAnuncios.save(adios);
		 * 
		 * p1.getAnuncios().add(hola); p2.getAnuncios().add(adios);
		 * repPersonas.save(p1); repPersonas.save(p2);
		 */
	}

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping(value = "blog")
	public String blog(Model model) {
		return "blog";
	}
	
	@RequestMapping(value = "/portfolio")
	public String portfolio(Model model) {
		return "portfolio";
	}
	
	@RequestMapping(value = "/about")
	public String about(Model model) {
		return "about";
	}
	
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		return "contact";
	}

}
