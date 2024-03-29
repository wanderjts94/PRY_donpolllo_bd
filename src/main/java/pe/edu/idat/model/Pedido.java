package pe.edu.idat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedidoID;

   
    @Column(name = "fechaPedido", length = 20)
    private Date fechaPedido;


	//muchos a uno pedidos a un empleado
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "empleadoID", insertable= false, updatable= false)
	private Empleados empleadoP;
	
	@Column(name="empleadoID" , nullable = false)
	private Integer empleadoID;
    
	
	// de uno a uno con reserva
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservaID", insertable= false, updatable= false)
	private Reserva reserva;
	
	@Column(name="reservaID" , nullable = false)
	private Integer reservaID;

    // de uno a muchos con pedido
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval =true )
	@Fetch(FetchMode.JOIN)
	private List<Detalle_Pedido_Menus> listadetpedido = new ArrayList<Detalle_Pedido_Menus>();

	public Pedido() {
		super();
	}

	public Pedido(Integer pedidoID, Date fechaPedido, Integer empleadoID, Integer reservaID) {
		super();
		this.pedidoID = pedidoID;
		this.fechaPedido = fechaPedido;
		this.empleadoID = empleadoID;
		this.reservaID = reservaID;
	}

	public Integer getPedidoID() {
		return pedidoID;
	}

	public void setPedidoID(Integer pedidoID) {
		this.pedidoID = pedidoID;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getEmpleadoID() {
		return empleadoID;
	}

	public void setEmpleadoID(Integer empleadoID) {
		this.empleadoID = empleadoID;
	}

	public Integer getReservaID() {
		return reservaID;
	}

	public void setReservaID(Integer reservaID) {
		this.reservaID = reservaID;
	}
	
	
	
    

}
