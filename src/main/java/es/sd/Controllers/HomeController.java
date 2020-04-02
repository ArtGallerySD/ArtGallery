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

	// CONSTRUCCIÓN DE LA BASE DE DATOS CON OBJETOS DE ENTIDADES DE EJEMPLO

	@PostConstruct
	public void construirBD() {

		// AUTORES

		Autor autor1 = new Autor("José", "Pérez", "22222222J", 1972, "Ecuador", 28221, "joseperez@art.com", 622131522);
		repAutores.save(autor1);

		Autor autor2 = new Autor("Antonio", "Fonseca", "94165470C", 1432, "Ecuador", 28300, "antoniofonseca@art.com",
				690511795);
		repAutores.save(autor2);

		Autor autor3 = new Autor("Marta", "Reinoso", "56749823V", 1998, "España", 28047, "martareinoso@art.com",
				635489821);
		repAutores.save(autor3);

		Autor autor4 = new Autor("Miguel", "Donallo", "53899823M", 1998, "España", 28915, "migueldonallo@art.com",
				667349823);
		repAutores.save(autor4);

		Autor autor5 = new Autor("Holger", "Billhardt", "63859763H", 1960, "Alemania", 28016, "holgerbillhardt@art.com",
				667935873);
		repAutores.save(autor5);

		Autor autor6 = new Autor("Marta", "Ribote", "78666876M", 1998, "España", 28325, "martaribote@art.com",
				677863159);
		repAutores.save(autor6);

		Autor autor7 = new Autor("Robert", "Nolan", "05665892O", 1932, "Irlanda", 28512, "robertnolan@art.com",
				673493198);
		repAutores.save(autor7);

		Autor autor8 = new Autor("Teresa", "Iglesias", "98863602B", 1965, "España", 28960, "teresaiglesias@art.com",
				690511795);
		repAutores.save(autor8);

		Autor autor9 = new Autor("Pablo", "Villoria", "78554123Q", 1984, "Alemania", 44363, "pablovilloria@art.com",
				690511795);
		repAutores.save(autor9);

		Autor autor10 = new Autor("Steve", "Magic", "44852136Y", 1968, "Reino Unido", 33212, "stevemagic@art.com",
				673493198);
		repAutores.save(autor10);

		// CLIENTES

		Cliente cliente1 = new Cliente("Fernando", "López", "11111111H", 21345, "fernandolopez@gmail.com", 687451227);
		repClientes.save(cliente1);

		Cliente cliente2 = new Cliente("Rebeca", "Mena", "45197813F", 28225, "rebecamena@gmail.com", 685763703);
		repClientes.save(cliente2);

		Cliente cliente3 = new Cliente("Alba", "Sánchez", "67931583K", 28915, "albasanchez@gmail.com", 686893774);
		repClientes.save(cliente3);

		Cliente cliente4 = new Cliente("Julio", "Sanderrubias", "50125362L", 19842, "juliosande@gmail.com", 632789652);
		repClientes.save(cliente4);

		// CUADROS

		Cuadro cuadro1 = new Cuadro("Visita de la noche", "Bastante desgastado", 2017, 30.52, 26.88, 3000);
		cuadro1.setAutor(autor1);
		repCuadros.save(cuadro1);

		Cuadro cuadro2 = new Cuadro("La Primavera", "Recien restaurado", 1481, 203, 314, 55000);
		cuadro2.setAutor(autor2);
		repCuadros.save(cuadro2);

		Cuadro cuadro3 = new Cuadro("La Caída del Capital", "En perfecto estado", 2018, 100, 250, 7000);
		cuadro3.setAutor(autor3);
		repCuadros.save(cuadro3);

		Cuadro cuadro4 = new Cuadro("Elena", "Algo desgastado", 2017, 31.4, 41.3, 8000);
		cuadro4.setAutor(autor4);
		repCuadros.save(cuadro4);

		Cuadro cuadro5 = new Cuadro("Los Quien", "En perfecto estado", 2018, 31.4, 41.3, 6000);
		cuadro5.setAutor(autor4);
		repCuadros.save(cuadro5);

		Cuadro cuadro6 = new Cuadro("Desconocido", "En proceso de restauracion", 1996, 210, 60.5, 5200);
		cuadro6.setAutor(autor5);
		repCuadros.save(cuadro6);

		Cuadro cuadro7 = new Cuadro("Vida en Marte", "Recien restaurado", 2016, 50.6, 150, 1200);
		cuadro7.setAutor(autor5);
		repCuadros.save(cuadro7);

		Cuadro cuadro8 = new Cuadro("Autorretrato", "En perfecto estado", 1978, 35.6, 150, 3400);
		cuadro8.setAutor(autor7);
		repCuadros.save(cuadro8);

		Cuadro cuadro9 = new Cuadro("Realidad Aumentada", "Bordes desgastados", 2002, 14.26, 45.88, 17000);
		cuadro9.setAutor(autor9);
		repCuadros.save(cuadro9);

		Cuadro cuadro10 = new Cuadro("Poema de primavera", "Marco roto", 1992, 13.17, 6, 8500);
		cuadro10.setAutor(autor10);
		repCuadros.save(cuadro10);

		// AÑADIR CUADROS A SUS AUTORES

		autor1.getCuadrosCreados().add(cuadro1);
		repAutores.save(autor1);

		autor2.getCuadrosCreados().add(cuadro2);
		repAutores.save(autor2);

		autor3.getCuadrosCreados().add(cuadro3);
		repAutores.save(autor3);

		autor4.getCuadrosCreados().add(cuadro4);
		autor4.getCuadrosCreados().add(cuadro5);
		repAutores.save(autor4);

		autor5.getCuadrosCreados().add(cuadro6);
		autor5.getCuadrosCreados().add(cuadro7);
		repAutores.save(autor5);

		autor7.getCuadrosCreados().add(cuadro8);
		repAutores.save(autor7);

		autor9.getCuadrosCreados().add(cuadro9);
		repAutores.save(autor9);

		autor10.getCuadrosCreados().add(cuadro10);
		repAutores.save(autor10);

		// COMPRAS

		Date fecha1 = Date.valueOf(LocalDate.of(2020, 01, 12));
		cuadro1.setFechaVenta(fecha1);
		cuadro1.setComprador(cliente1);
		cliente1.getCuadrosComprados().add(cuadro1);
		repCuadros.save(cuadro1);
		repClientes.save(cliente1);

		cuadro2.setFechaVenta(fecha1);
		cuadro2.setComprador(cliente2);
		cliente2.getCuadrosComprados().add(cuadro2);
		repCuadros.save(cuadro2);
		repClientes.save(cliente2);

		Date fecha2 = Date.valueOf(LocalDate.of(2018, 03, 20));
		cuadro4.setFechaVenta(fecha2);
		cuadro4.setComprador(cliente3);
		cliente3.getCuadrosComprados().add(cuadro4);
		repCuadros.save(cuadro4);
		repClientes.save(cliente3);

		Date fecha3 = Date.valueOf(LocalDate.of(2019, 05, 11));
		cuadro5.setFechaVenta(fecha3);
		cuadro5.setComprador(cliente4);
		cliente4.getCuadrosComprados().add(cuadro5);
		repCuadros.save(cuadro5);
		repClientes.save(cliente4);

	}

	// MAPEO DEL INICIO DE LA APLICACIÓN

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}

}
