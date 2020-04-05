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

	@RequestMapping(value = "/filtrarAutores")
	public String filtrarAutores(@RequestParam(required = false) String nombreAutor,
			@RequestParam(required = false) String apellidosAutor, @RequestParam(required = false) String nifAutor,
			@RequestParam(required = false, defaultValue = "0") int anoNacimientoAutor,
			@RequestParam(required = false) String paisNacimientoAutor,
			@RequestParam(required = false, defaultValue = "0") int cpAutor,
			@RequestParam(required = false) String mailAutor,
			@RequestParam(required = false, defaultValue = "0") int telefonoAutor, Model model) {

		if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresNombre = repAutores.findByNombreAutor(nombreAutor);
			model.addAttribute("autores", autoresNombre);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresApellidos = repAutores.findByApellidosAutor(apellidosAutor);
			model.addAttribute("autores", autoresApellidos);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNIF = repAutores.findByNifAutor(nifAutor);
			model.addAttribute("autores", autorNIF);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresAno = repAutores.findByAnoNacimientoAutor(anoNacimientoAutor);
			model.addAttribute("autores", autoresAno);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresPais = repAutores.findByPaisNacimientoAutor(paisNacimientoAutor);
			model.addAttribute("autores", autoresPais);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresCp = repAutores.findByCpAutor(cpAutor);
			model.addAttribute("autores", autoresCp);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorMail = repAutores.findByMailAutor(mailAutor);
			model.addAttribute("autores", autorMail);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorTelefono = repAutores.findByTelefonoAutor(telefonoAutor);
			model.addAttribute("autores", autorTelefono);
		}

		else if ((!nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresNombreApellidos = repAutores.findByNombreAutorAndApellidosAutor(nombreAutor,
					apellidosAutor);
			model.addAttribute("autores", autoresNombreApellidos);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNombreNIF = repAutores.findByNombreAutorAndNifAutor(nombreAutor, nifAutor);
			model.addAttribute("autores", autorNombreNIF);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresNombreAno = repAutores.findByNombreAutorAndAnoNacimientoAutor(nombreAutor,
					anoNacimientoAutor);
			model.addAttribute("autores", autoresNombreAno);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresNombrePais = repAutores.findByNombreAutorAndPaisNacimientoAutor(nombreAutor,
					paisNacimientoAutor);
			model.addAttribute("autores", autoresNombrePais);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresNombreCP = repAutores.findByNombreAutorAndCpAutor(nombreAutor, cpAutor);
			model.addAttribute("autores", autoresNombreCP);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNombreMail = repAutores.findByNombreAutorAndMailAutor(nombreAutor, mailAutor);
			model.addAttribute("autores", autorNombreMail);
		}

		else if ((!nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorNombreTelefono = repAutores.findByNombreAutorAndTelefonoAutor(nombreAutor, telefonoAutor);
			model.addAttribute("autores", autorNombreTelefono);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorApellidosNIF = repAutores.findByApellidosAutorAndNifAutor(apellidosAutor, nifAutor);
			model.addAttribute("autores", autorApellidosNIF);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresApellidosAno = repAutores.findByApellidosAutorAndAnoNacimientoAutor(apellidosAutor,
					anoNacimientoAutor);
			model.addAttribute("autores", autoresApellidosAno);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresApellidosPais = repAutores.findByApellidosAutorAndPaisNacimientoAutor(apellidosAutor,
					paisNacimientoAutor);
			model.addAttribute("autores", autoresApellidosPais);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresApellidosCP = repAutores.findByApellidosAutorAndCpAutor(apellidosAutor, cpAutor);
			model.addAttribute("autores", autoresApellidosCP);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorApellidosMail = repAutores.findByApellidosAutorAndMailAutor(apellidosAutor, mailAutor);
			model.addAttribute("autores", autorApellidosMail);
		}

		else if ((nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorApellidosTelefono = repAutores.findByApellidosAutorAndTelefonoAutor(apellidosAutor,
					telefonoAutor);
			model.addAttribute("autores", autorApellidosTelefono);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNIFAno = repAutores.findByNifAutorAndAnoNacimientoAutor(nifAutor, anoNacimientoAutor);
			model.addAttribute("autores", autorNIFAno);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNIFPais = repAutores.findByNifAutorAndPaisNacimientoAutor(nifAutor, paisNacimientoAutor);
			model.addAttribute("autores", autorNIFPais);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNIFCP = repAutores.findByNifAutorAndCpAutor(nifAutor, cpAutor);
			model.addAttribute("autores", autorNIFCP);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorNIFMail = repAutores.findByNifAutorAndMailAutor(nifAutor, mailAutor);
			model.addAttribute("autores", autorNIFMail);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorNIFTelefono = repAutores.findByNifAutorAndTelefonoAutor(nifAutor, telefonoAutor);
			model.addAttribute("autores", autorNIFTelefono);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresAnoPais = repAutores.findByAnoNacimientoAutorAndPaisNacimientoAutor(anoNacimientoAutor,
					paisNacimientoAutor);
			model.addAttribute("autores", autoresAnoPais);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresAnoCP = repAutores.findByAnoNacimientoAutorAndCpAutor(anoNacimientoAutor, cpAutor);
			model.addAttribute("autores", autoresAnoCP);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorAnoMail = repAutores.findByAnoNacimientoAutorAndMailAutor(anoNacimientoAutor, mailAutor);
			model.addAttribute("autores", autorAnoMail);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorAnoTelefono = repAutores.findByAnoNacimientoAutorAndTelefonoAutor(anoNacimientoAutor,
					telefonoAutor);
			model.addAttribute("autores", autorAnoTelefono);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor == 0)) {
			List<Autor> autoresPaisCP = repAutores.findByPaisNacimientoAutorAndCpAutor(paisNacimientoAutor, cpAutor);
			model.addAttribute("autores", autoresPaisCP);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorPaisMail = repAutores.findByPaisNacimientoAutorAndMailAutor(paisNacimientoAutor, mailAutor);
			model.addAttribute("autores", autorPaisMail);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (!paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorPaisTelefono = repAutores.findByPaisNacimientoAutorAndTelefonoAutor(paisNacimientoAutor,
					telefonoAutor);
			model.addAttribute("autores", autorPaisTelefono);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (!mailAutor.equals("")) && (telefonoAutor == 0)) {
			Autor autorCPMail = repAutores.findByCpAutorAndMailAutor(cpAutor, mailAutor);
			model.addAttribute("autores", autorCPMail);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorCPTelefono = repAutores.findByCpAutorAndTelefonoAutor(cpAutor, telefonoAutor);
			model.addAttribute("autores", autorCPTelefono);
		}

		else if ((nombreAutor.equals("")) && (apellidosAutor.equals("")) && (nifAutor.equals(""))
				&& (anoNacimientoAutor == 0) && (paisNacimientoAutor.equals("")) && (cpAutor == 0)
				&& (!mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorMailTelefono = repAutores.findByMailAutorAndTelefonoAutor(mailAutor, telefonoAutor);
			model.addAttribute("autores", autorMailTelefono);
		}

		else if ((!nombreAutor.equals("")) && (!apellidosAutor.equals("")) && (!nifAutor.equals(""))
				&& (anoNacimientoAutor != 0) && (!paisNacimientoAutor.equals("")) && (cpAutor != 0)
				&& (!mailAutor.equals("")) && (telefonoAutor != 0)) {
			Autor autorTodo = repAutores
					.findByNombreAutorAndApellidosAutorAndNifAutorAndAnoNacimientoAutorAndPaisNacimientoAutorAndCpAutorAndMailAutorAndTelefonoAutor(
							nombreAutor, apellidosAutor, nifAutor, anoNacimientoAutor, paisNacimientoAutor, cpAutor,
							mailAutor, telefonoAutor);
			model.addAttribute("autores", autorTodo);
		}

		else {
			List<Autor> autores = repAutores.findAll();
			model.addAttribute("autores", autores);
		}

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
