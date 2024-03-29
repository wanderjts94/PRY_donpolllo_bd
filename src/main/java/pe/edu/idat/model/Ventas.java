package pe.edu.idat.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Ventas {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaID;

    
    @Column(name = "fechaVenta")
    private Date fechaVenta;

    // ENPROGRESO - FINALIZADO - CANCELADO 
    @Column(name = "estadoVenta", length = 15)
    private String estadoVenta;
    

	// de uno a uno con pedido
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoID", insertable= false, updatable= false)
	private Pedido pedido;
	
	@Column(name="pedidoID" , nullable = false)
	private Integer pedidoID;

    
	//muchos a uno ; ventas a empleado
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "empleadoID", insertable= false, updatable= false)
	private Empleados empleadoV;
	
	@Column(name="empleadoID" , nullable = false)
	private Integer empleadoID;


	//muchos a uno ; ventas a usuario
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDusuario", insertable= false, updatable= false)
	private Usuario usuario;
	
	@Column(name="IDusuario" , nullable = false)
	private Integer IDusuario;

	public Ventas() {
		super();
	}

	public Ventas(Integer ventaID, Date fechaVenta, String estadoVenta, Integer pedidoID, Integer empleadoID,
			Integer iDusuario) {
		super();
		this.ventaID = ventaID;
		this.fechaVenta = fechaVenta;
		this.estadoVenta = estadoVenta;
		this.pedidoID = pedidoID;
		this.empleadoID = empleadoID;
		this.IDusuario = iDusuario;
	}

	public Integer getVentaID() {
		return ventaID;
	}

	public void setVentaID(Integer ventaID) {
		this.ventaID = ventaID;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(String estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Integer getPedidoID() {
		return pedidoID;
	}

	public void setPedidoID(Integer pedidoID) {
		this.pedidoID = pedidoID;
	}

	public Integer getEmpleadoID() {
		return empleadoID;
	}

	public void setEmpleadoID(Integer empleadoID) {
		this.empleadoID = empleadoID;
	}

	public Integer getIDusuario() {
		return IDusuario;
	}

	public void setIDusuario(Integer iDusuario) {
		this.IDusuario = iDusuario;
	}
	
	
	
	
	
	
	
	

}
