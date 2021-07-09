package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Transferencia;

public class TransferenciaDao {

	private static ConfigHibernate ch;
	
	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	public void agregarTransferencia (Cuenta cuenta_origen, Cuenta cuenta_destino, float importe, String detalle) {
    	Session session = ch.getConexion();
		if(detalle.isEmpty()) {
			detalle = "";
		}
		
		Date hoy = Date.valueOf(LocalDate.now());

		Transferencia _transferencia = new Transferencia(detalle, importe, hoy, cuenta_origen, cuenta_destino);
		session.beginTransaction();
		session.save(_transferencia);
    	session.getTransaction().commit();

	}
	
	public List<Transferencia> getListaDeTransferenciasByCuenta(Cuenta cuenta) {
		Session session = ch.getConexion();
		String hql = "FROM Transferencia WHERE cuenta_origen = :cuenta or cuenta_destino = :cuenta";
		Query q = session.createQuery(hql);
		q.setParameter("cuenta", cuenta);
		List<Transferencia> listaTransferencias = q.list();    
		
		for (Transferencia tran : listaTransferencias ) {
		    System.out.println(tran.toString());
		}

		return listaTransferencias; 
	}
	
}
