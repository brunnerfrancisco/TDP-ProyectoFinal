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
					<div id="titPartidosDisponibles">Partidos Disponibles</div>
					<% 
						for(int i=0; i<3; i++)
						{
					%>
						<div id="partidosDisponibles">
							<s:form action="inscripcion">
								<table id="tablaPartidosDisponibles">
									<tr><td>Lugar: </td><td>Patronato</td></tr>
									<tr><td>Fecha: </td><td>10/08/2017</td></tr>
									<tr><td>Hora: </td><td>21:00</td></tr>
									<tr><td>Inscriptos: </td><td>6</td></tr>
									<tr><td>Precio: </td><td>$50</td></tr>
								</table>
								<div id="botonInscribirse">
									<s:submit cssClass="bntInscribirse" value="Inscribirse" />
								</div>
							</s:form>
							<div id="titInscriptos">Inscriptos:</div>
							<% 
								for(int j=0; j<6; j++)
								{
							%>
							<div id="nombreInscriptos">Juan Perez</div>
							<%
								} 
							%>
						</div>
						
						
					<%
						} 
					%>
				</section>
				<aside>
					<s:if test='%{#session.user != null}'>
						<div id="titLoguin">Bienvenido <s:property value="%{#session['user']}"/></div>
						<form action="LogOut" method="post">
							<input type="submit"  id="botonIngresar" value="Salir"/>
						</form>
						
						<s:a action="agregarPartido" cssClass="btnAgregarPartido">Agregar Partido</s:a>
					</s:if>
					<s:else>
						<form action="Login" method="post">
							<div id="titLoguin">Logueo</div>
							<div id="labelUser">Usuario: </div><input type="text" size="6" name="userName" id="inputUser"/>
							<div id="labelPass">Password: </div><input type="password" size="6" name="password" id="inputPass"/>
							<input type="submit"  id="botonIngresar" value="Ingresar"/>
						</form>
					</s:else>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy; 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>
