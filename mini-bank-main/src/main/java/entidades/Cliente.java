package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{

	//Implementar serializable
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="id_usuario")
	private int id_usuario;
	@Column(name="dni")
	private String dni;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="telefono")
	private String telefono;
	@Column(name="email")
	private String email;
	@Column(name="sexo")
	private char sexo;
	@Column(name="nacionalidad")
	private String nacionalidad;
	@Column(name="direccion")
	private String direccion;
	@Column(name="localidad")
	private String localidad;
	@Column(name="provincia")
	private String provincia;
	@Column(name="fecha_nacimiento")
	private String fecha_nacimiento;
	@Column(name="eliminado")
	private boolean eliminado;

	public Cliente()
	{}
	
	public Cliente(int id_usuario, String dni, String nombre, String apellido, String telefono, String email, char sexo,
			String nacionalidad, String direccion, String localidad, String provincia, String fecha_nacimiento) {
		super();
		this.id_usuario = id_usuario;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fecha_nacimiento = fecha_nacimiento;
		this.eliminado = false;
	}

	public Integer getId() {
		return id;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", id_usuario=" + id_usuario + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", sexo=" + sexo
				+ ", nacionalidad=" + nacionalidad + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
}
