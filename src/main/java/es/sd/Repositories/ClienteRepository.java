package es.sd.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
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

	List<Cliente> findAllByOrderByNombreClienteAsc();

	List<Cliente> findAllByOrderByNombreClienteDesc();

	List<Cliente> findAllByOrderByApellidosClienteAsc();

	List<Cliente> findAllByOrderByApellidosClienteDesc();

	List<Cliente> findAllByOrderByNifClienteAsc();

	List<Cliente> findAllByOrderByNifClienteDesc();

	List<Cliente> findAllByOrderByCpClienteAsc();

	List<Cliente> findAllByOrderByCpClienteDesc();

	List<Cliente> findAllByOrderByMailClienteAsc();

	List<Cliente> findAllByOrderByMailClienteDesc();

	List<Cliente> findAllByOrderByTelefonoClienteAsc();

	List<Cliente> findAllByOrderByTelefonoClienteDesc();

}
