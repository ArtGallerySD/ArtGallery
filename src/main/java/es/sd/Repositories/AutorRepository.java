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

	Autor findByNifAutorAndMailAutor(String nifAutor, String mailAutor);

	Autor findByNifAutorAndTelefonoAutor(String nifAutor, int telefonoAutor);

	Autor findByMailAutorAndTelefonoAutor(String mailAutor, int telefonoAutor);

	Autor findByNifAutorAndMailAutorAndTelefonoAutor(String nifAutor, String mailAutor, int telefonoAutor);

	List<Autor> findByNombreAutorAndApellidosAutor(String nombreAutor, String apellidosAutor);

	List<Autor> findByNombreAutorAndAnoNacimientoAutor(String nombreAutor, int anoNacimientoAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndPaisNacimientoAutor(String nombreAutor, String apellidosAutor,
			String paisNacimientoAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndCpAutor(String nombreAutor, String apellidosAutor, int cpAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndAnoNacimientoAutorAndCpAutor(String nombreAutor,
			String apellidosAutor, int anoNacimientoAutor, int cpAutor);

	List<Autor> findByNombreAutorAndPaisNacimientoAutor(String nombreAutor, String paisNacimientoAutor);

	List<Autor> findByNombreAutorAndCpAutor(String nombreAutor, int cpAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndAnoNacimientoAutor(String nombreAutor, String apellidosAutor,
			int anoNacimientoAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndAnoNacimientoAutorAndPaisNacimientoAutor(String nombreAutor,
			String apellidosAutor, int anoNacimientoAutor, String paisNacimientoAutor);

	List<Autor> findByNombreAutorAndApellidosAutorAndAnoNacimientoAutorAndPaisNacimientoAutorAndCpAutor(
			String nombreAutor, String apellidosAutor, int anoNacimientoAutor, String paisNacimientoAutor, int cpAutor);

	List<Autor> findByApellidosAutorAndAnoNacimientoAutor(String apellidosAutor, int anoNacimientoAutor);

	List<Autor> findByApellidosAutorAndPaisNacimientoAutor(String apellidosAutor, String paisNacimientoAutor);

	List<Autor> findByApellidosAutorAndCpAutor(String apellidosAutor, int cpAutor);

	List<Autor> findByApellidosAutorAndAnoNacimientoAutorAndCpAutor(String apellidosAutor, int anoNacimientoAutor,
			int cpAutor);

	List<Autor> findByApellidosAutorAndAnoNacimientoAutorAndPaisNacimientoAutor(String apellidosAutor,
			int anoNacimientoAutor, String paisNacimientoAutor);

	List<Autor> findByApellidosAutorAndAnoNacimientoAutorAndPaisNacimientoAutorAndCpAutor(String apellidosAutor,
			int anoNacimientoAutor, String paisNacimientoAutor, int cpAutor);

	List<Autor> findByAnoNacimientoAutorAndPaisNacimientoAutor(int anoNacimientoAutor, String paisNacimientoAutor);

	List<Autor> findByAnoNacimientoAutorAndCpAutor(int anoNacimientoAutor, int cpAutor);

	List<Autor> findByAnoNacimientoAutorAndPaisNacimientoAutorAndCpAutor(int anoNacimientoAutor,
			String paisNacimientoAutor, int cpAutor);

	List<Autor> findByPaisNacimientoAutorAndCpAutor(String paisNacimientoAutor, int cpAutor);

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
