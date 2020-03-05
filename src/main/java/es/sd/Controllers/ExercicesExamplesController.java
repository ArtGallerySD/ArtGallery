package es.sd.Controllers;

import org.springframework.stereotype.Controller;

@Controller
public class ExercicesExamplesController {
/*
	@Autowired
	private AnuncioRepository repAnuncios;

	@RequestMapping(value = "/")
	public String tablon(Model model) {

		model.addAttribute("anuncios", repAnuncios.findAll());

		return "tablonAnuncio";
	}

	@RequestMapping(value = "/query")
	public String query(Autor autor, String asunto, Model model) {

		model.addAttribute("anuncios", repAnuncios.findByAutorAndAsunto(autor, asunto));

		return "anunciosNyA";
	}

	@RequestMapping(value = "/insert")
	public String redirectInsert() {

		return "insertarAnuncio";
	}

	@RequestMapping(value = "/save")
	public String save(Cliente anuncio, Model model) {

		repAnuncios.save(anuncio);

		return "exitoAnuncio";
	}

	@RequestMapping(value = "/mostrar")
	public String mostrar(Model model, @RequestParam(value = "name") Autor autor,
			@RequestParam(value = "asunt") String asunto) {

		model.addAttribute("anuncios", repAnuncios.findByAutorAndAsunto(autor, asunto));

		return "mostrarAnuncio";
	}
*/
}
