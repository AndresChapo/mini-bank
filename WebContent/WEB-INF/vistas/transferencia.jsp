<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
<head>
<meta charset="UTF-8">
<title>clienteNuevoDatospersonales</title>

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
		$('#tablaCuentas').DataTable();
	});
</script>




</head>
<body>

<script>
function myFunction() {
  var checkBox = document.getElementById("myCheck");
  var select = document.getElementById("cuentaPropia");
  var TXTcbu = document.getElementById("TXTcbu");
  var LBLcbu = document.getElementById("LBLcbu");
  var LBLcuentaPropia = document.getElementById("LBLcuentaPropia");
  
  if (checkBox.checked == true){
	  select.style.display = "block";
	  LBLcuentaPropia.style.display = "block";
	  TXTcbu.style.display = "none";
	  LBLcbu.style.display = "none";
  } else {
	  select.style.display = "none";
	  LBLcuentaPropia.style.display = "none";
	  LBLcbu.style.display = "block";
	  TXTcbu.style.display = "block";
  }
}
</script>

	 
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
						href="#">Home <span class="sr-only">(current)</span>
					</a></li>
				</div>
 
				<div class="col-md-2">
					<li class="nav-item active"><a class="nav-link"
						href="#">Salir <span class="sr-only">(current)</span>
					</a></li>
				</div>

			</div>
		</ul>
	</div>
	</nav>
	<div class="container">

		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Transferir dinero</h3>
				<div style="height: 50px"></div>
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
			<!-- TODO REVISAR QUE ESTO SEA ASI REALMENTE */ -->  
				<form action="ServletTransferencia" method="get">
					
					<div class="form-row mb-1">
						<div class="col" >
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input" id="myCheck" onclick="myFunction()">
								<label class="form-check-label" for="myCheck"> Es una cuenta propia</label>
							</div>
						</div>
					</div>
					
					<div class="form-row mb-2">
						<div class="col" >
							<label id="LBLcuentaPropia" for="cuenta">Cuenta:</label> 
							<select class="form-control" style="display: none;"
								id="cuentaPropia" name=cuenta>
								<c:forEach items="${listaDeCuentasPropias}" var="cuentaPropia">
								  <option value="${cuentaPropia.num_cuenta}">${cuentaPropia.num_cuenta} - ${cuentaPropia.saldo}</option>
								</c:forEach>
							</select>
							<label id="LBLcbu" for="cuenta">CBU al que va a depositar:</label> 
							<input type="number" class="form-control" name="TXTcbu"
								id="TXTcbu" aria-describedby="emailHelp" placeholder="Ingrese un CBU"
								required>
						</div>
						<div class="col">
							<label for="cuenta">Saldo:</label>
							<input type="number" class="form-control" name="TXTsaldo" readonly
								id="nombre" aria-describedby="emailHelp" placeholder="$25.000" value="$25.000"
								required>
						</div>
						
					</div>
					<div class="form-row mb-2" >
						<div class="col " >
							
						</div>
					</div>

					<div class="form-row mb-2">
						<div class="col">
							<input type="number" class="form-control" name="TXTadepositar"
								id="nombre" aria-describedby="emailHelp" placeholder="Ingrese el importe a depositar. Ej: 2500"
								required>
						</div>
						<div class="col">
						</div>
					</div>

					

					<div class="row d-flex justify-content-center"
						style="position: relative; top: 30px">



						<a class="btn btn-primary" href="clientesNuevoDireccion.jsp">Depósitar</a>
					</div>

					
				</form>
			</div>

		</div>
	</div>
	
</body>
</html>