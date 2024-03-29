package pe.edu.idat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_pedidos_menus")
public class Detalle_Pedido_Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "acompanamientos", length = 80)
    private String acompanamientos;

    
  
	//muchos a uno detalle a un pedido
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pedidoID", insertable= false, updatable= false)
	private Pedido pedido;

	@Column(name="pedidoID" , nullable = false)
	private Integer pedidoID;
	
	// muchos detalles a un menu
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "menuID", insertable= false, updatable= false)
	private Menu menu;

	@Column(name="menuID" , nullable = false)
	private Integer menuID;

	public Detalle_Pedido_Menus() {
		super();
	}

	public Detalle_Pedido_Menus(Integer idDetalle, Integer cantidad, String acompanamientos, Integer pedidoID,
			Integer menuID) {
		super();
		this.idDetalle = idDetalle;
		this.cantidad = cantidad;
		this.acompanamientos = acompanamientos;
		this.pedidoID = pedidoID;
		this.menuID = menuID;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getAcompanamientos() {
		return acompanamientos;
	}

	public void setAcompanamientos(String acompanamientos) {
		this.acompanamientos = acompanamientos;
	}

	public Integer getPedidoID() {
		return pedidoID;
	}

	public void setPedidoID(Integer pedidoID) {
		this.pedidoID = pedidoID;
	}

	public Integer getMenuID() {
		return menuID;
	}

	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	
	

}
