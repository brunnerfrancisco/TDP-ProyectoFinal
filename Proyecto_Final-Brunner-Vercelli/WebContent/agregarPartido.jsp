<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title> Proyecto Final Bunner - Vercelli</title>
		<link rel="stylesheet" href="CSS/styles.css?1.0.0">
		<link rel="icon" type="image/png" href="CSS/mifavicon.png" />
	</head>
	<body>
		<div id="contenedor">
			<header>
				<s:a action="index" cssClass="titulo">TDP Proyecto Final 2017</s:a>
			</header>
			<nav>
				<s:a action="index" cssClass="itemNav"> Inicio </s:a>
				<s:a action="jugadores" cssClass="itemNav"> Jugadores </s:a>
				<s:a action="equipos" cssClass="itemNav"> Equipos </s:a>
			</nav>
			<div id="separadorNavSec"></div>
			<div id="contenedor2">
				<section>
					<div id="titPartidosDisponibles">Agregar Partido</div>
					<s:fielderror />
					<s:form action="registrarPartido">
						<table id="tablaAgregarPartido">
							<tr>
								<td><s:label>Lugar: </s:label></td>
								<td><s:textfield name="lugar"/></td>
							</tr>
							<tr>
								<td><s:label>Fecha: </s:label></td>
								<td><s:textfield name="fecha"/></td>
							</tr>
							<tr>
								<td><s:label>Hora: </s:label></td>
								<td><s:textfield name="hora"/></td>
							</tr>
							<tr>
								<td><s:label>Precio: </s:label></td>
								<td><s:textfield name="precio"/></td>
							</tr>
							<tr>
								<td><s:label>Cantidad de Jugadores: </s:label></td>
								<td><s:textfield name="cantidadJugadores"/></td>
							</tr>
							<tr>
								<td><s:submit value="Agregar" title="Agregar" cssClass="btnAgregarPartido"/> </td>
							</tr>
						</table>
					</s:form>
				</section>
				<aside>
					<s:if test='%{#session.user != null}'>
						<div id="titLoguin">Bienvenido <s:property value="%{#session['user']}"/></div>
						<s:form action="LogOut" method="post">
							<s:submit  cssClass="botonIngresar" value="Salir"/>
						</s:form>
						<s:a action="agregarPartido" cssClass="btnAgregarPartido">Agregar Partido</s:a>
					</s:if>
					<s:else>
						<s:fielderror />
						<s:form action="Login" method="post">
							<div id="titLoguin">Logueo</div>
							<div id="labelUser">Usuario: </div><s:textfield name="userName" cssClass="inputUser"/>
							<div id="labelPass">Password: </div><s:password name="password" cssClass="inputPass"/>
							<s:submit  cssClass="botonIngresar" value="Ingresar"/>
						</s:form>
					</s:else>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy; 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>
