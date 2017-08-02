<%@page import="java.io.InputStream"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page import="models.ColeccionPartidos" %>
<%@ page import="models.Partido" %>
<%@ page import="models.Jugador" %>
<%@ page import="models.Equipo" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title> Proyecto Final Bunner - Vercelli</title>
		<link rel="stylesheet" href="CSS/styles.css?1.0.1">
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
					<div id="titPartidosDisponibles">Jugadores</div>
					
					<div id="partidosDisponibles">
						<table id="tablaPartidosDisponibles">
						<% 
						response.setContentType("text/html");
						ColeccionPartidos partidos=new ColeccionPartidos();
						for(Partido partido : partidos.getPartidos())
						{
							for(Equipo equipo : partido.getEquipos())
							{
								for(Jugador jugador : equipo.getJugadores())
								{
						%>
								<tr>
								<td><%out.println(jugador.getNombre()); %></td>
								<td><%out.println(jugador.getApellido()); %></td>
								<td><%out.println(jugador.getDNI()); %></td>
								</tr>
						<%
								}
							} 
						} 
						%>
						</table>
					</div>
				</section>
				<aside>
					<s:if test='%{#session.user != null}'>
						<div id="titLoguin">Bienvenido <s:property value="%{#session['user']}"/></div>
						<s:fielderror />
						<s:form action="LogOut" method="post">
							<s:hidden name="userName" value="admin"/>
							<s:hidden name="password" value="admin"/>
							<div class="centrar"><s:submit  cssClass="btnIngresar" value="Salir"/></div>
						</s:form>
						<div class="centrar"><s:a action="agregarPartido" cssClass="btnAgregarPartido">Agregar Partido</s:a></div>
					</s:if>
					<s:else>
						<s:fielderror />
						<s:if test="hasActionErrors()">
							<s:actionerror/>
						</s:if>
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
