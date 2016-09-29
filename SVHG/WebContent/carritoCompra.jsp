<!DOCTYPE html >
<html>
<head>
	<title>Carrito</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/price-range.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link rel="shortcut icon" href="imagesOut/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="imagesOut/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="imagesOut/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="imagesOut/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="imagesOut/ico/apple-touch-icon-57-precomposed.png">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/validaciones.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script	
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	</script>
	<!-- LLAMA A LOS METODOS QUE SE UTILIZAN PARA LA INTERFAZ Y LOS SERVICIOS DE UBIGEO -->
	<script src="js/ajax_pedido.js"></script>
	<!-- VALIDACIONES APLICADAS A ESTA PAGINA -->
	<script src="js/validarTelefono.js"></script>
	
	<script src="https://js.braintreegateway.com/web/3.3.0/js/client.min.js"></script>
	<script src="https://js.braintreegateway.com/web/3.3.0/js/paypal.min.js"></script>
	
</head>
<body onload="cargarDep();">
	<jsp:include page="includeOut/header.jsp"></jsp:include>
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="index.jsp">Inicio</a></li>
					<li class="active">Carrito de Compra</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu" style="text-align: center;">
							<td class="image">Producto</td>
							<td class="description"></td>
							<td class="price">Precio</td>
							<td class="quantity">Cantidad</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody id="productosCarrito">
						
 						<tr>
							<td class="cart_product"><a href=""><img
									src="imagesOut/cart/one.png" alt=""></a></td>
							<td class="cart_description"
								style="vertical-align: middle; text-align: center;">
								<h4>
									<a>Colorblock Scuba</a>
								</h4>
							</td>
							<td class="cart_price"
								style="vertical-align: middle; text-align: center;">
								<p>S/.59.00</p>
							</td>
							<td class="cart_quantity" style="vertical-align: middle; text-align: center;">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="#"  onclick="agregar(cantidad.value,desc.value);"> + </a> 
									<input type="hidden" value="cantidad" id="desc"> 
									<input  onchange="cambiar(cantidad.value,desc.value);" onkeypress="return solonumerosCarr(event)" name="quantity" maxlength="2" class="cart_quantity_input" type="text" value="1" size="2" id="cantidad"> 
									<a class="cart_quantity_down" href="#" onclick="disminuir(cantidad.value,desc.value);"> - </a>
								</div>
							</td>
							<td class="cart_total"
								style="vertical-align: middle; text-align: center;">
								<p class="cart_total_price">S/.59.00</p>
							</td>
							<td class="cart_delete"
								style="vertical-align: middle; text-align: center;"><a
								class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="heading">
						<h3>Seleccione su tipo de Entrega del Pedido</h3>
					</div>
					<br>
					<div class="chose_area">
						<ul class="user_option">
							<li>
								<div class="radio">
									<label><input type="radio"  name="entrega" value="local" checked>Recoger en el Local de la Empresa</label>
								</div>
							</li>
							<li>
								<div class="radio">
									<label> <input type="radio"  name="entrega" value="casa">Envio a domicilio</label>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Sub Total <span>$59</span></li>
							<li>Descuento<span>$2</span></li>
							<li style="background-color: #ff8000; color: white;">Total <span>$61</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<br>
	<section id="do_action">
		<div class="container">
			<!-- FORMULARIO 1-->
			<div id="formuCasa" style="display: none;">
				<div class="col-sm-12 col-xs-12">
					<h3>Direccion de Envio:</h3>
					<br>
					<form class="form-horizontal" action="" method="" id="form1">
						<div class="form-group">
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Tipo de Direccion</label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<select class="form-control">
									<option>Avenida</option>
									<option>Jiron</option>
									<option>Calle</option>
								</select>
							</div>
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Direccion </label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<input type="text" name="direccion" id="direccion" maxlength="95" class="form-control" onkeypress=" return validarn(event)">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Referencia </label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<input class="form-control" maxlength="95" name="referencia" onkeypress=" return validarn(event)">
							</div>
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Departamento</label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<select class="form-control" name="departamento"
									id="departamento" onchange="cargarPros(this.value);">
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Provincia</label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<select class="form-control" name="provincia" id="provincia" onchange="cargarDist(this.value);">
									<option value="0"> -- SELECCIONAR -- </option>
								</select>
							</div>
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Distrito </label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<select class="form-control" id="distrito" name="distrito" >
									<option value="0"> -- SELECCIONAR -- </option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos">Telefono Celular</label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<input type="text" name="telefono1" id="telefono1" maxlength="9" class="form-control"  onkeyup="validarTelefono(this.value,deserror1.value);" onkeypress="return solonumeros(event);">
								<b id="error1" style="color:red;"></b><input type="hidden" id="deserror1" value="error1">
							</div>
							<div class="col-xs-2 col-sm-2">
								<label id="titulitos"  >Otro Telefono </label>
							</div>
							<div class="col-xs-4 col-sm-4">
								<input class="form-control" maxlength="9" name="telefono2" id="telefono2"  onkeyup="validarTelefono(this.value,deserror2.value);" onkeypress="return solonumeros(event);">
								<b id="error2" style="color:red;"></b><input type="hidden" id="deserror2" value="error2">
							</div>
						</div>
					</form>
					<div class="form-group">
						<div class="col-xs-3 col-sm-3 col-xs-offset-8 col-sm-offset-8">
							<button id="boton3" class="btn btn-primary btn-md">Continuar</button>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group step1">
				<div class="col-xs-3 col-sm-3 col-xs-offset-8 col-sm-offset-8">
					<button id="boton1" class="btn btn-primary btn-md">Continuar</button>
				</div>
			</div>
			<div class="step2" style="display: none;">
				<!-- CUADRO FECHAS-->
				<div
					style="border: 2px solid #ffbf00; border-radius: 8px; padding: 15px; height: 150px;"
					class="col-xs-4 col-sm-4">
					<p>Fechas disponibles</p>
					<form>
						<div class="radio">
							<input type="radio" name="fecha"> 25/10/16 
						</div>
						<div class="radio">
							<input type="radio" name="fecha"> 26/10/16
						</div>
						<div class="radio">
							 <input type="radio" name="fecha"> 28/10/16
						</div> 
					</form>
				</div>
				<!-- SEGUNDO CUADRO-->
				<div class="col-xs-2 col-sm-2"></div>
				<div
					style="border: 2px solid #ffbf00; border-radius: 8px; padding: 15px; height: auto;"
					class="col-xs-6 col-sm-6">
					<label>Sub-Total :</label>&nbsp; <label>S/.160.00</label><br>
					<label class="pagenv">Pag. Envio :</label>&nbsp; <label id="valEnv"
						class="pagenv">----</label><br> <label>Descuento :</label>&nbsp;
					<label>S/.0.00</label> <br> <label>Tot. Pagar :</label>&nbsp;
					<label>S/.170.00</label>
				</div>
			</div>
			<!-- DIRECCION DE ENVIO -->
			<div class="step3" style="display: none;">
				<div class="col-xs-12 col-sm-12 " style="margin-top: 25px;"
					id="infoDirEnv">
					<h3 id="titInDir">Direccion de Envio</h3>
					<button type="button" class="btn btn-default" id="botonCambDir" data-toggle="modal" data-target="#ModalModDir">Cambiar direccion</button>
					<div class="col-xs-8 col-sm-8">
						<label id="mosNom"></label><br> <label id="mosDir"></label><br>
						<label id="mosDis"></label><br> <label id="mosTel"></label>
					</div>
				</div>
			</div>
			<!-- TIPO DE PAGO-->
			<br> <br>
			<div class="step2" style="display: none;">
				<div class="col-xs-12 col-sm-12" style="margin-top: 25px;">
					<div class="col-xs-6 col-sm-6">
						<p>
						<h3>Tipo de Pago</h3>
						</p>
						<form>
							<div class="radio">
								<input type="radio" name="tipoPago"  checked >Contra-Entrega
							</div>
							<div class="radio">
								<input type="radio" name="tipoPago" value="tarjeta">Tarjeta
							</div>
						</form>
					</div>
					<div class="col-xs-4 col-sm-4">
						
						
						<form id="myContainer"method="POST" action="https://www.sandbox.paypal.com/checkoutnow?token=p73MH-N0eKjV7C0h7PnwVH9JUcn3AfyocT55SFLyK0IgZiTllV_CM4tJFPm" ></form>
						<script>
							window.paypalCheckoutReady = function() {
				
								      paypal.checkout.setup("YSKPUBXAHFT5L", {
								          
								          environment: 'sandbox',
								          buttons: 'myContainer'
								        });
							};
						</script>
						<script src="//www.paypalobjects.com/api/checkout.js" async></script>
					</div>
				</div>
			</div>
			<!-- SEGUNDO BOTON CONTINUAR -->
			<div class="form-group step2" style="display: none;">
				<div class="col-xs-3 col-sm-3 col-xs-offset-8 col-sm-offset-8">
					<button id="boton2" class="btn btn-primary">Continuar</button>
				</div>
			</div>
		</div>
	</section>
	<!--/#do_action-->
	<jsp:include page="includeOut/footer.jsp"></jsp:include>
	<jsp:include page="modals/modalGenerarPedido.jsp"></jsp:include>
	<jsp:include page="modals/modalRegistroTarjeta.jsp"></jsp:include>
</body>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>

<script>
	function pagar(){
		event.preventDefault();
		
		window.open("","windowName",
        "width=400,height=600,scrollbars=no");
		
	}

</script>

</html>