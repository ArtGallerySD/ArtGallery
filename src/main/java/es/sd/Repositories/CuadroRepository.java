package es.sd.Repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;
import es.sd.Entities.Cuadro;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	Cuadro findByTituloCuadro(String tituloCuadro);

	List<Cuadro> findByDescripcionCuadro(String descripcionCuadro);

	List<Cuadro> findByAnoFinCuadro(int anoFinCuadro);

	List<Cuadro> findByAnchoCuadro(double anchoCuadro);

	List<Cuadro> findByAltoCuadro(double altoCuadro);

	List<Cuadro> findByPrecioCuadro(int precioCuadro);

	List<Cuadro> findByFechaVenta(Date fechaVenta);

	Cuadro findByTituloCuadroAndAutor(String tituloCuadro, Autor autor);

}
