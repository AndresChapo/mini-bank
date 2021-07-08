package service;

import dao.MovimientoDao;
import entidades.Cuenta;
import serviceInterfaz.MovimientoServiceInterfaz;

public class MovimientoService implements MovimientoServiceInterfaz {

	private MovimientoDao movimientoDao;
	private CuentaService cuentaService; 
	
	
	public MovimientoDao getMovimientoDao() {
		return movimientoDao;
	}

	public void setMovimientoDao(MovimientoDao movimientoDao) {
		this.movimientoDao = movimientoDao;
	}

	public CuentaService getCuentaService() {
		return cuentaService;
	}

	public void setCuentaService(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}

	public boolean sonElMismoTipoDeCuenta(Cuenta cuenta_1, Cuenta cuenta_2) {
		boolean _esValido = false;
		
		if ( cuenta_1.getTipo_cuenta().equals( cuenta_2.getTipo_cuenta() )  ){
			_esValido = true;
		}
		
		return _esValido;
		
	}

	public void generarMovimientos(String TXTadepositar, String TXTcbu, String TXTCuentaOrigenID, String TXTdetalle) {
		
		Cuenta _cuentaOrigen  = getCuentaByCBU(TXTcbu);
		Cuenta _cuentaDestino = cuentaService.getCuenta(Integer.parseInt(TXTCuentaOrigenID));
		
		// si ambas cuentas existen
		if(_cuentaOrigen != null && _cuentaDestino != null) {

			float aDepositar = Float.parseFloat(TXTadepositar);
			if( sonElMismoTipoDeCuenta(_cuentaOrigen,_cuentaDestino ) ) {
			
				if(aDepositar > 0) {
					
					float saldoNuevoCuentaOrigen  = (_cuentaOrigen.getSaldo() - aDepositar);
					float saldoNuevoCuentaDestino = (_cuentaDestino.getSaldo() + aDepositar);
				
					if(saldoNuevoCuentaOrigen > 0) {
						//TODO : IMPORTANTE ver como guardar estos objetos
						_cuentaOrigen.setSaldo(saldoNuevoCuentaOrigen);
						_cuentaDestino.setSaldo(saldoNuevoCuentaDestino);
						
						movimientoDao.agregarMovimiento(_cuentaOrigen.getNum_cuenta(), TXTdetalle, aDepositar);
						movimientoDao.agregarMovimiento(_cuentaOrigen.getNum_cuenta(), TXTdetalle, (aDepositar * -1) );
						
					} else {
						// TODO  lanzar un error porque esta tratando de transferir mas de lo que tiene.
					}
					
				} else {
					// TODO  lanzar un error porque quiere transferir un numero negativo.
				}
			} else {
				// TODO  lanzar error no son el mismo tipo de cuenta.
			}
			
		} else {
			// TODO  lanzar error no existe la cuenta con el cbu ingresado (probablemente)
			// tambien puede suceder y hay que checkear que el id de la cuenta que estaba tambien esté
		}
		
	}
	
	
	public Cuenta getCuentaByCBU(String cbu) {
		
		// todo usar bean?
		Cuenta cuenta = new Cuenta();
		
		
		
		return cuenta;
		
	}

	
}
