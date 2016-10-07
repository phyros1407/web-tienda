
<%@page import="beans.ProductoBean"%>
<%@page import="java.util.ArrayList"%>
<%if(session.getAttribute("nombreApellidoPersonaAdmi")==null ) {
                  request.getRequestDispatcher("home.jsp").forward(request, response);
                  }
                  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<!-- *******************************PARA MODAL  ******************************* -->		
<%@ include file="include/head.jsp"%>
<script type="text/javascript" src="./js/validaciones.js" charset="UTF-8"></script>

<!-- END HEAD -->
<%
	ArrayList<ProductoBean> productos = (ArrayList<ProductoBean>) request.getAttribute("productos");
%>
<!-- inicio del Floro del menú -->
<body

	class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
	<!-- BEGIN HEADER -->
	<%@ include file="include/headSideBar.jsp"%>
	<!-- END HEADER -->
	<!-- BEGIN HEADER & CONTENT DIVIDER -->
	<div class="clearfix"></div>
	<!-- END HEADER & CONTENT DIVIDER -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<%@ include file="include/sidebar.jsp"%>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<!-- BEGIN CONTENT BODY -->
			<div class="page-content">
				<!-- BEGIN PAGE HEADER-->
				<!-- BEGIN THEME PANEL -->
				<!-- END THEME PANEL -->
				<!-- BEGIN PAGE BAR -->
				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li><a href="inicio.jsp">Inicio</a> <i class="fa fa-circle"></i>
						</li>
						<li><span>Reporte de Utilidades</span></li>
					</ul>
					<div class="page-toolbar">
						<div id="dashboard-report-range"
							class="pull-right tooltips btn btn-sm" data-container="body"
							data-placement="bottom"
							data-original-title="Change dashboard date range">
							<i class="icon-calendar"></i>&nbsp; <span
								class="thin uppercase hidden-xs"></span>&nbsp; <i
								class="fa fa-angle-down"></i>
						</div>
					</div>
				</div>

<!-- fin del Floro del menú -->
<!----------------------------------------- script------------------------------------------------>
<script type="text/javascript">

	function cambiarProducto(){
		var x=document.getElementById("categoria").value;
		var a;
		alert(x);
		<%int p;%>
		if(x=='SUSPENSI'){ 
			a=1;
		}
		if(x=='FUERZA'){ 
			a=2;
		}
		if(x=='AGILIDAD'){ 
			a=3;
		}
		if(x=='COORDINACION'){ 
			a=4;
		}
		if(x=='POTENCIA'){ 
			a=5;
		}
		
		if(x=='OTROS'){ 
			a=6
		}
			

		if(a==1){
		document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==1){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
		}
		if(a==2){
			document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==2){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
			}
		if(a==3){
			document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==3){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
			}
		if(a==4){
			document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==4){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
			}
		if(a==5){
			document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==5){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
			}
		if(a==6){
			document.getElementById("demo").innerHTML = "<label for=sel1>Seleccione Producto:</label><br><select name=producto id=producto class=form-control><%for (int i = 0; i < productos.size(); i++) {%><%if(productos.get(i).getIdCategoria()==6){%><option><%=productos.get(i).getNombre()%></option><%} %><%}%></select>";
			}
	}
	</script>
<!----------------------------------------- script------------------------------------------------>
<!----------------------------------------- BODY------------------------------------------------>
<form>
			<div class="row">
				<div class="col-sm-11">
					<h1>Reporte de Ventas</h1>
				</div>
			</div>
				<br>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
					<!-- onchange="cambiarProducto()" -->
						<label for="sel1">Seleccione Categoria:</label>
						<select onchange="cambiarProducto()"  name="categoria" class="form-control" id="categoria">
							<option value="">Seleccione</option>
							<option value="SUSPENSI">SUSPENSI</option>
							<option value="FUERZA">FUERZA</option>
							<option value="AGILIDAD">AGILIDAD</option>
							<option value="COORDINACION">COORDINACION</option>
							<option value="POTENCIA">POTENCIA</option>
							<option value="OTROS">OTROS</option>
						</select>
					</div>
				</div>
				
				<div class="col-sm-1"></div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="sel1">Seleccione A�o Inicio</label>
						<select class="form-control" id="selFecha" name="selFecha">
							<option>2011</option>
							<option>2012</option>
							<option>2013</option>
							<option>2014</option>
							<option>2015</option>
							<option>2016</option>
							<option>2017</option>
						</select>
					</div>
				</div>
			</div>
				<br>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						
<!--------------------------------------- select producto--------------------------------------- -->
					
						<div id="demo"></div>
<!--------------------------------------- select producto--------------------------------------- -->

					</div>
				</div>
				<div class="col-sm-1"></div>
				
			
			</div>
				<br>
			<div class="row">
				<div class="col-sm-3">
					<a href="<%=request.getContextPath() %>/reporte.jsp" class="btn btn-warning" role="button">Ver Reporte</a>
				</div>
			</div>
</form>



<!-- ----------------------GRAFICOS 1------------------>

<script>


</script>



<!-- ---------------------FIN GRAFICOS 1------------------>

<!-- ---------------------INICIO GRAFICOS 2--------------->


<!-- ---------------------FIN GRAFICOS 2------------------>



<!-----------------------------------------FIN BODY---------------------------------------------->
				

				<div class="clearfix"></div>

			</div>
			<!-- END CONTENT -->
			<!-- BEGIN QUICK SIDEBAR -->

			<!-- END QUICK SIDEBAR -->
		</div>
	</div>
	
   
        
	<!-- END CONTAINER -->
	<%@ include file="include/footer.jsp"%>



</body>



</html>
