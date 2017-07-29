<%@page import="java.io.InputStream"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page import="models.ColeccionPartidos" %>
<%@ page import="models.Partido" %>
<%@ page import="models.Jugador" %>
<%@ page import="java.util.*" %>
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
					<s:set var="partidoSeleccionado" value="0" />
					<% 
					response.setContentType("text/html");
					ColeccionPartidos partidos=new ColeccionPartidos();
						for(Partido partido : partidos.getPartidos())
						{
					%>
						<div id="partidosDisponibles">
							<s:form action="inscripcion">
								<s:hidden name="ID_seleccionado" value="%{#partidoSeleccionado}"/>
								<table id="tablaPartidosDisponibles">
									<tr><td>Lugar: </td><td><%out.println(partido.getLugar()); %></td></tr>
									<tr><td>Fecha: </td><td><%out.println(partido.getFecha()); %></td></tr>
									<tr><td>Hora: </td><td><%out.println(partido.getHora()); %></td></tr>
									<tr><td>Jugadores: </td><td><%out.println(partido.getCantidadJugadores()); %></td></tr>
									<tr><td>Inscriptos: </td><td><%out.println(partido.getCantidadInscriptos()); %></td></tr>
									<tr><td>Precio: </td><td><%out.println(partido.getPrecio()); %></td></tr>
								</table>
								<div id="botonInscribirse">
									<s:submit cssClass="bntInscribirse" value="Inscribirse" />
								</div>
							</s:form>
							<div id="titInscriptos">Inscriptos:</div>
							
							<table id="tablaPartidosDisponibles">
							<s:set var="jugadorSeleccionado" value="0" />
							<% 
								for(Jugador jugador : partido.getInscriptos())
								{
							%>
								<tr>
								<td><%out.println(jugador.getNombre()); %></td>
								<td><%out.println(jugador.getApellido()); %></td>
								<td><%out.println(jugador.getDNI()); %></td>
									
<%-- 									<s:if test='%{#session.user != null}'> --%>
										<s:form action="eliminarJugador">
										<s:set var="DNI"><%out.println(jugador.getDNI()); %></s:set>
											<s:hidden name="DNI_seleccionado" value="%{#DNI}"/>
											<s:hidden name="ID_partido_seleccionado" value="%{#partidoSeleccionado}"/>
											<td><s:submit value="X" /></td>
										</s:form>
<%-- 									</s:if> --%>
								
								</tr>
								<s:set var="jugadorSeleccionado" value="%{#jugadorSeleccionado+1}" />
							<%
								} 
							%>
							</table>
						</div>
						<s:set var="partidoSeleccionado" value="%{#partidoSeleccionado+1}" />
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
