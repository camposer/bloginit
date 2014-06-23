<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="model.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alta de Usuario</title>
<style>
h1 {
	text-align: center;
}

#cabecera {
	background-color: #012c50;
	color: white;
	height: 100px;
}

#formAlta {
	margin-left: auto;
	margin-right: auto;
}

#divAutenticar, #divAutenticar table {
	margin-left: auto;
	text-align: right;
}

#formAlta {
	border: 1px dotted green;
}

#formAlta tr:last-child td {
	text-align: center;
}

#formAlta input[type=text] {
	width: 10em;
}

#formAlta input[type=password] {
	width: 10em;
}

#menu {
	float: left;
	width: 20%;
}

#contenido {
	float: left;
	width: 78%;
}

#pie {
	clear: both;
}
</style>
</head>
<body>
	<div id="cabecera">
		<img src="../img/logo_home.gif"/>
			<div id="divAutenticar">
			<%
				Usuario u = (Usuario)session.getAttribute("usuario");
			
				if (u != null) {	
			%>
			Bienvenido <%= u.getNombre() %>
			<%
				} else {
			%>
				<form:form action="autenticar.blog" commandName="usuarioForm">
					<table>
						<tr>
							<td>Nombre: <form:input path="nombre"/></td>
							<td>Contraseña: <form:input path="clave1"/></td>
							<td><input type="submit" value="Entrar"/></td>
						</tr>
					</table>
				</form:form>
			<%
				}
			%>
			</div>
	</div>

	<div id="menu">Menú</div>

	<div id="contenido">
		<%
			if (u != null) {	
		%>
		Aquí va el contenido del sitio
		<%
			} else {
		%>
		<h1>Alta de usuarios</h1>
		<form:form action="alta.blog" commandName="usuarioForm">

			<table id="formAlta">
				<tr>
					<td>Nombre:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>Contraseña:</td>
					<td><form:input path="clave1" /></td>
				</tr>
				<tr>
					<td>Confirmación Contraseña:</td>
					<td><form:input path="clave2" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Aceptar" /></td>
				</tr>
			</table>

		</form:form>
		<%
			}
		%>
	</div>

	<div id="pie">Pie</div>

</body>
</html>