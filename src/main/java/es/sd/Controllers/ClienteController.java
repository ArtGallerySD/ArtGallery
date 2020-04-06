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

	// MAPEO DEL MÓDULO DE CLIENTES

	@RequestMapping(value = "/clientes")
	public String clientes(Model model) {
		return "clientes";
	}

	// REGISTRO DE CLIENTES

	@RequestMapping(value = "/registroClientes")
	public String registrarCliente(@RequestParam String nifCliente, @RequestParam String mailCliente,
			@RequestParam int telefonoCliente, Cliente cliente) {

		if ((repClientes.findByNifCliente(nifCliente) == null) && (repClientes.findByMailCliente(mailCliente) == null)
				&& (repClientes.findByTelefonoCliente(telefonoCliente) == null)) {
			repClientes.save(cliente);

			return "exito_registro";
		} else
			return "fallo_registro_cliente";

	}

	// CONSULTAS, FILTROS Y ORDENACIÓN DE CLIENTES

	@RequestMapping(value = "/consultasClientes")
	public String mostrarClientes(Model model) {

		List<Cliente> clientes = repClientes.findAll();

		model.addAttribute("clientes", clientes);

		return "consultasClientes";
	}

	@RequestMapping(value = "/filtrarClientes")
	public String filtrarClientes(@RequestParam(required = false) String nombreCliente,
			@RequestParam(required = false) String apellidosCliente, @RequestParam(required = false) String nifCliente,
			@RequestParam(required = false, defaultValue = "0") int cpCliente,
			@RequestParam(required = false) String mailCliente,
			@RequestParam(required = false, defaultValue = "0") int telefonoCliente, Model model) {

		if ((!nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals("")) && (cpCliente == 0)
				&& (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesNombre = repClientes.findByNombreCliente(nombreCliente);
			model.addAttribute("clientes", clientesNombre);
		}

		else if ((nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesApellidos = repClientes.findByApellidosCliente(apellidosCliente);
			model.addAttribute("clientes", clientesApellidos);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteNIF = repClientes.findByNifCliente(nifCliente);
			model.addAttribute("clientes", clienteNIF);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente != 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesCP = repClientes.findByCpCliente(cpCliente);
			model.addAttribute("clientes", clientesCP);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (!mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteMail = repClientes.findByMailCliente(mailCliente);
			model.addAttribute("clientes", clienteMail);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteTelefono = repClientes.findByTelefonoCliente(telefonoCliente);
			model.addAttribute("clientes", clienteTelefono);
		}

		else if ((!nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesNombreApellidos = repClientes.findByNombreClienteAndApellidosCliente(nombreCliente,
					apellidosCliente);
			model.addAttribute("clientes", clientesNombreApellidos);
		}

		else if ((!nombreCliente.equals("")) && (apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteNombreNIF = repClientes.findByNombreClienteAndNifCliente(nombreCliente, nifCliente);
			model.addAttribute("clientes", clienteNombreNIF);
		}

		else if ((!nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente != 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesNombreCP = repClientes.findByNombreClienteAndCpCliente(nombreCliente, cpCliente);
			model.addAttribute("clientes", clientesNombreCP);
		}

		else if ((!nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (!mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteNombreMail = repClientes.findByNombreClienteAndMailCliente(nombreCliente, mailCliente);
			model.addAttribute("clientes", clienteNombreMail);
		}

		else if ((!nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteNombreTelefono = repClientes.findByNombreClienteAndTelefonoCliente(nombreCliente,
					telefonoCliente);
			model.addAttribute("clientes", clienteNombreTelefono);
		}

		else if ((nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteApellidosNIF = repClientes.findByApellidosClienteAndNifCliente(apellidosCliente, nifCliente);
			model.addAttribute("clientes", clienteApellidosNIF);
		}

		else if ((nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente != 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			List<Cliente> clientesApellidosCP = repClientes.findByApellidosClienteAndCpCliente(apellidosCliente,
					cpCliente);
			model.addAttribute("clientes", clientesApellidosCP);
		}

		else if ((nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (!mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteApellidosMail = repClientes.findByApellidosClienteAndMailCliente(apellidosCliente,
					mailCliente);
			model.addAttribute("clientes", clienteApellidosMail);
		}

		else if ((nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteApellidosTelefono = repClientes.findByApellidosClienteAndTelefonoCliente(apellidosCliente,
					telefonoCliente);
			model.addAttribute("clientes", clienteApellidosTelefono);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente != 0) && (mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteNIFCP = repClientes.findByNifClienteAndCpCliente(nifCliente, cpCliente);
			model.addAttribute("clientes", clienteNIFCP);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente == 0) && (!mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteNIFMail = repClientes.findByNifClienteAndMailCliente(nifCliente, mailCliente);
			model.addAttribute("clientes", clienteNIFMail);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente == 0) && (mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteNIFTelefono = repClientes.findByNifClienteAndTelefonoCliente(nifCliente, telefonoCliente);
			model.addAttribute("clientes", clienteNIFTelefono);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente != 0) && (!mailCliente.equals("")) && (telefonoCliente == 0)) {
			Cliente clienteCPMail = repClientes.findByCpClienteAndMailCliente(cpCliente, mailCliente);
			model.addAttribute("clientes", clienteCPMail);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente != 0) && (mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteCPTelefono = repClientes.findByCpClienteAndTelefonoCliente(cpCliente, telefonoCliente);
			model.addAttribute("clientes", clienteCPTelefono);
		}

		else if ((nombreCliente.equals("")) && (apellidosCliente.equals("")) && (nifCliente.equals(""))
				&& (cpCliente == 0) && (!mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteMailTelefono = repClientes.findByMailClienteAndTelefonoCliente(mailCliente, telefonoCliente);
			model.addAttribute("clientes", clienteMailTelefono);
		}

		else if ((!nombreCliente.equals("")) && (!apellidosCliente.equals("")) && (!nifCliente.equals(""))
				&& (cpCliente != 0) && (!mailCliente.equals("")) && (telefonoCliente != 0)) {
			Cliente clienteTodo = repClientes
					.findByNombreClienteAndApellidosClienteAndNifClienteAndCpClienteAndMailClienteAndTelefonoCliente(
							nombreCliente, apellidosCliente, nifCliente, cpCliente, mailCliente, telefonoCliente);
			model.addAttribute("clientes", clienteTodo);
		}

		else {
			List<Cliente> clientes = repClientes.findAll();
			model.addAttribute("clientes", clientes);
		}

		return "consultasClientes";
	}

	@RequestMapping(value = "/ordenarClientes")
	public String ordenarClientes(@RequestParam int ordenCliente, Model model) {

		switch (ordenCliente) {
		case 0:
			List<Cliente> clientes0 = repClientes.findAll();
			model.addAttribute("clientes", clientes0);
			break;
		case 1:
			List<Cliente> clientes1 = repClientes.findAllByOrderByNombreClienteAsc();
			model.addAttribute("clientes", clientes1);
			break;
		case 2:
			List<Cliente> clientes2 = repClientes.findAllByOrderByNombreClienteDesc();
			model.addAttribute("clientes", clientes2);
			break;
		case 3:
			List<Cliente> clientes3 = repClientes.findAllByOrderByApellidosClienteAsc();
			model.addAttribute("clientes", clientes3);
			break;
		case 4:
			List<Cliente> clientes4 = repClientes.findAllByOrderByApellidosClienteDesc();
			model.addAttribute("clientes", clientes4);
			break;
		case 5:
			List<Cliente> clientes5 = repClientes.findAllByOrderByNifClienteAsc();
			model.addAttribute("clientes", clientes5);
			break;
		case 6:
			List<Cliente> clientes6 = repClientes.findAllByOrderByNifClienteDesc();
			model.addAttribute("clientes", clientes6);
			break;
		case 7:
			List<Cliente> clientes7 = repClientes.findAllByOrderByCpClienteAsc();
			model.addAttribute("clientes", clientes7);
			break;
		case 8:
			List<Cliente> clientes8 = repClientes.findAllByOrderByCpClienteDesc();
			model.addAttribute("clientes", clientes8);
			break;
		case 9:
			List<Cliente> clientes9 = repClientes.findAllByOrderByMailClienteAsc();
			model.addAttribute("clientes", clientes9);
			break;
		case 10:
			List<Cliente> clientes10 = repClientes.findAllByOrderByMailClienteDesc();
			model.addAttribute("clientes", clientes10);
			break;
		case 11:
			List<Cliente> clientes11 = repClientes.findAllByOrderByTelefonoClienteAsc();
			model.addAttribute("clientes", clientes11);
			break;
		case 12:
			List<Cliente> clientes12 = repClientes.findAllByOrderByTelefonoClienteDesc();
			model.addAttribute("clientes", clientes12);
			break;
		default:
			List<Cliente> clientesDefault = repClientes.findAll();
			model.addAttribute("autores", clientesDefault);
		}

		return "consultasClientes";
	}

	// MODIFICACIONES A CLIENTES

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

		return "exito_edicion";
	}

}
