package service;

import org.hibernate.Session;

import dao.Tipo_cuentaDao;
import entidades.Tipo_cuenta;

public class Tipo_cuentaService {

	static Tipo_cuentaDao tipo_cuentaDao;

	public static Tipo_cuentaDao getTipo_cuentaDao() {
		return tipo_cuentaDao;
	}

	public static void setTipo_cuentaDao(Tipo_cuentaDao tipo_cuentaDao) {
		Tipo_cuentaService.tipo_cuentaDao = tipo_cuentaDao;
	}
	
	public Tipo_cuenta getTipoCuenta(int id) {
		return tipo_cuentaDao.getTipoCuenta(id);
	}

	public Tipo_cuentaService() {
		super();
		// TODO Auto-generated constructor stub
	}

}
