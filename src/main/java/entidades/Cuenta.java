package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable{
	//Implementar serializable
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="num_cuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num_cuenta;
	@Column(name="id_cliente")
	private Integer id_cliente;
	@Column(name="tipo_cuenta")
	private Integer tipo_cuenta;
	@Column(name="nombre")
	private String nombre;
	@Column(name="cbu")
	private String cbu;
	@Column(name="saldo")
	private float saldo;
	@Column(name="fecha_creacion")
	private String fecha_creacion;
	
	public Cuenta(Integer id_cliente, Integer tipo_cuenta, String nombre, String cbu,
			float saldo, String fecha_creacion) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_cuenta = tipo_cuenta;
		this.nombre = nombre;
		this.cbu = cbu;
		this.saldo = saldo;
		this.fecha_creacion = fecha_creacion;
	}

	public Integer getId() {
		return num_cuenta;
	}

	public void setId(Integer num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(Integer tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	@Override
	public String toString() {
		return "Cuenta [num_cuenta=" + num_cuenta + ", id_cliente=" + id_cliente + ", tipo_cuenta=" + tipo_cuenta + ", nombre=" + nombre
				+ ", cbu=" + cbu + ", saldo=" + saldo + ", fecha_creacion="
				+ fecha_creacion + "]";
	}

}
