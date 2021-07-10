package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import daoInterfaz.TransferenciaDaoInterfaz;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.Transferencia;

public class TransferenciaDao implements TransferenciaDaoInterfaz{

	private static ConfigHibernate ch;
	private Transferencia transferencia;
	
	public TransferenciaDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigHibernate getCh() {
		return ch;
	}

	public void setCh(ConfigHibernate ch) {
		this.ch = ch;
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	@Override
	public void agregarTransferencia(Cuenta cuenta_origen, Cuenta cuenta_destino, float importe, String detalle) {
    	Session session = ch.getConexion();
		if(detalle.isEmpty()) {
			detalle = "";
		}
		
		Date hoy = Date.valueOf(LocalDate.now());

		transferencia.setImporte(importe);
		transferencia.setDetalle(detalle);
		transferencia.setCuenta_destino(cuenta_destino);
		transferencia.setCuenta_origen(cuenta_origen);
		transferencia.setFecha(hoy);
		
		session.beginTransaction();
		session.save(transferencia);
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

	@Override
	public void modificarTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transferencia traerTransferencia(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
