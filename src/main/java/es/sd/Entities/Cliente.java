package es.sd.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;

	private String nombreCliente;
	private String apellidosCliente;
	private String nifCliente;
	private int cpCliente;
	private String mailCliente;
	private int telefonoCliente;

	@OneToMany(mappedBy = "comprador")
	private List<Cuadro> cuadrosComprados;

	// Generator Constructors
	public Cliente() {
	}

	public Cliente(String nombreCliente, String apellidosCliente, String nifCliente, int cpCliente, String mailCliente,
			int telefonoCliente) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.nifCliente = nifCliente;
		this.cpCliente = cpCliente;
		this.mailCliente = mailCliente;
		this.telefonoCliente = telefonoCliente;
		this.cuadrosComprados = new ArrayList<>();
	}

	// Getters and Setters

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public String getNifCliente() {
		return nifCliente;
	}

	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	public int getCpCliente() {
		return cpCliente;
	}

	public void setCpCliente(int cpCliente) {
		this.cpCliente = cpCliente;
	}

	public String getMailCliente() {
		return mailCliente;
	}

	public void setMailCliente(String mailCliente) {
		this.mailCliente = mailCliente;
	}

	public int getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public List<Cuadro> getCuadrosComprados() {
		return cuadrosComprados;
	}

	public void setCuadrosComprados(List<Cuadro> cuadrosComprados) {
		this.cuadrosComprados = cuadrosComprados;
	}

}
