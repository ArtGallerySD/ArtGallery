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
        Autor autor2 = new Autor("Antonio", "Fonseca", "94165470C", 1984, "Ecuador", 28300, "antoniofonseca@art.com", 690511795);
        repAutores.save(autor2);
        Autor autor3 = new Autor("Marco", "Reinoso", "56749823V", 1998, "España", 28047, "marcoreinoso@art.com", 635489821);
        repAutores.save(autor3);
        Autor autor4 = new Autor("Miguel", "Donallo", "53899823M", 1998, "España", 28915, "migueldonallo@art.com", 667349823);
        repAutores.save(autor4);
        Autor autor5 = new Autor("Holger", "Billhardt", "63859763H", 1980, "Alemania", 28016, "holgerbillhardt@art.com", 667935873);
        repAutores.save(autor5);
        Autor autor6 = new Autor("Marta", "Ribote", "78666876M", 1998, "España", 28325, "martaribote@art.com", 677863159);
        repAutores.save(autor6);
        Autor autor7 = new Autor("Robert", "Nolan", "05665892O", 1974, "Irlanda", 28512, "robertnolan@art.com", 673493198);
        repAutores.save(autor7);

        Cliente cliente1 = new Cliente("Fernando", "López", "11111111H", 21345, "fernandolopez@gmail.com", 687451227);
        repClientes.save(cliente1);
        Cliente cliente2 = new Cliente("Rebeca", "Mena", "45197813F", 28225, "rebecamena@gmail.com", 685763703);
        repClientes.save(cliente2);
        Cliente cliente3 = new Cliente("Alba", "Sánchez", "67931583K", 28915, "albasanchez@gmail.com", 686893774);
        repClientes.save(cliente3);

        Cuadro cuadro1 = new Cuadro("Visita de la noche", "Bastante desgastado", 2017, 30.52, 26.88, 3000);
        cuadro1.setAutor(autor1);
        repCuadros.save(cuadro1);
        Cuadro cuadro2 = new Cuadro("La Primavera", "Recien restaurado", 1481, 203, 314, 55000);
        cuadro2.setAutor(autor2);
        repCuadros.save(cuadro2);
        Cuadro cuadro3 = new Cuadro("La Caída del Capital", "En perfecto estado", 2018, 100, 250, 7000);
        cuadro2.setAutor(autor3);
        repCuadros.save(cuadro3);
        Cuadro cuadro4 = new Cuadro("Elena", "Algo desgastado", 2017, 31.4, 41.3, 8000);
        cuadro2.setAutor(autor4);
        repCuadros.save(cuadro4);
        Cuadro cuadro5 = new Cuadro("Los Quien", "En perfecto estado", 2018, 31.4, 41.3, 6000);
        cuadro2.setAutor(autor4);
        repCuadros.save(cuadro5);
        Cuadro cuadro6 = new Cuadro("Desconocido", "En proceso de restauracion", 1996, 210, 60.5, 5200);
        cuadro2.setAutor(autor5);
        repCuadros.save(cuadro6);
        Cuadro cuadro7 = new Cuadro("Vida en Marte", "Recien restaurado", 2016, 50.6, 150, 1200);
        cuadro2.setAutor(autor6);
        repCuadros.save(cuadro7);
        Cuadro cuadro8 = new Cuadro("Autorretrato", "En perfecto estado", 1978, 35.6, 150, 3400);
        cuadro2.setAutor(autor7);
        repCuadros.save(cuadro8);

        LocalDate local = LocalDate.of(2020, 01, 12);
        Date fecha = Date.valueOf(local);
        cuadro1.setFechaVenta(fecha);
        cuadro1.setComprador(cliente1);
        cliente1.getCuadrosComprados().add(cuadro1);
        repCuadros.save(cuadro1);
        repClientes.save(cliente1);
        cuadro2.setFechaVenta(fecha);
        cuadro2.setComprador(cliente2);
        cliente2.getCuadrosComprados().add(cuadro2);
        repCuadros.save(cuadro2);
        repClientes.save(cliente2);

        Date newfecha = Date.valueOf(LocalDate.of(2020, 03, 20));
        cuadro4.setFechaVenta(newfecha);
        cuadro4.setComprador(cliente3);
        cliente3.getCuadrosComprados().add(cuadro4);
        repCuadros.save(cuadro4);
        repClientes.save(cliente3);
    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        return "index";
    }

}
