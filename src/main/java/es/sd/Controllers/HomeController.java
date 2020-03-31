package es.sd.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import es.sd.Entities.Autor;
import es.sd.Entities.Cliente;
import es.sd.Entities.Cuadro;
import es.sd.Repositories.AutorRepository;
import es.sd.Repositories.ClienteRepository;
import es.sd.Repositories.CuadroRepository;

@Controller
public class HomeController {

	@Autowired
	private CuadroRepository repCuadros;

	@Autowired
	private AutorRepository repAutores;

	@Autowired
	private ClienteRepository repClientes;

	@PostConstruct
	public void construirBD() {

		Autor autor1 = new Autor("José", "Pérez", "22222222J", 1972, "Ecuador", 28221, "joseperez@art.com", 622131522);
		repAutores.save(autor1);

		Cliente cliente1 = new Cliente("Fernando", "López", "11111111H", 21345, "fernandolopez@gmail.com", 687451227);
		repClientes.save(cliente1);

		Cuadro cuadro1 = new Cuadro("Visita de la noche", "Bastante desgastado", 2017, 30.52, 26.88, 3000);
		cuadro1.setAutor(autor1);
		repCuadros.save(cuadro1);

		autor1.getCuadrosCreados().add(cuadro1);
		repAutores.save(autor1);

		LocalDate local = LocalDate.of(2020, 01, 12);
		Date fecha = Date.valueOf(local);
		cuadro1.setFechaVenta(fecha);
		cuadro1.setComprador(cliente1);
		cliente1.getCuadrosComprados().add(cuadro1);
		repCuadros.save(cuadro1);
		repClientes.save(cliente1);

	}

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}

}
