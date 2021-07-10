package daoInterfaz;

import entidades.Cuenta;
import entidades.Transferencia;

public interface TransferenciaDaoInterfaz {
	
	public void agregarTransferencia (Cuenta cuenta_origen, Cuenta cuenta_destino, float importe, String detalle);
	
	public void modificarTransferencia(Transferencia transferencia);
	
	public void eliminarTransferencia(Transferencia transferencia);
	
	public Transferencia traerTransferencia(int id);

}
