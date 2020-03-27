package es.sd.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import es.sd.Entities.Cliente;
import es.sd.Repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	ClienteRepository repCliente;

	@RequestMapping(value = "/clientes")
	public String clientes(Model model) {
		return "clientes";
	}

	@RequestMapping(value = "/registroClientes")
	public String registrarCliente(Cliente cliente) {
		
		repCliente.save(cliente);

		return "registro";
	}

}
