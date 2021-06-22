<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.22/sc-2.0.3/sp-1.2.1/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.22/sc-2.0.3/sp-1.2.1/datatables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaClientes').DataTable();
	});
</script>

</head>

<body>
	 
	<nav class="navbar navbar-expand-large navbar-light"
		style="background-color: #e3f2fd;"> <a class="navbar-brand" 
		href="#">The Group Five Bank  </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<div class="row">

				<div class="col-md-2">
					<li class="nav-item active"><a class="nav-link"
						href="#">Home <span class="sr-only">(current)</span>
					</a></li>
				</div>




				 
				<div class="col-md-2">

					<a class="dropdown-item"
						href="#">Cuentas</a>

				</div>  

				<div class="col-md-2">
					<li class="nav-item active"><a class="nav-link"
						href="">Salir <span class="sr-only">(current)</span>
					</a></li>
				</div>


			</div>
		</ul>


	</div>
	</nav>
	<div class="container">
 
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Clientes</h3>

			</div>
		</div>

		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-10" style="">
				 
				<div style="height: 50px"></div>
				<table class="table" id="tablaClientes">
					<thead class="table-info">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th scope="col">Numero de cliente</th>
							<th scope="col">Acciones</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						 
						<tr>

							<th scope="row">1</th>
							<td>Nombre</td>
							<td>Apellido</td>
							<td>Dni</td>
 
							<td>
							<a class="btn btn-primary" href="clientesNuevoDatosPersonales.jsp">Nueva Cuenta</a>
							</td>
 
							 
 							<td><a class="btn btn-success"
								href="#">Ver</a></td>
							<td><a class="btn btn-info"
								href="#">Modificar</a></td>
							<td><a class="btn btn-danger"
								href="#">Eliminar</a></td>

						</tr>
 
					</tbody>
				</table>
			</div>

		</div> 

	</div>
</body>

</html>