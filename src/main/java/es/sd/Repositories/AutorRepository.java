package es.sd.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByIdAutor(long idAutor);
	
	Autor findByNombreAutor(String nombreAutor);

	List<Autor> findByApellidosAutor(String apellidosAutor);

	Autor findByNifAutor(String nifAutor);

	List<Autor> findByAnoNacimientoAutor(int anoNacimientoAutor);

	List<Autor> findByPaisNacimientoAutor(String paisNacimientoAutor);

	List<Autor> findByCpAutor(int cpAutor);

	Autor findByMailAutor(String mailAutor);

	Autor findByTelefonoAutor(int telefonoAutor);

}
