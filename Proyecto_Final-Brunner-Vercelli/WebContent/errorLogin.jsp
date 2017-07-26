<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
					<div id="titPartidosDisponibles"></div>
					
				</section>
				<aside>
					<form action="ErrorLogin">
						<div id="titLoguin" style="color:#FF0000"> ERROR </div>
						<input type="submit" id="botonIngresar" value="Regresar"/>
					</form>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy; 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>