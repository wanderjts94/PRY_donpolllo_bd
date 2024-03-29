package pe.edu.idat.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservaID")
	private Integer reservaID;


	@Column(name = "FechaReserva")
	private  Date FechaReserva ;

	@Column(name = "Direccionenvio" ,length = 50)
	private  String Direccionenvio;

	@Column(name = "tipoReserva", length = 25)
	private String tipoReserva;

	@Column(name = "estadoreserva" , length = 20)
	private String estadoreserva;

	public Reserva() {
		super();
	}

	public Reserva(Integer reservaID, Date fechaReserva, String direccionenvio, String tipoReserva,
			String estadoreserva) {
		super();
		this.reservaID = reservaID;
		this.FechaReserva = fechaReserva;
		this.Direccionenvio = direccionenvio;
		this.tipoReserva = tipoReserva;
		this.estadoreserva = estadoreserva;
	}

	public Integer getReservaID() {
		return reservaID;
	}

	public void setReservaID(Integer reservaID) {
		this.reservaID = reservaID;
	}

	public Date getFechaReserva() {
		return FechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.FechaReserva = fechaReserva;
	}

	public String getDireccionenvio() {
		return Direccionenvio;
	}

	public void setDireccionenvio(String direccionenvio) {
		this.Direccionenvio = direccionenvio;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public String getEstadoreserva() {
		return estadoreserva;
	}

	public void setEstadoreserva(String estadoreserva) {
		this.estadoreserva = estadoreserva;
	}

	
	




}
