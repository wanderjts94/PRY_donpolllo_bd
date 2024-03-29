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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDusuario")
	private Integer IDusuario;

	@Column(name = "Password", length = 20)
	private String Password;

	@Column(name = "nombre", length = 40)
	private String nombre;

	@Column(name = "Apellidos", length = 40)
	private String Apellidos;

	@Column(name = "direccion", length = 60)
	private String direccion;

	@Column(name = "celular", length = 9)
	private String celular;

	@Column(name = "correoElectronico", length = 30)
	private String correoElectronico;

	@Column(name = "dni", length = 8)
	private String dni;

	@Column(name = "estadocuenta")
	private boolean estadocuenta;

	@JsonManagedReference
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval =true )
	@Fetch(FetchMode.JOIN)
	private List<Ventas> listaventa = new ArrayList<Ventas>();

	public Usuario() {
		super();
	}



	public Usuario(Integer iDusuario, String password, String nombre, String apellidos, String direccion,
			String celular, String correoElectronico, String dni, boolean estadocuenta) {
		super();
		this.IDusuario = iDusuario;
		this.Password = password;
		this.nombre = nombre;
		this.Apellidos = apellidos;
		this.direccion = direccion;
		this.celular = celular;
		this.correoElectronico = correoElectronico;
		this.dni = dni;
		this.estadocuenta = estadocuenta;
	}



	public Integer getIDusuario() {
		return IDusuario;
	}



	public void setIDusuario(Integer iDusuario) {
		this.IDusuario = iDusuario;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		this.Password = password;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getCorreoElectronico() {
		return correoElectronico;
	}



	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public boolean isEstadocuenta() {
		return estadocuenta;
	}



	public void setEstadocuenta(boolean estadocuenta) {
		this.estadocuenta = estadocuenta;
	}



	
	
	
	

}
