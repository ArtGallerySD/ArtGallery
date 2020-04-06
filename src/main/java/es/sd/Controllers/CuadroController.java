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

	@RequestMapping(value = "/filtrarCuadros")
	public String filtrarCuadros(@RequestParam(required = false) String tituloCuadro,
			@RequestParam(required = false, defaultValue = "-1") int precioCuadro,
			@RequestParam(required = false, defaultValue = "-1") int anoFinCuadro,
			@RequestParam(required = false) String nifAutor,
			@RequestParam(required = false, defaultValue = "-1") double anchoCuadro,
			@RequestParam(required = false) String nifComprador,
			@RequestParam(required = false, defaultValue = "-1") double altoCuadro,
			@RequestParam(required = false) String fechaVenta, Model model) {

		if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cuadro cuadroTitulo = repCuadros.findByTituloCuadro(tituloCuadro);
			model.addAttribute("cuadros", cuadroTitulo);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosPrecio = repCuadros.findByPrecioCuadro(precioCuadro);
			model.addAttribute("cuadros", cuadrosPrecio);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAno = repCuadros.findByAnoFinCuadro(anoFinCuadro);
			model.addAttribute("cuadros", cuadrosAno);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosAutor = repCuadros.findByAutor(autor);
			model.addAttribute("cuadros", cuadrosAutor);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAncho = repCuadros.findByAnchoCuadro(anchoCuadro);
			model.addAttribute("cuadros", cuadrosAncho);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cliente cliente = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosComprador = repCuadros.findByComprador(cliente);
			model.addAttribute("cuadros", cuadrosComprador);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAlto = repCuadros.findByAltoCuadro(altoCuadro);
			model.addAttribute("cuadros", cuadrosAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			List<Cuadro> cuadrosFecha = repCuadros.findByFechaVenta(fecha);
			model.addAttribute("cuadros", cuadrosFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cuadro cuadroTituloPrecio = repCuadros.findByTituloCuadroAndPrecioCuadro(tituloCuadro, precioCuadro);
			model.addAttribute("cuadros", cuadroTituloPrecio);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cuadro cuadroTituloAno = repCuadros.findByTituloCuadroAndAnoFinCuadro(tituloCuadro, anoFinCuadro);
			model.addAttribute("cuadros", cuadroTituloAno);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1)
				&& (!nifAutor.equals("none")) && (anchoCuadro == -1) && (nifComprador.equals("none"))
				&& (altoCuadro == -1) && (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			Cuadro cuadroTituloAutor = repCuadros.findByTituloCuadroAndAutor(tituloCuadro, autor);
			model.addAttribute("cuadros", cuadroTituloAutor);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cuadro cuadroTituloAncho = repCuadros.findByTituloCuadroAndAnchoCuadro(tituloCuadro, anchoCuadro);
			model.addAttribute("cuadros", cuadroTituloAncho);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cliente cliente = repClientes.findByNifCliente(nifComprador);
			Cuadro cuadroTituloCliente = repCuadros.findByTituloCuadroAndComprador(tituloCuadro, cliente);
			model.addAttribute("cuadros", cuadroTituloCliente);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			Cuadro cuadroTituloAlto = repCuadros.findByTituloCuadroAndAltoCuadro(tituloCuadro, altoCuadro);
			model.addAttribute("cuadros", cuadroTituloAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			Cuadro cuadroTituloFecha = repCuadros.findByTituloCuadroAndFechaVenta(tituloCuadro, fecha);
			model.addAttribute("cuadros", cuadroTituloFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosPrecioAno = repCuadros.findByPrecioCuadroAndAnoFinCuadro(precioCuadro, anoFinCuadro);
			model.addAttribute("cuadros", cuadrosPrecioAno);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosPrecioAutor = repCuadros.findByPrecioCuadroAndAutor(precioCuadro, autor);
			model.addAttribute("cuadros", cuadrosPrecioAutor);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosPrecioAncho = repCuadros.findByPrecioCuadroAndAnchoCuadro(precioCuadro, anchoCuadro);
			model.addAttribute("cuadros", cuadrosPrecioAncho);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosPrecioComprador = repCuadros.findByPrecioCuadroAndComprador(precioCuadro, comprador);
			model.addAttribute("cuadros", cuadrosPrecioComprador);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosPrecioAlto = repCuadros.findByPrecioCuadroAndAltoCuadro(precioCuadro, altoCuadro);
			model.addAttribute("cuadros", cuadrosPrecioAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			List<Cuadro> cuadrosPrecioFecha = repCuadros.findByPrecioCuadroAndFechaVenta(precioCuadro, fecha);
			model.addAttribute("cuadros", cuadrosPrecioFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosAnoAutor = repCuadros.findByAnoFinCuadroAndAutor(anoFinCuadro, autor);
			model.addAttribute("cuadros", cuadrosAnoAutor);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAnoAncho = repCuadros.findByAnoFinCuadroAndAnchoCuadro(anoFinCuadro, anchoCuadro);
			model.addAttribute("cuadros", cuadrosAnoAncho);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosAnoComprador = repCuadros.findByAnoFinCuadroAndComprador(anoFinCuadro, comprador);
			model.addAttribute("cuadros", cuadrosAnoComprador);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAnoAlto = repCuadros.findByAnoFinCuadroAndAltoCuadro(anoFinCuadro, altoCuadro);
			model.addAttribute("cuadros", cuadrosAnoAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro != -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			List<Cuadro> cuadrosAnoFecha = repCuadros.findByAnoFinCuadroAndFechaVenta(anoFinCuadro, fecha);
			model.addAttribute("cuadros", cuadrosAnoFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosAutorAncho = repCuadros.findByAutorAndAnchoCuadro(autor, anchoCuadro);
			model.addAttribute("cuadros", cuadrosAutorAncho);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosAutorComprador = repCuadros.findByAutorAndComprador(autor, comprador);
			model.addAttribute("cuadros", cuadrosAutorComprador);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosAutorAlto = repCuadros.findByAutorAndAltoCuadro(autor, altoCuadro);
			model.addAttribute("cuadros", cuadrosAutorAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (!nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			Autor autor = repAutores.findByNifAutor(nifAutor);
			List<Cuadro> cuadrosAutorFecha = repCuadros.findByAutorAndFechaVenta(autor, fecha);
			model.addAttribute("cuadros", cuadrosAutorFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (fechaVenta.equals(""))) {
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosAnchoComprador = repCuadros.findByAnchoCuadroAndComprador(anchoCuadro, comprador);
			model.addAttribute("cuadros", cuadrosAnchoComprador);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			List<Cuadro> cuadrosAnchoAlto = repCuadros.findByAnchoCuadroAndAltoCuadro(anchoCuadro, altoCuadro);
			model.addAttribute("cuadros", cuadrosAnchoAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro != -1) && (nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			List<Cuadro> cuadrosAnchoFecha = repCuadros.findByAnchoCuadroAndFechaVenta(anchoCuadro, fecha);
			model.addAttribute("cuadros", cuadrosAnchoFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro != -1)
				&& (fechaVenta.equals(""))) {
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosCompradorAlto = repCuadros.findByCompradorAndAltoCuadro(comprador, altoCuadro);
			model.addAttribute("cuadros", cuadrosCompradorAlto);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (!nifComprador.equals("none")) && (altoCuadro == -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			List<Cuadro> cuadrosCompradorFecha = repCuadros.findByCompradorAndFechaVenta(comprador, fecha);
			model.addAttribute("cuadros", cuadrosCompradorFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((tituloCuadro.equals("")) && (precioCuadro == -1) && (anoFinCuadro == -1) && (nifAutor.equals("none"))
				&& (anchoCuadro == -1) && (nifComprador.equals("none")) && (altoCuadro != -1)
				&& (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			List<Cuadro> cuadrosAltoFecha = repCuadros.findByAltoCuadroAndFechaVenta(altoCuadro, fecha);
			model.addAttribute("cuadros", cuadrosAltoFecha);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else if ((!tituloCuadro.equals("")) && (precioCuadro != -1) && (anoFinCuadro != -1)
				&& (!nifAutor.equals("none")) && (anchoCuadro != -1) && (!nifComprador.equals("none"))
				&& (altoCuadro != -1) && (!fechaVenta.equals(""))) {
			Date fecha = Date.valueOf(fechaVenta);
			Cliente comprador = repClientes.findByNifCliente(nifComprador);
			Autor autor = repAutores.findByNifAutor(nifAutor);
			Cuadro cuadroTodo = repCuadros
					.findByTituloCuadroAndPrecioCuadroAndAnoFinCuadroAndAutorAndAnchoCuadroAndCompradorAndAltoCuadroAndFechaVenta(
							tituloCuadro, precioCuadro, anoFinCuadro, autor, anchoCuadro, comprador, altoCuadro, fecha);
			model.addAttribute("cuadros", cuadroTodo);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		else {
			List<Cuadro> cuadros = repCuadros.findAll();
			model.addAttribute("cuadros", cuadros);

			List<Autor> autores = repAutores.findAll();
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("autores", autores);
			model.addAttribute("clientes", clientes);
		}

		return "consultasCuadros";
	}

	@RequestMapping(value = "/ordenarCuadros")
	public String ordenarCuadros(@RequestParam int ordenCuadro, Model model) {

		switch (ordenCuadro) {
		case 0:
			List<Cuadro> cuadro0 = repCuadros.findAll();
			model.addAttribute("cuadros", cuadro0);

			List<Autor> autores0 = repAutores.findAll();
			List<Cliente> clientes0 = repClientes.findAll();
			model.addAttribute("autores", autores0);
			model.addAttribute("clientes", clientes0);
			break;
		case 1:
			List<Cuadro> cuadros1 = repCuadros.findAllByOrderByTituloCuadroAsc();
			model.addAttribute("cuadros", cuadros1);

			List<Autor> autores1 = repAutores.findAll();
			List<Cliente> clientes1 = repClientes.findAll();
			model.addAttribute("autores", autores1);
			model.addAttribute("clientes", clientes1);
			break;
		case 2:
			List<Cuadro> cuadros2 = repCuadros.findAllByOrderByTituloCuadroDesc();
			model.addAttribute("cuadros", cuadros2);

			List<Autor> autores2 = repAutores.findAll();
			List<Cliente> clientes2 = repClientes.findAll();
			model.addAttribute("autores", autores2);
			model.addAttribute("clientes", clientes2);
			break;
		case 3:
			List<Cuadro> cuadros3 = repCuadros.findAllByOrderByDescripcionCuadroAsc();
			model.addAttribute("cuadros", cuadros3);

			List<Autor> autores3 = repAutores.findAll();
			List<Cliente> clientes3 = repClientes.findAll();
			model.addAttribute("autores", autores3);
			model.addAttribute("clientes", clientes3);
			break;
		case 4:
			List<Cuadro> cuadros4 = repCuadros.findAllByOrderByDescripcionCuadroDesc();
			model.addAttribute("cuadros", cuadros4);

			List<Autor> autores4 = repAutores.findAll();
			List<Cliente> clientes4 = repClientes.findAll();
			model.addAttribute("autores", autores4);
			model.addAttribute("clientes", clientes4);
			break;
		case 5:
			List<Cuadro> cuadros5 = repCuadros.findAllByOrderByAnoFinCuadroAsc();
			model.addAttribute("cuadros", cuadros5);

			List<Autor> autores5 = repAutores.findAll();
			List<Cliente> clientes5 = repClientes.findAll();
			model.addAttribute("autores", autores5);
			model.addAttribute("clientes", clientes5);
			break;
		case 6:
			List<Cuadro> cuadros6 = repCuadros.findAllByOrderByAnoFinCuadroDesc();
			model.addAttribute("cuadros", cuadros6);

			List<Autor> autores6 = repAutores.findAll();
			List<Cliente> clientes6 = repClientes.findAll();
			model.addAttribute("autores", autores6);
			model.addAttribute("clientes", clientes6);
			break;
		case 7:
			List<Cuadro> cuadros7 = repCuadros.findAllByOrderByAnchoCuadroAsc();
			model.addAttribute("cuadros", cuadros7);

			List<Autor> autores7 = repAutores.findAll();
			List<Cliente> clientes7 = repClientes.findAll();
			model.addAttribute("autores", autores7);
			model.addAttribute("clientes", clientes7);
			break;
		case 8:
			List<Cuadro> cuadros8 = repCuadros.findAllByOrderByAnchoCuadroDesc();
			model.addAttribute("cuadros", cuadros8);

			List<Autor> autores8 = repAutores.findAll();
			List<Cliente> clientes8 = repClientes.findAll();
			model.addAttribute("autores", autores8);
			model.addAttribute("clientes", clientes8);
			break;
		case 9:
			List<Cuadro> cuadros9 = repCuadros.findAllByOrderByAltoCuadroAsc();
			model.addAttribute("cuadros", cuadros9);

			List<Autor> autores9 = repAutores.findAll();
			List<Cliente> clientes9 = repClientes.findAll();
			model.addAttribute("autores", autores9);
			model.addAttribute("clientes", clientes9);
			break;
		case 10:
			List<Cuadro> cuadros10 = repCuadros.findAllByOrderByAltoCuadroDesc();
			model.addAttribute("cuadros", cuadros10);

			List<Autor> autores10 = repAutores.findAll();
			List<Cliente> clientes10 = repClientes.findAll();
			model.addAttribute("autores", autores10);
			model.addAttribute("clientes", clientes10);
			break;
		case 11:
			List<Cuadro> cuadros11 = repCuadros.findAllByOrderByPrecioCuadroAsc();
			model.addAttribute("cuadros", cuadros11);

			List<Autor> autores11 = repAutores.findAll();
			List<Cliente> clientes11 = repClientes.findAll();
			model.addAttribute("autores", autores11);
			model.addAttribute("clientes", clientes11);
			break;
		case 12:
			List<Cuadro> cuadros12 = repCuadros.findAllByOrderByPrecioCuadroDesc();
			model.addAttribute("cuadros", cuadros12);

			List<Autor> autores12 = repAutores.findAll();
			List<Cliente> clientes12 = repClientes.findAll();
			model.addAttribute("autores", autores12);
			model.addAttribute("clientes", clientes12);
			break;
		case 13:
			List<Cuadro> cuadros13 = repCuadros.findAllByOrderByFechaVentaAsc();
			model.addAttribute("cuadros", cuadros13);

			List<Autor> autores13 = repAutores.findAll();
			List<Cliente> clientes13 = repClientes.findAll();
			model.addAttribute("autores", autores13);
			model.addAttribute("clientes", clientes13);
			break;
		case 14:
			List<Cuadro> cuadros14 = repCuadros.findAllByOrderByFechaVentaDesc();
			model.addAttribute("cuadros", cuadros14);

			List<Autor> autores14 = repAutores.findAll();
			List<Cliente> clientes14 = repClientes.findAll();
			model.addAttribute("autores", autores14);
			model.addAttribute("clientes", clientes14);
			break;
		case 15:
			List<Cuadro> cuadros15 = repCuadros.findAllByOrderByAutorAsc();
			model.addAttribute("cuadros", cuadros15);

			List<Autor> autores15 = repAutores.findAll();
			List<Cliente> clientes15 = repClientes.findAll();
			model.addAttribute("autores", autores15);
			model.addAttribute("clientes", clientes15);
			break;
		case 16:
			List<Cuadro> cuadros16 = repCuadros.findAllByOrderByAutorDesc();
			model.addAttribute("cuadros", cuadros16);

			List<Autor> autores16 = repAutores.findAll();
			List<Cliente> clientes16 = repClientes.findAll();
			model.addAttribute("autores", autores16);
			model.addAttribute("clientes", clientes16);
			break;
		case 17:
			List<Cuadro> cuadros17 = repCuadros.findAllByOrderByCompradorAsc();
			model.addAttribute("cuadros", cuadros17);

			List<Autor> autores17 = repAutores.findAll();
			List<Cliente> clientes17 = repClientes.findAll();
			model.addAttribute("autores", autores17);
			model.addAttribute("clientes", clientes17);
			break;
		case 18:
			List<Cuadro> cuadros18 = repCuadros.findAllByOrderByCompradorDesc();
			model.addAttribute("cuadros", cuadros18);

			List<Autor> autores18 = repAutores.findAll();
			List<Cliente> clientes18 = repClientes.findAll();
			model.addAttribute("autores", autores18);
			model.addAttribute("clientes", clientes18);
			break;
		default:
			List<Cuadro> cuadrosDefault = repCuadros.findAll();
			model.addAttribute("cuadros", cuadrosDefault);

			List<Autor> autoresDefault = repAutores.findAll();
			List<Cliente> clientesDefault = repClientes.findAll();
			model.addAttribute("autores", autoresDefault);
			model.addAttribute("clientes", clientesDefault);
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
