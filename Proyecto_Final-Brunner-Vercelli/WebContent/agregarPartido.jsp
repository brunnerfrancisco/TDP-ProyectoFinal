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
					
					<s:form action="registrarPartido">
						<table id="tablaAgregarPartido">
							<s:fielderror fieldName="lugar"/>
							<tr>
								<td><s:label>Lugar: </s:label></td>
								<td><s:textfield name="lugar"/></td>
							</tr>
							<s:fielderror fieldName="fecha"/>
							<tr>
								<td><s:label>Fecha: </s:label></td>
								<td><s:textfield name="fecha"/></td>
							</tr>
							<s:fielderror fieldName="hora"/>
							<tr>
								<td><s:label>Hora: </s:label></td>
								<td><s:textfield name="hora"/></td>
							</tr>
							<s:fielderror fieldName="precio"/>
							<tr>
								<td><s:label>Precio: </s:label></td>
								<td><s:textfield name="precio"/></td>
							</tr>
							<s:fielderror fieldName="cantidadJugadores"/>
							<tr>
								<td><s:label>Cantidad de Jugadores: </s:label></td>
								<td><s:textfield name="cantidadJugadores"/></td>
							</tr>
							<s:fielderror fieldName="nombreEquipo1"/>
							<tr>
								<td><s:label>Nombre Equipo 1: </s:label></td>
								<td><s:textfield name="nombreEquipo1"/></td>
							</tr>
							<s:fielderror fieldName="nombreEquipo2"/>
							<tr>
								<td><s:label>Nombre Equipo 2: </s:label></td>
								<td><s:textfield name="nombreEquipo2"/></td>
							</tr>
						</table>
						<div class="centrar"><s:submit value="Agregar" title="Agregar" cssClass="btnAgregarPartido"/></div>
							
					</s:form>
				</section>
				<aside>
					<s:if test='%{#session.user != null}'>
						<div id="titLoguin">Bienvenido <s:property value="%{#session['user']}"/></div>
						<s:form action="LogOut" method="post">
							<s:hidden name="userName" value="admin"/>
							<s:hidden name="password" value="admin"/>
							<div class="centrar"><s:submit  cssClass="btnIngresar" value="Salir"/></div>
						</s:form>
						<div class="centrar"><s:a action="agregarPartido" cssClass="btnAgregarPartido">Agregar Partido</s:a></div>
					</s:if>
					<s:else>
						<s:fielderror fieldName="errorLogin" />
						<s:form action="Login" method="post">
							<div id="titLoguin">Logueo</div>
							<div id="labelUser">Usuario: </div><s:textfield name="userName" cssClass="inputUser" value=""/>
							<div id="labelPass">Password: </div><s:password name="password" cssClass="inputPass" value=""/>
							
							<div class="centrar"><s:submit  cssClass="btnIngresar" value="Ingresar"/></div>
						</s:form>
					</s:else>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy; 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>
