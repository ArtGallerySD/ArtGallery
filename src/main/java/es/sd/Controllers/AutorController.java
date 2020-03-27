package es.sd.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.sd.Entities.Autor;
import es.sd.Repositories.AutorRepository;

@Controller
public class AutorController {

	@Autowired
	AutorRepository repAutor;

	@RequestMapping(value = "/autores")
	public String autores(Model model) {
		return "autores";
	}

	@RequestMapping(value = "/registroAutores")
	public String registrarAutor(Autor autor) {
		
		repAutor.save(autor);

		return "registro";
	}

}
