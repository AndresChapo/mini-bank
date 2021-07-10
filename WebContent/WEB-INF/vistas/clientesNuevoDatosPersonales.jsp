<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="entidades.Cliente"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ClientesNuevos</title>

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



</head>
<body>

 	 
	<nav class="navbar navbar-expand-large navbar-light"
		style="background-color: #e3f2fd;">  
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
						href="index.html">Home <span class="sr-only">(current)</span>
					</a></li>
				</div>
 
				<div class="col-md-2">
					<li class="nav-item active"><a class="nav-link"
						href="irALogin.html">Salir <span class="sr-only">(current)</span>
					</a></li>
				</div>

			</div>
		</ul>
	</div>
	</nav>
	<div class="container">
	
	
	<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Alta Nuevo cliente</h3>
				<div style="height:50px"></div>	
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
		<h2>Ingresar Datos Personales</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
				<form action="ClientesDatosPersonales.html" method="post">
				
				<input	type="hidden" class="form-control" name="TXTidUsuario"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" value="${NuevoUsuario.getId()}">
							
					<div class="form-row">

						<div class="col">
						 <label for="Nombre">Nombre:</label>
							<input type="text" class="form-control" name="TXTnombre"
								id="nombre" aria-describedby="emailHelp" placeholder="Nombre" >
						</div>
						<div class="col">
						 <label for="Apellido">Apellido:</label>
							<input type="text" class="form-control" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Apellidos" >
						</div>
						

					</div>
					
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
						 <label for="Dni">Dni:</label>
							<input type="text" class="form-control" name="TXTdni" id="dni"
								aria-describedby="emailHelp" placeholder="DNI" >
						</div> 
						
						<div class="col">
						 <label for="Apellido">Nacionalidad:</label>
							<input type="text" class="form-control" name="TXTnacionalidad"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Nacionalidad" >
						</div>
						
						<div class="col"> 
						</div>
						 
						
					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
						<label for="contraseña">Fecha de Nacimiento:</label>
							<input type="date" class="form-control" name="TXTfecha" id="nacimiento"
								aria-describedby="emailHelp" placeholder="DD/MM/AAAA" >
						</div>
					
						<div class="col">
							<label for="sexo">Sexo:</label>
							<select class="form-control"  id="sexo" name="TXTsexo">
							<option value="M">Masculino</option>
							<option value="F">Femenino</option>
							</select>
						</div>
					</div>
					<div class="form-row">

						<div class="col">
							<label for="provincia">Provincia:
							</label> <select class="form-control"
								id="provincia" name=TXTprovincia>
								<option value="CABA">CABA</option>
								<option value="Buenos Aires">Buenos Aires</option>
								<option value="Catamarca">Catamarca</option>
								<option value="Chaco">Chaco</option>
								<option value="Chubut">Chubut</option>
								<option value="Cordoba">Cordoba</option>
								<option value="Corrientes">Corrientes</option>
								<option value="Entre rios">Entre rios</option>
								<option value="Formosa">Formosa</option>
								<option value="Jujuy">Jujuy</option>
								<option value="La Pampa">La Pampa</option>
								<option value="La rioja">La rioja</option>
								<option value="Mendoza">Mendoza</option>
								<option value="Misiones">Misiones</option>
								<option value="Neuquen">Neuquen</option>
								<option value="Rio Negro">Rio Negro</option>
								<option value="Salta">Salta</option>
								<option value="San Juan">San Juan</option>
								<option value="San Luis">San Luis</option>
								<option value="Santa fe">Santa fe</option>
								<option value="Santiago del estero">Santiago del estero</option>
								<option value="Tierra del fuego">Tierra del fuego</option>
								<option value="Tucuman">Tucuman</option>
							
								
								
							</select>
						</div>
						<div class="col">
						<label for="contraseña">Localidad:</label>
							<input type="text" class="form-control" name="TXTlocalidad"
								id="localidad" aria-describedby="emailHelp"
								placeholder="localidad" >
						</div>

					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
						<label for="contraseña">Direccion:</label>
							<input type="text" class="form-control" name="TXTdomicilio" id="domicilio"
								aria-describedby="emailHelp" placeholder="Domicilio" >
						</div>
						
					</div>
					<div style="height: 30px"></div>
					

					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
						<label for="contraseña">Telefono:</label>
							 <input	type="text" class="form-control" name="TXTtelefono"
								id="telefono" aria-describedby="emailHelp"
								placeholder="telefono" >
						</div>
					
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
						<label for="contraseña">Email:</label>
							 <input	type="text" class="form-control" name="TXTcorreo"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" >
						</div>
					
					</div>
				 
					<div  class="row d-flex justify-content-center"style="position:relative; top:30px">
					  
					<input type="submit" class="btn btn-primary" name="BtnGuardar" value= "Guardar">
					
					<a href="listadoClientes.html" class="btn btn-danger">Cancelar</a>
					</div>
				
		

				</form>
			</div>

		</div>
	
	</div>
</body>
</html>