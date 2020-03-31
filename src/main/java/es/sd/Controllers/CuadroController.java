package es.sd.Controllers;

import java.sql.Date;
import java.time.LocalDate;
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
	private CuadroRepository repCuadros;

	@Autowired
	private AutorRepository repAutores;

	@Autowired
	private ClienteRepository repClientes;

	private Cuadro cuadroEditando;
	private Cuadro cuadroComprando;

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
		cuadroEditando = cuadro;
		List<Autor> autores = repAutores.findAll();

		model.addAttribute("cuadro", cuadro);
		model.addAttribute("autores", autores);

		return "modificarCuadro";
	}

	@RequestMapping(value = "/comprarCuadro")
	public String comprarCuadro(@RequestParam long idCompra, Model model) {

		Cuadro cuadro = repCuadros.findByIdCuadro(idCompra);

		cuadroComprando = cuadro;

		return "comprarCuadro";
	}

	@RequestMapping(value = "/confirmacionCompra")
	public String confirmacionCompra(@RequestParam String nifComprador, Model model) {

		Cliente cliente = repClientes.findByNifCliente(nifComprador);

		if (cliente != null) {
			LocalDate fechaActual = LocalDate.now();
			Date fecha = Date.valueOf(fechaActual);
			cuadroComprando.setFechaVenta(fecha);
			cuadroComprando.setComprador(cliente);
			cliente.getCuadrosComprados().add(cuadroComprando);

			repCuadros.save(cuadroComprando);
			repClientes.save(cliente);

			return "confirmacion_compra";
		} else
			return "fallo_compra";

	}

	@RequestMapping(value = "/edicionCuadros")
	public String resultadoEdicionCuadro(@RequestParam String nombreAutor, Cuadro c) {

		if (!cuadroEditando.getTituloCuadro().equals(c.getTituloCuadro()))
			cuadroEditando.setTituloCuadro(c.getTituloCuadro());

		if (!cuadroEditando.getDescripcionCuadro().equals(c.getDescripcionCuadro()))
			cuadroEditando.setDescripcionCuadro(c.getDescripcionCuadro());

		if (cuadroEditando.getAnoFinCuadro() != c.getAnoFinCuadro())
			cuadroEditando.setAnoFinCuadro(c.getAnoFinCuadro());

		if (cuadroEditando.getAnchoCuadro() != c.getAnchoCuadro())
			cuadroEditando.setAnchoCuadro(c.getAnchoCuadro());

		if (cuadroEditando.getAltoCuadro() != c.getAltoCuadro())
			cuadroEditando.setAltoCuadro(c.getAltoCuadro());

		if (cuadroEditando.getPrecioCuadro() != c.getPrecioCuadro())
			cuadroEditando.setPrecioCuadro(c.getPrecioCuadro());

		if (!cuadroEditando.getAutor().getNombreAutor().equals(nombreAutor)) {
			Autor a = repAutores.findByNombreAutor(nombreAutor);
			cuadroEditando.setAutor(a);
			repCuadros.save(cuadroEditando);

			a.getCuadrosCreados().add(cuadroEditando);
			repAutores.save(a);
		} else
			repCuadros.save(cuadroEditando);

		return "edicion";
	}

}
