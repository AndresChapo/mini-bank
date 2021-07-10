<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>

<!-- SCRIPTS JS -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaClientes').DataTable();
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
				<h3 class="display-4 text-info">Clientes</h3>

			</div>
		</div>


		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-12" style="">

				<div style="height: 50px"></div>
				<table class="table" id="tablaClientes">
					<thead class="table-info">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">DNI</th>
							<th scope="col">Fecha nacimiento</th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>


						<c:forEach items="${listaClientes}" var="cliente">
							<tr>
								<th scope="row">${cliente.id }</th>
								<td>${cliente.nombre } ${cliente.apellido }</td>
								<td>${cliente.dni }</td>
								<td>${cliente.fecha_nacimiento }</td>

								<td style="width: 131px;"><a class="btn btn-primary"
									href="NuevoCuenta.html?id=${cliente.id}">Nueva Cuenta</a></td>

								<td><a class="btn btn-success" 
								    href="verCliente.html?id=${cliente.id}">Ver</a></td>

								<td><a class="btn btn-success" 
								    href="verCuentas.html?id_cliente=${cliente.id}">Ver cuentas</a></td>

								<td><a class="btn btn-info"
									href="modificacionCliente.html?id=${cliente.id}">Modificar</a></td>

								<td><a class="btn btn-danger"
									href="eliminarCliente.html?id=${cliente.id}">Eliminar</a></td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>

		</div>

	</div>
</body>

</html>