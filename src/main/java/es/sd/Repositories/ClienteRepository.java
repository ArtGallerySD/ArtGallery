package es.sd.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	// Métodos simples de consulta de la base de datos

	Cliente findByIdCliente(long idCliente);

	List<Cliente> findByNombreCliente(String nombreCliente);

	List<Cliente> findByApellidosCliente(String apellidosCliente);

	Cliente findByNifCliente(String nifCliente);

	List<Cliente> findByCpCliente(int cpCliente);

	Cliente findByMailCliente(String mailCliente);

	Cliente findByTelefonoCliente(int telefonoCliente);

	// Métodos elaborados de consulta de la base de datos

	List<Cliente> findByNombreClienteAndApellidosCliente(String nombreCliente, String apellidosCliente);

	Cliente findByNombreClienteAndNifCliente(String nombreCliente, String nifCliente);

	List<Cliente> findByNombreClienteAndCpCliente(String nombreCliente, int cpCliente);

	Cliente findByNombreClienteAndMailCliente(String nombreCliente, String mailCliente);

	Cliente findByNombreClienteAndTelefonoCliente(String nombreCliente, int telefonoCliente);

	Cliente findByApellidosClienteAndNifCliente(String apellidosCliente, String nifCliente);

	List<Cliente> findByApellidosClienteAndCpCliente(String apellidosCliente, int cpCliente);

	Cliente findByApellidosClienteAndMailCliente(String apellidosCliente, String mailCliente);

	Cliente findByApellidosClienteAndTelefonoCliente(String apellidosCliente, int telefonoCliente);

	Cliente findByNifClienteAndCpCliente(String nifCliente, int cpCliente);

	Cliente findByNifClienteAndMailCliente(String nifCliente, String mailCliente);

	Cliente findByNifClienteAndTelefonoCliente(String nifCliente, int telefonoCliente);

	Cliente findByCpClienteAndMailCliente(int cpCliente, String mailCliente);

	Cliente findByCpClienteAndTelefonoCliente(int cpCliente, int telefonoCliente);

	Cliente findByMailClienteAndTelefonoCliente(String mailCliente, int telefonoCliente);

	Cliente findByNombreClienteAndApellidosClienteAndNifClienteAndCpClienteAndMailClienteAndTelefonoCliente(
			String nombreCliente, String apellidosCliente, String nifCliente, int cpCliente, String mailCliente,
			int telefonoCliente);

	// Metodos de ordenación de la base de datos

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
