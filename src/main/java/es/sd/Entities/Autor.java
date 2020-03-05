package es.sd.Entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAutor;

	private String nombreAutor;
	private String apellidosAutor;
	private String nifAutor;
	private int anoNacimientoAutor;
	private String paisNacimientoAutor;
	private int cpAutor;
	private String mailAutor;
	private int telefonoAutor;

	@OneToMany(mappedBy = "autor")
	private List<Cuadro> cuadrosCreados;

	// Generator Constructors
	public Autor() {
	}

	public Autor(String nombre, String apellidos, String nif, int nacimiento, String pais, int cp, String mail,
			int telefono) {
		this.nombreAutor = nombre;
		this.apellidosAutor = apellidos;
		this.nifAutor = nif;
		this.anoNacimientoAutor = nacimiento;
		this.paisNacimientoAutor = pais;
		this.cpAutor = cp;
		this.mailAutor = mail;
		this.telefonoAutor = telefono;
		this.cuadrosCreados = new ArrayList<>();
	}

	// Getters and Setters

	public long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidosAutor() {
		return apellidosAutor;
	}

	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}

	public String getNifAutor() {
		return nifAutor;
	}

	public void setNifAutor(String nifAutor) {
		this.nifAutor = nifAutor;
	}

	public int getAnoNacimientoAutor() {
		return anoNacimientoAutor;
	}

	public void setAnoNacimientoAutor(int anoNacimientoAutor) {
		this.anoNacimientoAutor = anoNacimientoAutor;
	}

	public String getPaisNacimientoAutor() {
		return paisNacimientoAutor;
	}

	public void setPaisNacimientoAutor(String paisNacimientoAutor) {
		this.paisNacimientoAutor = paisNacimientoAutor;
	}

	public int getCpAutor() {
		return cpAutor;
	}

	public void setCpAutor(int cpAutor) {
		this.cpAutor = cpAutor;
	}

	public String getMailAutor() {
		return mailAutor;
	}

	public void setMailAutor(String mailAutor) {
		this.mailAutor = mailAutor;
	}

	public int getTelefonoAutor() {
		return telefonoAutor;
	}

	public void setTelefonoAutor(int telefonoAutor) {
		this.telefonoAutor = telefonoAutor;
	}

}
