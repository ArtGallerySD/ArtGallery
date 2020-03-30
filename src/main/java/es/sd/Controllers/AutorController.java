package es.sd.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sd.Entities.Autor;
import es.sd.Repositories.AutorRepository;

@Controller
public class AutorController {

	@Autowired
	AutorRepository repAutores;

	@RequestMapping(value = "/autores")
	public String autores(Model model) {
		return "autores";
	}

	@RequestMapping(value = "/registroAutores")
	public String registrarAutor(Autor autor) {

		repAutores.save(autor);

		return "registro";
	}

	@RequestMapping(value = "/consultasAutores")
	public String mostrarAutores(Model model) {

		List<Autor> autores = repAutores.findAll();

		model.addAttribute("autores", autores);

		return "consultasAutores";
	}

	@RequestMapping(value = "/modificarAutor")
	public String modificarAutor(@RequestParam long id, Model model) {

		Autor autor = repAutores.findByIdAutor(id);

		model.addAttribute("autor", autor);

		return "modificarAutor";
	}

	@RequestMapping(value = "/edicionAutores")
	public String resultadoEdicionAutor(Autor a) {

		Autor autor = repAutores.findByIdAutor(a.getIdAutor());

		repAutores.delete(autor);
		repAutores.save(a);

		return "edicion";
	}

}
