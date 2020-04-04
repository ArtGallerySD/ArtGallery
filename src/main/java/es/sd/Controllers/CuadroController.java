package es.sd.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

	// MAPEO DE CUADROS

	@RequestMapping(value = "/cuadros")
	public String cuadros(Model model) {

		List<Autor> autores = repAutores.findAll();

		model.addAttribute("autores", autores);

		return "cuadros";
	}

	// REGISTRO DE CUADROS

	@RequestMapping(value = "/registroCuadros")
	public String registrarCuadro(@RequestParam String tituloCuadro, @RequestParam String nifAutor, Cuadro cuadro) {

		if (repCuadros.findByTituloCuadro(tituloCuadro) == null) {
			Autor a = repAutores.findByNifAutor(nifAutor);
			cuadro.setAutor(a);

			repCuadros.save(cuadro);

			a.getCuadrosCreados().add(cuadro);
			repAutores.save(a);

			return "exito_registro";
		} else
			return "fallo_registro_cuadro";

	}

	// CONSULTAS, FILTROS Y ORDENACIÓN DE CUADROS

	@RequestMapping(value = "/consultasCuadros")
	public String mostrarCuadros(Model model) {

		List<Cuadro> cuadros = repCuadros.findAll();
		List<Autor> autores = repAutores.findAll();
		List<Cliente> clientes = repClientes.findAll();

		model.addAttribute("cuadros", cuadros);
		model.addAttribute("autores", autores);
		model.addAttribute("clientes", clientes);

		return "consultasCuadros";
	}

	@RequestMapping(value = "/ordenarCuadros")
	public String ordenarCuadros(@RequestParam int ordenCuadro, Model model) {

		switch (ordenCuadro) {
		case 0:
			List<Cuadro> cuadro0 = repCuadros.findAll();
			model.addAttribute("cuadros", cuadro0);
			break;
		case 1:
			List<Cuadro> cuadros1 = repCuadros.findAllByOrderByTituloCuadroAsc();
			model.addAttribute("cuadros", cuadros1);
			break;
		case 2:
			List<Cuadro> cuadros2 = repCuadros.findAllByOrderByTituloCuadroDesc();
			model.addAttribute("cuadros", cuadros2);
			break;
		case 3:
			List<Cuadro> cuadros3 = repCuadros.findAllByOrderByDescripcionCuadroAsc();
			model.addAttribute("cuadros", cuadros3);
			break;
		case 4:
			List<Cuadro> cuadros4 = repCuadros.findAllByOrderByDescripcionCuadroDesc();
			model.addAttribute("cuadros", cuadros4);
			break;
		case 5:
			List<Cuadro> cuadros5 = repCuadros.findAllByOrderByAnoFinCuadroAsc();
			model.addAttribute("cuadros", cuadros5);
			break;
		case 6:
			List<Cuadro> cuadros6 = repCuadros.findAllByOrderByAnoFinCuadroDesc();
			model.addAttribute("cuadros", cuadros6);
			break;
		case 7:
			List<Cuadro> cuadros7 = repCuadros.findAllByOrderByAnchoCuadroAsc();
			model.addAttribute("cuadros", cuadros7);
			break;
		case 8:
			List<Cuadro> cuadros8 = repCuadros.findAllByOrderByAnchoCuadroDesc();
			model.addAttribute("cuadros", cuadros8);
			break;
		case 9:
			List<Cuadro> cuadros9 = repCuadros.findAllByOrderByAltoCuadroAsc();
			model.addAttribute("cuadros", cuadros9);
			break;
		case 10:
			List<Cuadro> cuadros10 = repCuadros.findAllByOrderByAltoCuadroDesc();
			model.addAttribute("cuadros", cuadros10);
			break;
		case 11:
			List<Cuadro> cuadros11 = repCuadros.findAllByOrderByPrecioCuadroAsc();
			model.addAttribute("cuadros", cuadros11);
			break;
		case 12:
			List<Cuadro> cuadros12 = repCuadros.findAllByOrderByPrecioCuadroDesc();
			model.addAttribute("cuadros", cuadros12);
			break;
		case 13:
			List<Cuadro> cuadros13 = repCuadros.findAllByOrderByFechaVentaAsc();
			model.addAttribute("cuadros", cuadros13);
			break;
		case 14:
			List<Cuadro> cuadros14 = repCuadros.findAllByOrderByFechaVentaDesc();
			model.addAttribute("cuadros", cuadros14);
			break;
		case 15:
			List<Cuadro> cuadros15 = repCuadros.findAllByOrderByAutorAsc();
			model.addAttribute("cuadros", cuadros15);
			break;
		case 16:
			List<Cuadro> cuadros16 = repCuadros.findAllByOrderByAutorDesc();
			model.addAttribute("cuadros", cuadros16);
			break;
		case 17:
			List<Cuadro> cuadros17 = repCuadros.findAllByOrderByCompradorAsc();
			model.addAttribute("cuadros", cuadros17);
			break;
		case 18:
			List<Cuadro> cuadros18 = repCuadros.findAllByOrderByCompradorDesc();
			model.addAttribute("cuadros", cuadros18);
			break;
		default:
			List<Cuadro> cuadrosDefault = repCuadros.findAll();
			model.addAttribute("cuadros", cuadrosDefault);
		}

		return "consultasCuadros";
	}

	// MODIFICACIONES Y COMPRAS DE CUADROS

	@RequestMapping(value = "/modificarCuadro")
	public String modificarCuadro(@RequestParam long id, Model model) {

		Cuadro cuadro = repCuadros.findByIdCuadro(id);
		cuadroEditando = cuadro;
		List<Autor> autores = repAutores.findAll();
		List<Cliente> clientes = repClientes.findAll();

		model.addAttribute("cuadro", cuadro);
		model.addAttribute("autores", autores);
		model.addAttribute("clientes", clientes);

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
	public String resultadoEdicionCuadro(@RequestParam String tituloCuadro, @RequestParam String nifAutor,
			@RequestParam Optional<String> nifComprador, @RequestParam Optional<java.sql.Date> fechaVenta, Cuadro c) {

		if ((!cuadroEditando.getTituloCuadro().equals(c.getTituloCuadro()))
				&& (repCuadros.findByTituloCuadro(tituloCuadro) == null))
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

		if (!cuadroEditando.getAutor().getNifAutor().equals(nifAutor)) {

			Autor autorAntiguo = repAutores.findByNifAutor(cuadroEditando.getAutor().getNifAutor());
			autorAntiguo.getCuadrosCreados().remove(cuadroEditando);
			repAutores.save(autorAntiguo);

			Autor autorActual = repAutores.findByNifAutor(nifAutor);
			cuadroEditando.setAutor(autorActual);
			repCuadros.save(cuadroEditando);

			autorActual.getCuadrosCreados().add(cuadroEditando);
			repAutores.save(autorActual);

		} else
			repCuadros.save(cuadroEditando);

		if (nifComprador.isPresent() || fechaVenta.isPresent()) {
			if ((!cuadroEditando.getComprador().getNifCliente().equals(nifComprador.get()))
					|| (cuadroEditando.getFechaVenta().compareTo(fechaVenta.get()) != 0)) {

				Cliente compradorAntiguo = repClientes.findByNifCliente(cuadroEditando.getComprador().getNifCliente());
				compradorAntiguo.getCuadrosComprados().remove(cuadroEditando);
				repClientes.save(compradorAntiguo);

				Cliente compradorActual = repClientes.findByNifCliente(nifComprador.get());
				cuadroEditando.setComprador(compradorActual);
				cuadroEditando.setFechaVenta(fechaVenta.get());
				compradorActual.getCuadrosComprados().add(cuadroEditando);
				repCuadros.save(cuadroEditando);
				repClientes.save(compradorActual);

			}
		}

		return "exito_edicion";
	}

}
