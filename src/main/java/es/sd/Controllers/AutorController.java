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
	private AutorRepository repAutores;

	private Autor autorEditando;

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
		autorEditando = autor;

		model.addAttribute("autor", autor);

		return "modificarAutor";
	}

	@RequestMapping(value = "/edicionAutores")
	public String resultadoEdicionAutor(Autor a) {

		if (!autorEditando.getNombreAutor().equals(a.getNombreAutor()))
			autorEditando.setNombreAutor(a.getNombreAutor());

		if (!autorEditando.getApellidosAutor().equals(a.getApellidosAutor()))
			autorEditando.setApellidosAutor(a.getApellidosAutor());

		if (!autorEditando.getNifAutor().equals(a.getNifAutor()))
			autorEditando.setNifAutor(a.getNifAutor());

		if (autorEditando.getAnoNacimientoAutor() != a.getAnoNacimientoAutor())
			autorEditando.setAnoNacimientoAutor(a.getAnoNacimientoAutor());

		if (!autorEditando.getPaisNacimientoAutor().equals(a.getPaisNacimientoAutor()))
			autorEditando.setPaisNacimientoAutor(a.getPaisNacimientoAutor());

		if (autorEditando.getCpAutor() != a.getCpAutor())
			autorEditando.setCpAutor(a.getCpAutor());

		if (!autorEditando.getMailAutor().equals(a.getMailAutor()))
			autorEditando.setMailAutor(a.getMailAutor());

		if (autorEditando.getTelefonoAutor() != a.getTelefonoAutor())
			autorEditando.setTelefonoAutor(a.getTelefonoAutor());

		repAutores.save(autorEditando);
		return "edicion";
	}

}
