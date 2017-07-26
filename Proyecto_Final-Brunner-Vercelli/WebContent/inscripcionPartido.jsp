<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
					<div id="titPartidosDisponibles">Incripcion:</div>
						<div id="partidosDisponibles">
							<div id="infoPartido">
								<table id="tablaPartidosDisponibles">
									<tr><td>Lugar: </td><td>Patronato</td></tr>
									<tr><td>Fecha: </td><td>10/08/2017</td></tr>
									<tr><td>Hora: </td><td>21:00</td></tr>
									<tr><td>Inscriptos: </td><td>6</td></tr>
									<tr><td>Precio: </td><td>$50</td></tr>
								</table>
							</div>
							<div id="separadorPartidoInscriptos"></div>
							<form action="">
								<table id="tablaPartidosDisponibles">
									<tr><td>Nombre: </td><td><input name="nombre" type="text" size="20"></td></tr>
									<tr><td>Apellido: </td><td><input name="apellido" type="text" size="20"></td></tr>
									<tr><td>DNI: </td><td><input name="fechaNac" type="text"></td></tr>
								</table>
								<div id="botonInscribirse"><input type="submit" value="Inscribirse"></div>
								<div id="titInscriptos">Inscriptos:</div>
							</form>
						</div>
				</section>
				<aside>
					<form action="Login" method="post">
						<div id="titLoguin">Logueo</div>
						<div id="labelUser">Usuario: </div><input type="text" size="6" name="userName" id="inputUser"/>
						<div id="labelPass">Password: </div><input type="password" size="6" name="password" id="inputPass"/>
						<input type="submit"  id="botonIngresar" value="Ingresar"/>
					</form>
				</aside>
				<div id="separadorNavSec" style="float:left"></div>
			</div>
			
			<footer>Copyright &copy; 2017 - TDP 2017 - Proyecto Final - Brunner, Vercelli</footer>
		</div>
	</body>
</html>
