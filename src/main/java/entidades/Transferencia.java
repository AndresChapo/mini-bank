package entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transferencia")
public class Transferencia implements Serializable{

	//Implementar serializable
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="detalle")
	private String detalle;
	@Column(name="importe")
	private float importe;
	@Column(name="fecha")
	private Date fecha;


	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="cuenta_origen")
	private Cuenta cuenta_origen; 
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="cuenta_destino")
	private Cuenta cuenta_destino; 


	public Transferencia()
	{}


	public Transferencia(String detalle, float importe, Date fecha, Cuenta cuenta_origen, Cuenta cuenta_destino) {
		super();
		this.detalle = detalle;
		this.importe = importe;
		this.fecha = fecha;
		this.cuenta_origen = cuenta_origen;
		this.cuenta_destino = cuenta_destino;
	}




	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", detalle=" + detalle + ", importe=" + importe + ", cuenta_origen="
				+ cuenta_origen + ", cuenta_destino=" + cuenta_destino + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public float getImporte() {
		return importe;
	}


	public void setImporte(float importe) {
		this.importe = importe;
	}


	public Cuenta getCuenta_origen() {
		return cuenta_origen;
	}


	public void setCuenta_origen(Cuenta cuenta_origen) {
		this.cuenta_origen = cuenta_origen;
	}


	public Cuenta getCuenta_destino() {
		return cuenta_destino;
	}


	public void setCuenta_destino(Cuenta cuenta_destino) {
		this.cuenta_destino = cuenta_destino;
	}
	

	
}
