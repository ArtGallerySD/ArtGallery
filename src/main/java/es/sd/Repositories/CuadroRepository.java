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

	Cuadro findByTituloCuadroAndAutor(String tituloCuadro, Autor autor);

	// Métodos elaborados de consulta de la base de datos

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
