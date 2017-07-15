<%@page import="java.io.InputStream"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title> Proyecto Final Vercelli - Bunner</title>
		<link rel="stylesheet" href="CSS/styles.css">
		<link rel="icon" type="image/png" href="CSS/mifavicon.png" />
	</head>
	<body>
		<div id="contenedor">
			<header>
				<div id="titulo">TDP Proyecto Final 2017</div>
			</header>
			<nav>
				<a href="index.jsp" class="itemNav"> Inicio </a>
				<a href="jugadores.jsp" class="itemNav"> Jugadores </a>
				<a href="equipos.jsp" class="itemNav"> Equipos </a>
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
							<table id="tablaPartidosDisponibles">
								<tr><td>Lugar: </td><td>Patronato</td></tr>
								<tr><td>Fecha: </td><td>10/08/2017</td></tr>
								<tr><td>Hora: </td><td>21:00</td></tr>
								<tr><td>Inscriptos: </td><td>6</td></tr>
								<tr><td>Precio: </td><td>$50</td></tr>
							</table>
							<div id="botonInscribirse"><input type="button" value="Inscribirse"></div>
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
					<div id="titLoguin">Logueo</div>
					<div id="labelUser">Usuario:</div><div id="inputUser"><input type="text" size="6"></div>
					<div id="labelPass">Password:</div><div id="inputPass"><input type="password" size="6"></div>
					<div id="botonIngresar"><input type="button" value="Ingresar"></div>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>
