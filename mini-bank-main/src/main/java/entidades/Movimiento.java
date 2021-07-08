package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name="num_cuenta")
	private Integer num_cuenta;
	@Column(name="fecha")
	private String fecha;
	@Column(name="detalle")
	private String detalle;
	@Column(name="importe")
	private float importe;
	
	public Movimiento(Integer num_cuenta, String fecha, String detalle, float importe) {
		super();
		this.num_cuenta = num_cuenta;
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

	public Integer getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(Integer num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
		return "Movimiento [id=" + id + ", num_cuenta=" + num_cuenta + ", fecha=" + fecha + ", detalle=" + detalle
				+ ", importe=" + importe + "]";
	}
	
}
