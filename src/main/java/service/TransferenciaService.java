package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.TransferenciaDao;
import entidades.Cuenta;
import entidades.Transferencia;

public class TransferenciaService {

	static TransferenciaDao TransferenciaDao;

	public TransferenciaDao getTransferenciaDao() {
		return TransferenciaDao;
	}

	public void setTransferenciaDao(TransferenciaDao TransferenciaDao) {
		this.TransferenciaDao = TransferenciaDao;
	}
	
	public void agregarTransferencia(Cuenta cuenta_origen, Cuenta cuenta_destino, float importe, String detalle) {
		this.TransferenciaDao.agregarTransferencia(cuenta_origen, cuenta_destino, importe, detalle);
	}
	
	public List<Transferencia> getListaDeTransferenciasByCuenta(Cuenta _cuenta) {
		return this.TransferenciaDao.getListaDeTransferenciasByCuenta(_cuenta);
	}
	
	public void prueba () {
		System.out.println("Hola");
	}
}
