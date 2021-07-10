package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	
@Entity
@Table(name="Movimiento")
public class Movimiento implements Serializable{
	//Implementar serializable
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/*@Column(name="num_cuenta")
	private Integer num_cuenta;*/
	@Column(name="fecha")
	private Date fecha;
	@Column(name="detalle")
	private String detalle;
	@Column(name="importe")
	private float importe;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="num_cuenta")
	private Cuenta cuenta;

	
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movimiento(Cuenta cuenta, Date fecha, String detalle, float importe) {
		super();
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public Integer getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(Integer num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
*/
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCliente() {
		return cuenta;
	}
	
	public void setCliente(Cuenta cuenta) {
		this.cuenta = cuenta;
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

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", fecha=" + fecha + ", detalle=" + detalle + ", importe=" + importe
				+ ", cuenta=" + cuenta + "]";
	}


	
}
