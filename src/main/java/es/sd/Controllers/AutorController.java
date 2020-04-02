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

	// MAPEO DE AUTORES

	@RequestMapping(value = "/autores")
	public String autores(Model model) {
		return "autores";
	}

	// REGISTRO DE AUTORES

	@RequestMapping(value = "/registroAutores")
	public String registrarAutor(@RequestParam String nifAutor, @RequestParam String mailAutor,
			@RequestParam int telefonoAutor, Autor autor) {

		if ((repAutores.findByNifAutor(nifAutor) == null) && (repAutores.findByMailAutor(mailAutor) == null)
				&& (repAutores.findByTelefonoAutor(telefonoAutor) == null)) {
			repAutores.save(autor);

			return "exito_registro";
		} else
			return "fallo_registro_autor";

	}

	// CONSULTAS, FILTROS Y ORDENACIÓN DE AUTORES

	@RequestMapping(value = "/consultasAutores")
	public String mostrarAutores(Model model) {

		List<Autor> autores = repAutores.findAll();

		model.addAttribute("autores", autores);

		return "consultasAutores";
	}

	@RequestMapping(value = "/ordenarAutores")
	public String ordenarAutores(@RequestParam int ordenAutor, Model model) {

		switch (ordenAutor) {
		case 0:
			List<Autor> autores0 = repAutores.findAll();
			model.addAttribute("autores", autores0);
			break;
		case 1:
			List<Autor> autores1 = repAutores.findAllByOrderByNombreAutorAsc();
			model.addAttribute("autores", autores1);
			break;
		case 2:
			List<Autor> autores2 = repAutores.findAllByOrderByNombreAutorDesc();
			model.addAttribute("autores", autores2);
			break;
		case 3:
			List<Autor> autores3 = repAutores.findAllByOrderByApellidosAutorAsc();
			model.addAttribute("autores", autores3);
			break;
		case 4:
			List<Autor> autores4 = repAutores.findAllByOrderByApellidosAutorDesc();
			model.addAttribute("autores", autores4);
			break;
		case 5:
			List<Autor> autores5 = repAutores.findAllByOrderByNifAutorAsc();
			model.addAttribute("autores", autores5);
			break;
		case 6:
			List<Autor> autores6 = repAutores.findAllByOrderByNifAutorDesc();
			model.addAttribute("autores", autores6);
			break;
		case 7:
			List<Autor> autores7 = repAutores.findAllByOrderByAnoNacimientoAutorAsc();
			model.addAttribute("autores", autores7);
			break;
		case 8:
			List<Autor> autores8 = repAutores.findAllByOrderByAnoNacimientoAutorDesc();
			model.addAttribute("autores", autores8);
			break;
		case 9:
			List<Autor> autores9 = repAutores.findAllByOrderByPaisNacimientoAutorAsc();
			model.addAttribute("autores", autores9);
			break;
		case 10:
			List<Autor> autores10 = repAutores.findAllByOrderByPaisNacimientoAutorDesc();
			model.addAttribute("autores", autores10);
			break;
		case 11:
			List<Autor> autores11 = repAutores.findAllByOrderByCpAutorAsc();
			model.addAttribute("autores", autores11);
			break;
		case 12:
			List<Autor> autores12 = repAutores.findAllByOrderByCpAutorDesc();
			model.addAttribute("autores", autores12);
			break;
		case 13:
			List<Autor> autores13 = repAutores.findAllByOrderByMailAutorAsc();
			model.addAttribute("autores", autores13);
			break;
		case 14:
			List<Autor> autores14 = repAutores.findAllByOrderByMailAutorDesc();
			model.addAttribute("autores", autores14);
			break;
		case 15:
			List<Autor> autores15 = repAutores.findAllByOrderByTelefonoAutorAsc();
			model.addAttribute("autores", autores15);
			break;
		case 16:
			List<Autor> autores16 = repAutores.findAllByOrderByTelefonoAutorDesc();
			model.addAttribute("autores", autores16);
			break;
		default:
			List<Autor> autoresDefault = repAutores.findAll();
			model.addAttribute("autores", autoresDefault);
		}

		return "consultasAutores";
	}

	// MODIFICACIONES A AUTORES

	@RequestMapping(value = "/modificarAutor")
	public String modificarAutor(@RequestParam long id, Model model) {

		Autor autor = repAutores.findByIdAutor(id);
		autorEditando = autor;

		model.addAttribute("autor", autor);

		return "modificarAutor";
	}

	@RequestMapping(value = "/edicionAutores")
	public String resultadoEdicionAutor(@RequestParam String nifAutor, @RequestParam String mailAutor,
			@RequestParam int telefonoAutor, Autor a) {

		if (!autorEditando.getNombreAutor().equals(a.getNombreAutor()))
			autorEditando.setNombreAutor(a.getNombreAutor());

		if (!autorEditando.getApellidosAutor().equals(a.getApellidosAutor()))
			autorEditando.setApellidosAutor(a.getApellidosAutor());

		if ((!autorEditando.getNifAutor().equals(a.getNifAutor())) && (repAutores.findByNifAutor(nifAutor) == null))
			autorEditando.setNifAutor(a.getNifAutor());

		if (autorEditando.getAnoNacimientoAutor() != a.getAnoNacimientoAutor())
			autorEditando.setAnoNacimientoAutor(a.getAnoNacimientoAutor());

		if (!autorEditando.getPaisNacimientoAutor().equals(a.getPaisNacimientoAutor()))
			autorEditando.setPaisNacimientoAutor(a.getPaisNacimientoAutor());

		if (autorEditando.getCpAutor() != a.getCpAutor())
			autorEditando.setCpAutor(a.getCpAutor());

		if (!autorEditando.getMailAutor().equals(a.getMailAutor()) && (repAutores.findByMailAutor(mailAutor) == null))
			autorEditando.setMailAutor(a.getMailAutor());

		if (autorEditando.getTelefonoAutor() != a.getTelefonoAutor()
				&& (repAutores.findByTelefonoAutor(telefonoAutor) == null))
			autorEditando.setTelefonoAutor(a.getTelefonoAutor());

		repAutores.save(autorEditando);
		return "exito_edicion";
	}

}
