package es.sd.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.sd.Entities.Autor;
import es.sd.Entities.Cliente;
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
	public String registrarCuadro(@RequestParam String nombreAutor, Cuadro cuadro) {

		Autor a = repAutores.findByNombreAutor(nombreAutor);
		cuadro.setAutor(a);

		repCuadros.save(cuadro);

		a.getCuadrosCreados().add(cuadro);
		repAutores.save(a);

		return "registro";
	}

	@RequestMapping(value = "/consultasCuadros")
	public String mostrarCuadros(Model model) {

		List<Cuadro> cuadros = repCuadros.findAll();

		model.addAttribute("cuadros", cuadros);

		return "consultasCuadros";
	}

	@RequestMapping(value = "/modificarCuadro")
	public String modificarCuadro(@RequestParam long id, Model model) {

		Cuadro cuadro = repCuadros.findByIdCuadro(id);
		List<Autor> autores = repAutores.findAll();
		
		model.addAttribute("cuadro", cuadro);
		model.addAttribute("autores", autores);

		return "modificarCuadro";
	}

	@RequestMapping(value = "/comprarCuadro")
	public String comprarCuadro(@RequestParam long idCompra, Model model) {

		Cuadro cuadro = repCuadros.findByIdCuadro(idCompra);

		model.addAttribute("cuadro", cuadro);

		return "comprarCuadro";
	}

	@RequestMapping(value = "/edicionCuadros")
	public String resultadoEdicionCuadro(@RequestParam String nombreAutor, Cuadro c) {

		Cuadro cuadro = repCuadros.findByIdCuadro(c.getIdCuadro());
		repCuadros.delete(cuadro);

		Autor autororiginal = repAutores.findByNifAutor(cuadro.getAutor().getNifAutor());
		autororiginal.getCuadrosCreados().remove(cuadro);

		Autor a = repAutores.findByNombreAutor(nombreAutor);
		if (!autororiginal.getNifAutor().equals(a.getNifAutor()))
			repAutores.save(autororiginal);
		else
			repAutores.delete(autororiginal);

		/*
		 * Cliente cliente =
		 * repClientes.findByNifCliente(cuadro.getComprador().getNifCliente()); if
		 * (cliente != null) {
		 * 
		 * }
		 */

		c.setAutor(a);
		repCuadros.save(c);

		a.getCuadrosCreados().add(c);
		repAutores.save(a);

		return "edicion";
	}

}
