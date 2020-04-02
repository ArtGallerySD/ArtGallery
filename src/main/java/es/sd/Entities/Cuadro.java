package es.sd.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cuadro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCuadro;

	private String tituloCuadro;
	private String descripcionCuadro;
	private int anoFinCuadro;
	private double anchoCuadro;
	private double altoCuadro;
	private int precioCuadro;

	// Atributos para los ya vendidos
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente comprador;

	private java.sql.Date fechaVenta;

	@ManyToOne
	@JoinColumn(name = "idAutor")
	private Autor autor;

	// Generator Constructors
	public Cuadro() {
	}

	public Cuadro(String tituloCuadro, String descripcionCuadro, int anoFinCuadro, double anchoCuadro,
			double altoCuadro, int precioCuadro) {
		this.tituloCuadro = tituloCuadro;
		this.descripcionCuadro = descripcionCuadro;
		this.anoFinCuadro = anoFinCuadro;
		this.anchoCuadro = anchoCuadro;
		this.altoCuadro = altoCuadro;
		this.precioCuadro = precioCuadro;
	}

	// Getters and SettersFS

	public long getIdCuadro() {
		return idCuadro;
	}

	public void setIdCuadro(long idCuadro) {
		this.idCuadro = idCuadro;
	}

	public String getTituloCuadro() {
		return tituloCuadro;
	}

	public void setTituloCuadro(String tituloCuadro) {
		this.tituloCuadro = tituloCuadro;
	}

	public String getDescripcionCuadro() {
		return descripcionCuadro;
	}

	public void setDescripcionCuadro(String descripcionCuadro) {
		this.descripcionCuadro = descripcionCuadro;
	}

	public int getAnoFinCuadro() {
		return anoFinCuadro;
	}

	public void setAnoFinCuadro(int anoFinCuadro) {
		this.anoFinCuadro = anoFinCuadro;
	}

	public double getAnchoCuadro() {
		return anchoCuadro;
	}

	public void setAnchoCuadro(double anchoCuadro) {
		this.anchoCuadro = anchoCuadro;
	}

	public double getAltoCuadro() {
		return altoCuadro;
	}

	public void setAltoCuadro(double altoCuadro) {
		this.altoCuadro = altoCuadro;
	}

	public int getPrecioCuadro() {
		return precioCuadro;
	}

	public void setPrecioCuadro(int precioCuadro) {
		this.precioCuadro = precioCuadro;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public java.sql.Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(java.sql.Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
