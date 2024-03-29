package pe.edu.idat.model;

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
@Table(name = "empleado")
public class Empleados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleadoID")
	private Integer empleadoID;

	@Column(name = "nombre", length = 40)
	private String nombre;
	
	@Column(name = "Apellidos", length = 40)
	private String Apellidos;

	@Column(name = "rol", length = 25)
	private String rol;
	
	@Column(name = "direccion", length = 60)
	private String direccion;
	
	@Column(name = "DNI", length = 8)
	private String DNI;

	@Column(name = "telefono", length = 9)
	private String telefono;
	
    @Column(name = "Edad")
    private Integer Edad;

	@Column(name = "correoElectronico", length = 50 )
	private String correoElectronico;

	@Column(name = "disponibleParaDelivery")
	private boolean  disponibleParaDelivery;
	
	
	//empleado a pedido
	@JsonManagedReference
	@OneToMany(mappedBy = "empleadoP", cascade = CascadeType.ALL, orphanRemoval =true )
	@Fetch(FetchMode.JOIN)
	private List<Pedido> listapedido = new ArrayList<Pedido>();
	
	
	//empleado a venta
	@JsonManagedReference
	@OneToMany(mappedBy = "empleadoV", cascade = CascadeType.ALL, orphanRemoval =true )
	@Fetch(FetchMode.JOIN)
	private List<Ventas> listaventa = new ArrayList<Ventas>();


	
	public Empleados() {
		super();
	}


	public Empleados(Integer empleadoID, String nombre, String apellidos, String rol, String direccion, String dNI,
			String telefono, Integer edad, String correoElectronico, boolean disponibleParaDelivery) {
		super();
		this.empleadoID = empleadoID;
		this.nombre = nombre;
		this.Apellidos = apellidos;
		this.rol = rol;
		this.direccion = direccion;
		this.DNI = dNI;
		this.telefono = telefono;
		this.Edad = edad;
		this.correoElectronico = correoElectronico;
		this.disponibleParaDelivery = disponibleParaDelivery;
	}


	public Integer getEmpleadoID() {
		return empleadoID;
	}


	public void setEmpleadoID(Integer empleadoID) {
		this.empleadoID = empleadoID;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		this.Apellidos = apellidos;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		this.DNI = dNI;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Integer getEdad() {
		return Edad;
	}


	public void setEdad(Integer edad) {
		this.Edad = edad;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public boolean isDisponibleParaDelivery() {
		return disponibleParaDelivery;
	}


	public void setDisponibleParaDelivery(boolean disponibleParaDelivery) {
		this.disponibleParaDelivery = disponibleParaDelivery;
	}
	
	


	
	
}
