package serviceInterfaz;

import java.util.List;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import dao.TransferenciaDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Transferencia;
import entidades.Usuario;

public interface TransferenciaServiceInterfaz {


	public TransferenciaDao getTransferenciaDao();
	
	public void setTransferenciaDao(TransferenciaDao TransferenciaDao);
	
	public void agregarTransferencia(Cuenta cuenta_origen, Cuenta cuenta_destino, float importe, String detalle);
	
	public List<Transferencia> getListaDeTransferenciasByCuenta(Cuenta _cuenta);
	
	public void prueba ();
	
}
