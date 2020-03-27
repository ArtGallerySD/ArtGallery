package es.sd.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.sd.Entities.Autor;
import es.sd.Entities.Cuadro;
import es.sd.Repositories.AutorRepository;
import es.sd.Repositories.ClienteRepository;
import es.sd.Repositories.CuadroRepository;

@Controller
public class CuadroController {

	@Autowired
	CuadroRepository repCuadros;

	@Autowired
	AutorRepository repAutores;

	@Autowired
	ClienteRepository repClientes;

	@RequestMapping(value = "/cuadros")
	public String cuadros(Model model) {

		List<Autor> autores = repAutores.findAll();

		model.addAttribute("autores", autores);

		return "cuadros";
	}

	@RequestMapping(value = "/registroCuadros")
	public String registrarCuadro(@RequestParam String autor, Cuadro cuadro) {

		Autor a = repAutores.findByNombreAutor(autor);
		cuadro.setAutor(a);

		repCuadros.save(cuadro);

		a.getCuadrosCreados().add(cuadro);
		repAutores.save(a);

		return "registro";
	}

}
