package es.sd.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	// Métodos simples de consulta de la base de datos

	Autor findByIdAutor(long idAutor);

	List<Autor> findByNombreAutor(String nombreAutor);

	List<Autor> findByApellidosAutor(String apellidosAutor);

	Autor findByNifAutor(String nifAutor);

	List<Autor> findByAnoNacimientoAutor(int anoNacimientoAutor);

	List<Autor> findByPaisNacimientoAutor(String paisNacimientoAutor);

	List<Autor> findByCpAutor(int cpAutor);

	Autor findByMailAutor(String mailAutor);

	Autor findByTelefonoAutor(int telefonoAutor);

	// Métodos elaborados de consulta de la base de datos

	List<Autor> findByNombreAutorAndApellidosAutor(String nombreAutor, String apellidosAutor);

	Autor findByNombreAutorAndNifAutor(String nombreAutor, String nifAutor);

	List<Autor> findByNombreAutorAndAnoNacimientoAutor(String nombreAutor, int anoNacimientoAutor);

	List<Autor> findByNombreAutorAndPaisNacimientoAutor(String nombreAutor, String paisNacimientoAutor);

	List<Autor> findByNombreAutorAndCpAutor(String nombreAutor, int cpAutor);

	Autor findByNombreAutorAndMailAutor(String nombreAutor, String mailAutor);

	Autor findByNombreAutorAndTelefonoAutor(String nombreAutor, int telefonoAutor);

	Autor findByApellidosAutorAndNifAutor(String apellidosAutor, String nifAutor);

	List<Autor> findByApellidosAutorAndAnoNacimientoAutor(String apellidosAutor, int anoNacimientoAutor);

	List<Autor> findByApellidosAutorAndPaisNacimientoAutor(String apellidosAutor, String paisNacimientoAutor);

	List<Autor> findByApellidosAutorAndCpAutor(String apellidosAutor, int cpAutor);

	Autor findByApellidosAutorAndMailAutor(String apellidosAutor, String mailAutor);

	Autor findByApellidosAutorAndTelefonoAutor(String apellidosAutor, int telefonoAutor);

	Autor findByNifAutorAndAnoNacimientoAutor(String nifAutor, int anoNacimientoAutor);

	Autor findByNifAutorAndPaisNacimientoAutor(String nifAutor, String paisNacimientoAutor);

	Autor findByNifAutorAndCpAutor(String nifAutor, int cpAutor);

	Autor findByNifAutorAndMailAutor(String nifAutor, String mailAutor);

	Autor findByNifAutorAndTelefonoAutor(String nifAutor, int telefonoAutor);

	List<Autor> findByAnoNacimientoAutorAndPaisNacimientoAutor(int anoNacimientoAutor, String paisNacimientoAutor);

	List<Autor> findByAnoNacimientoAutorAndCpAutor(int anoNacimientoAutor, int cpAutor);

	Autor findByAnoNacimientoAutorAndMailAutor(int anoNacimientoAutor, String mailAutor);

	Autor findByAnoNacimientoAutorAndTelefonoAutor(int anoNacimientoAutor, int telefonoAutor);

	List<Autor> findByPaisNacimientoAutorAndCpAutor(String paisNacimientoAutor, int cpAutor);

	Autor findByPaisNacimientoAutorAndMailAutor(String paisNacimientoAutor, String mailAutor);

	Autor findByPaisNacimientoAutorAndTelefonoAutor(String paisNacimientoAutor, int telefonoAutor);

	Autor findByCpAutorAndMailAutor(int cpAutor, String mailAutor);

	Autor findByCpAutorAndTelefonoAutor(int cpAutor, int telefonoAutor);

	Autor findByMailAutorAndTelefonoAutor(String mailAutor, int telefonoAutor);

	Autor findByNombreAutorAndApellidosAutorAndNifAutorAndAnoNacimientoAutorAndPaisNacimientoAutorAndCpAutorAndMailAutorAndTelefonoAutor(
			String nombreAutor, String apellidosAutor, String nifAutor, int anoNacimientoAutor,
			String paisNacimientoAutor, int cpAutor, String mailAutor, int telefonoAutor);

	// Metodos de ordenación de la base de datos

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
