package es.sd.Repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;
import es.sd.Entities.Cliente;
import es.sd.Entities.Cuadro;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	// Data base query methods

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

	// Data base order methods

	List<Autor> findAllByOrderByTituloCuadroAsc();

	List<Autor> findAllByOrderByTituloCuadroDesc();

	List<Autor> findAllByOrderByDescripcionCuadroAsc();

	List<Autor> findAllByOrderByDescripcionCuadroDesc();

	List<Autor> findAllByOrderByAnoFinCuadroAsc();

	List<Autor> findAllByOrderByAnoFinCuadroDesc();

	List<Autor> findAllByOrderByAnchoCuadroAsc();

	List<Autor> findAllByOrderByAnchoCuadroDesc();

	List<Autor> findAllByOrderByAltoCuadroAsc();

	List<Autor> findAllByOrderByAltoCuadroDesc();

	List<Autor> findAllByOrderByPrecioCuadroAsc();

	List<Autor> findAllByOrderByPrecioCuadroDesc();

	List<Autor> findAllByOrderByFechaVentaAsc();

	List<Autor> findAllByOrderByFechaVentaDesc();

	List<Autor> findAllByOrderByAutorAsc();

	List<Autor> findAllByOrderByAutorDesc();

	List<Autor> findAllByOrderByCompradorAsc();

	List<Autor> findAllByOrderByCompradorDesc();

}
