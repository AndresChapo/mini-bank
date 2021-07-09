package service;

import dao.MovimientoDao;
import entidades.Cuenta;
import serviceInterfaz.MovimientoServiceInterfaz;

public class MovimientoService implements MovimientoServiceInterfaz {

	private MovimientoDao movimientoDao;
	private CuentaService cuentaService; 
	private TransferenciaService transferenciaService;
	
	
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
	
	

	public TransferenciaService getTransferenciaService() {
		return transferenciaService;
	}

	public void setTransferenciaService(TransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}

	public boolean sonElMismoTipoDeCuenta(Cuenta cuenta_1, Cuenta cuenta_2) {
		boolean _esValido = false;
		
		if ( cuenta_1.getTipo_cuenta().equals( cuenta_2.getTipo_cuenta() )  ){
			_esValido = true;
		}
		
		return _esValido;
		
	}

	public void generarMovimientos(String TXTadepositar, String TXTcbu, int TXTCuentaOrigenID, String TXTdetalle) {
		
		System.out.println(TXTadepositar);
		System.out.println(TXTcbu);
		System.out.println(TXTCuentaOrigenID);
		System.out.println(TXTdetalle);
		
		Cuenta _cuentaOrigen  = cuentaService.getCuenta(TXTCuentaOrigenID);
		Cuenta _cuentaDestino = cuentaService.getCuentaByCBU(TXTcbu);
		
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
						
						cuentaService.modificarCuenta(_cuentaOrigen);
						cuentaService.modificarCuenta(_cuentaDestino);
						
						
						movimientoDao.agregarMovimiento(_cuentaDestino, TXTdetalle, aDepositar);
						movimientoDao.agregarMovimiento(_cuentaOrigen, TXTdetalle, (aDepositar * -1) );
						
						transferenciaService.prueba();
						
						transferenciaService.agregarTransferencia(_cuentaOrigen, _cuentaDestino, aDepositar, TXTdetalle);
						
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
	
	public void generarMovimientoEnPropiaCuenta (String TXTadepositar, int cuentaOrigen, int cuentaPropiaDestino, String TXTdetalle) {
		Cuenta _cuentaOrigen  = cuentaService.getCuenta(cuentaOrigen);
		Cuenta _cuentaDestino = cuentaService.getCuenta(cuentaPropiaDestino);

		if(_cuentaOrigen != null && _cuentaDestino != null) {
			
			if( sonElMismoTipoDeCuenta(_cuentaOrigen,_cuentaDestino ) ) {
				float aDepositar = Float.parseFloat(TXTadepositar);
				if(aDepositar > 0) {
					float saldoNuevoCuentaOrigen  = (_cuentaOrigen.getSaldo() - aDepositar);
					float saldoNuevoCuentaDestino = (_cuentaDestino.getSaldo() + aDepositar);
					
					if(saldoNuevoCuentaOrigen > 0) {
						//TODO : IMPORTANTE ver como guardar estos objetos
						_cuentaOrigen.setSaldo(saldoNuevoCuentaOrigen);
						_cuentaDestino.setSaldo(saldoNuevoCuentaDestino);
						
						cuentaService.modificarCuenta(_cuentaOrigen);
						cuentaService.modificarCuenta(_cuentaDestino);
						
						movimientoDao.agregarMovimiento(_cuentaDestino, TXTdetalle, aDepositar);
						movimientoDao.agregarMovimiento(_cuentaOrigen, TXTdetalle, (aDepositar * -1) );
						
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
	
	
	
}
