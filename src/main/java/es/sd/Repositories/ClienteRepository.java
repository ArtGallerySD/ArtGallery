package es.sd.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.Entities.Autor;
import es.sd.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	// Data base query methods

	Cliente findByIdCliente(long idCliente);

	List<Cliente> findByNombreCliente(String nombreCliente);

	List<Cliente> findByApellidosCliente(String apellidosCliente);

	Cliente findByNifCliente(String nifCliente);

	List<Cliente> findByCpCliente(int cpCliente);

	Cliente findByMailCliente(String mailCliente);

	Cliente findByTelefonoCliente(int telefonoCliente);

	// Data base order methods

	List<Autor> findAllByOrderByNombreClienteAsc();

	List<Autor> findAllByOrderByNombreClienteDesc();

	List<Autor> findAllByOrderByApellidosClienteAsc();

	List<Autor> findAllByOrderByApellidosClienteDesc();

	List<Autor> findAllByOrderByNifClienteAsc();

	List<Autor> findAllByOrderByNifClienteDesc();

	List<Autor> findAllByOrderByCpClienteAsc();

	List<Autor> findAllByOrderByCpClienteDesc();

	List<Autor> findAllByOrderByMailClienteAsc();

	List<Autor> findAllByOrderByMailClienteDesc();

	List<Autor> findAllByOrderByTelefonoClienteAsc();

	List<Autor> findAllByOrderByTelefonoClienteDesc();

}
