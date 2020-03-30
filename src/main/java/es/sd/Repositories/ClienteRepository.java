package es.sd.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByIdCliente(long idCliente);
	
	List<Cliente> findByNombreCliente(String nombreCliente);

	List<Cliente> findByApellidosCliente(String apellidosCliente);

	Cliente findByNifCliente(String nifCliente);

	List<Cliente> findByCpCliente(int cpCliente);

	Cliente findByMailCliente(String mailCliente);

	Cliente findByTelefonoCliente(int telefonoCliente);

}
