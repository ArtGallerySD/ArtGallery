package es.sd.Repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;
import es.sd.Entities.Cliente;
import es.sd.Entities.Cuadro;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	// Métodos simples de consulta de la base de datos

	Cuadro findByIdCuadro(long idCuadro);

	Cuadro findByTituloCuadro(String tituloCuadro);

	List<Cuadro> findByDescripcionCuadro(String descripcionCuadro);

	List<Cuadro> findByAnoFinCuadro(int anoFinCuadro);

	List<Cuadro> findByAnchoCuadro(double anchoCuadro);

	List<Cuadro> findByAltoCuadro(double altoCuadro);

	List<Cuadro> findByPrecioCuadro(int precioCuadro);

	List<Cuadro> findByFechaVenta(Date fechaVenta);

	List<Cuadro> findByAutor(Autor autor);

	List<Cuadro> findByComprador(Cliente comprador);

	// Métodos elaborados de consulta de la base de datos

	Cuadro findByTituloCuadroAndPrecioCuadro(String tituloCuadro, int precioCuadro);

	Cuadro findByTituloCuadroAndAnoFinCuadro(String tituloCuadro, int anoFinCuadro);

	Cuadro findByTituloCuadroAndAutor(String tituloCuadro, Autor autor);

	Cuadro findByTituloCuadroAndAnchoCuadro(String tituloCuadro, double anchoCuadro);

	Cuadro findByTituloCuadroAndComprador(String tituloCuadro, Cliente comprador);

	Cuadro findByTituloCuadroAndAltoCuadro(String tituloCuadro, double altoCuadro);

	Cuadro findByTituloCuadroAndFechaVenta(String tituloCuadro, Date fechaVenta);

	List<Cuadro> findByPrecioCuadroAndAnoFinCuadro(int precioCuadro, int anoFinCuadro);

	List<Cuadro> findByPrecioCuadroAndAutor(int precioCuadro, Autor autor);

	List<Cuadro> findByPrecioCuadroAndAnchoCuadro(int precioCuadro, double anchoCuadro);

	List<Cuadro> findByPrecioCuadroAndComprador(int precioCuadro, Cliente comprador);

	List<Cuadro> findByPrecioCuadroAndAltoCuadro(int precioCuadro, double altoCuadro);

	List<Cuadro> findByPrecioCuadroAndFechaVenta(int precioCuadro, Date fechaVenta);

	List<Cuadro> findByAnoFinCuadroAndAutor(int anoFinCuadro, Autor autor);

	List<Cuadro> findByAnoFinCuadroAndAnchoCuadro(int anoFinCuadro, double anchoCuadro);

	List<Cuadro> findByAnoFinCuadroAndComprador(int anoFinCuadro, Cliente comprador);

	List<Cuadro> findByAnoFinCuadroAndAltoCuadro(int anoFinCuadro, double altoCuadro);

	List<Cuadro> findByAnoFinCuadroAndFechaVenta(int anoFinCuadro, Date fechaVenta);

	List<Cuadro> findByAutorAndAnchoCuadro(Autor autor, double anchoCuadro);

	List<Cuadro> findByAutorAndComprador(Autor autor, Cliente comprador);

	List<Cuadro> findByAutorAndAltoCuadro(Autor autor, double altoCuadro);

	List<Cuadro> findByAutorAndFechaVenta(Autor autor, Date fechaVenta);

	List<Cuadro> findByAnchoCuadroAndComprador(double anchoCuadro, Cliente comprador);

	List<Cuadro> findByAnchoCuadroAndAltoCuadro(double anchoCuadro, double altoCuadro);

	List<Cuadro> findByAnchoCuadroAndFechaVenta(double anchoCuadro, Date fechaVenta);

	List<Cuadro> findByCompradorAndAltoCuadro(Cliente comprador, double altoCuadro);

	List<Cuadro> findByCompradorAndFechaVenta(Cliente comprador, Date fechaVenta);

	List<Cuadro> findByAltoCuadroAndFechaVenta(double altoCuadro, Date fechaVenta);

	Cuadro findByTituloCuadroAndPrecioCuadroAndAnoFinCuadroAndAutorAndAnchoCuadroAndCompradorAndAltoCuadroAndFechaVenta(
			String tituloCuadro, int precioCuadro, int anoFinCuadro, Autor autor, double anchoCuadro, Cliente comprador,
			double altoCuadro, Date fechaVenta);

	// Metodos de ordenación de la base de datos

	List<Cuadro> findAllByOrderByTituloCuadroAsc();

	List<Cuadro> findAllByOrderByTituloCuadroDesc();

	List<Cuadro> findAllByOrderByDescripcionCuadroAsc();

	List<Cuadro> findAllByOrderByDescripcionCuadroDesc();

	List<Cuadro> findAllByOrderByAnoFinCuadroAsc();

	List<Cuadro> findAllByOrderByAnoFinCuadroDesc();

	List<Cuadro> findAllByOrderByAnchoCuadroAsc();

	List<Cuadro> findAllByOrderByAnchoCuadroDesc();

	List<Cuadro> findAllByOrderByAltoCuadroAsc();

	List<Cuadro> findAllByOrderByAltoCuadroDesc();

	List<Cuadro> findAllByOrderByPrecioCuadroAsc();

	List<Cuadro> findAllByOrderByPrecioCuadroDesc();

	List<Cuadro> findAllByOrderByFechaVentaAsc();

	List<Cuadro> findAllByOrderByFechaVentaDesc();

	List<Cuadro> findAllByOrderByAutorAsc();

	List<Cuadro> findAllByOrderByAutorDesc();

	List<Cuadro> findAllByOrderByCompradorAsc();

	List<Cuadro> findAllByOrderByCompradorDesc();

}
