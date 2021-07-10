<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuentas</title>


<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaCuentas').DataTable();
	});
</script>


</head>
<body>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:body>
    </jsp:body>
    
</t:genericpage>

	<div class="container">
	
	
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Asignar Nueva cuenta</h3>
				<div style="height:50px"></div>	
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
		<h2>Informacion del cliente</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
			
			
				<form  action="AltaCuenta.html" method="post">
					
		<!-- ESTO SOLO SIRVE PARA QUE VIAJE EL ID CLIENTE YPONER HACER EL SAVE(MODIFICADO POR REVOLLO) -->
					<input	type="hidden" class="form-control" name="TXTid"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" value="${cliente_cuenta.getId()}">
					
					<div class="form-row">
				

						<div class="col">
							<label for="LblNombre">Nombre:</label>
							<input readonly class="form-control-plaintext" type="text" name="TXTnombrea"
								id="nombre" aria-describedby="emailHelp" 
								value="${cliente_cuenta.getNombre()}">
						</div>
						<div class="col">
							<label for="LblApellido">Apellido:</label>
							<input type="text" readonly class="form-control-plaintext" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								value="${cliente_cuenta.getApellido()}">
						</div>

					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
							<label for="LblDni">Dni:</label>
							<input type="text" readonly class="form-control-plaintext" name="TXTdni" id="dni"
								aria-describedby="emailHelp"
								value="${cliente_cuenta.getDni()}">
						</div>
						
						
										<div class="col">
							<label for="Tipo de cuenta">Tipo de cuenta:</label>
							<select class="form-control"  id="cuentas" name=CuentasTipo>
							<option value="1">Caja de ahorro pesos</option>
							<option value="2">Caja de ahorro USD</option>
							</select>
						</div>		
						
					</div>
					<div style="height:30px"></div>	
					
					<div class="form-row">
						<div class="col">
							<label for="txtnom">Nombre:</label>
							<input class="form-control" type="text" name="TXTNombreCuenta" id="txtnom" placeholder="Ingrese un nombre a la cuenta" required>
						</div>
						
					</div>
					
							<div style="height:30px"></div>	
					
					<div class="form-row">
						<div class="col">
							<label for="LblMontoInicial">Monto Inicial: $10000</label>
						</div>
						
					</div>
					
					
					
					<div  class="row d-flex justify-content-center"style="position:relative; top:30px">
					
					
					<input type="submit" class="btn btn-success" name="BtnConfirmar" value= "Confirmar">
					
					
					</div>	
					

				</form>
			</div>

		</div>
	</div>
	

</body>
</html>