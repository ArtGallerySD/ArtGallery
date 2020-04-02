package es.sd.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	// Data base query methods

	Autor findByIdAutor(long idAutor);

	List<Autor> findByNombreAutor(String nombreAutor);

	List<Autor> findByApellidosAutor(String apellidosAutor);

	Autor findByNifAutor(String nifAutor);

	List<Autor> findByAnoNacimientoAutor(int anoNacimientoAutor);

	List<Autor> findByPaisNacimientoAutor(String paisNacimientoAutor);

	List<Autor> findByCpAutor(int cpAutor);

	Autor findByMailAutor(String mailAutor);

	Autor findByTelefonoAutor(int telefonoAutor);

	// Data base order methods

	List<Autor> findAllByOrderByNombreAutorAsc();

	List<Autor> findAllByOrderByNombreAutorDesc();

	List<Autor> findAllByOrderByApellidosAutorAsc();

	List<Autor> findAllByOrderByApellidosAutorDesc();

	List<Autor> findAllByOrderByNifAutorAsc();

	List<Autor> findAllByOrderByNifAutorDesc();

	List<Autor> findAllByOrderByAnoNacimientoAutorAsc();

	List<Autor> findAllByOrderByAnoNacimientoAutorDesc();

	List<Autor> findAllByOrderByPaisNacimientoAutorAsc();

	List<Autor> findAllByOrderByPaisNacimientoAutorDesc();

	List<Autor> findAllByOrderByCpAutorAsc();

	List<Autor> findAllByOrderByCpAutorDesc();

	List<Autor> findAllByOrderByMailAutorAsc();

	List<Autor> findAllByOrderByMailAutorDesc();

	List<Autor> findAllByOrderByTelefonoAutorAsc();

	List<Autor> findAllByOrderByTelefonoAutorDesc();

}
