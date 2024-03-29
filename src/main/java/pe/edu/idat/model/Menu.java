package pe.edu.idat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuID")
    private Integer menuID;

    @Column(name = "nombre",length = 40)
    private String nombre;

	@Column(name = "tipoproducto", length = 80)
	private String tipoproducto;

    @Column(name = "descripcion",length = 100)
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "stock")
    private Integer stock;

	// HABILITADO o DESHABILITADO
    @Column(name = "estado")
    private Integer estado;
    
    
    // de uno a muchos menu a detalle
  	@JsonManagedReference
  	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval =true )
  	@Fetch(FetchMode.JOIN)
  	private List<Detalle_Pedido_Menus> listadetmenu = new ArrayList<Detalle_Pedido_Menus>();


	public Menu() {
		super();
	}


	public Menu(Integer menuID, String nombre, String tipoproducto, String descripcion, BigDecimal precio,
			Integer stock, Integer estado) {
		super();
		this.menuID = menuID;
		this.nombre = nombre;
		this.tipoproducto = tipoproducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
	}


	public Integer getMenuID() {
		return menuID;
	}


	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipoproducto() {
		return tipoproducto;
	}


	public void setTipoproducto(String tipoproducto) {
		this.tipoproducto = tipoproducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


  	


}
