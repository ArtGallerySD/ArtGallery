package es.sd.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import es.sd.Entities.Cliente;
import es.sd.Repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository repClientes;

	private Cliente clienteEditando;

	@RequestMapping(value = "/clientes")
	public String clientes(Model model) {
		return "clientes";
	}

	@RequestMapping(value = "/registroClientes")
	public String registrarCliente(@RequestParam String nifCliente, @RequestParam String mailCliente,
			@RequestParam int telefonoCliente, Cliente cliente) {

		if ((repClientes.findByNifCliente(nifCliente) == null) && (repClientes.findByMailCliente(mailCliente) == null)
				&& (repClientes.findByTelefonoCliente(telefonoCliente) == null)) {
			repClientes.save(cliente);

			return "registro";
		} else
			return "fallo_registro";

	}

	@RequestMapping(value = "/consultasClientes")
	public String mostrarClientes(Model model) {

		List<Cliente> clientes = repClientes.findAll();

		model.addAttribute("clientes", clientes);

		return "consultasClientes";
	}

	@RequestMapping(value = "/modificarCliente")
	public String modificarCliente(@RequestParam long id, Model model) {

		Cliente cliente = repClientes.findByIdCliente(id);
		clienteEditando = cliente;

		model.addAttribute("cliente", cliente);

		return "modificarCliente";
	}

	@RequestMapping(value = "/edicionClientes")
	public String resultadoEdicionCliente(@RequestParam String nifCliente, @RequestParam String mailCliente,
			@RequestParam int telefonoCliente, Cliente c) {

		if (!clienteEditando.getNombreCliente().equals(c.getNombreCliente()))
			clienteEditando.setNombreCliente(c.getNombreCliente());

		if (!clienteEditando.getApellidosCliente().equals(c.getApellidosCliente()))
			clienteEditando.setApellidosCliente(c.getApellidosCliente());

		if ((!clienteEditando.getNifCliente().equals(c.getNifCliente()))
				&& (repClientes.findByNifCliente(nifCliente) == null))
			clienteEditando.setNifCliente(c.getNifCliente());

		if (clienteEditando.getCpCliente() != c.getCpCliente())
			clienteEditando.setCpCliente(c.getCpCliente());

		if ((!clienteEditando.getMailCliente().equals(c.getMailCliente()))
				&& (repClientes.findByMailCliente(mailCliente) == null))
			clienteEditando.setMailCliente(c.getMailCliente());

		if ((clienteEditando.getTelefonoCliente() != c.getTelefonoCliente())
				&& (repClientes.findByTelefonoCliente(telefonoCliente) == null))
			clienteEditando.setTelefonoCliente(c.getTelefonoCliente());

		repClientes.save(clienteEditando);

		return "edicion";
	}

}
