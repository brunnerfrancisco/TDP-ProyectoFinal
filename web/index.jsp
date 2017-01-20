<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>..:: HOME ::..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css" type="text/css"/>
    </head>
    <body>
        <div id="container">
            <a id="head">
		<div style="float:left;">
			hola mami
		</div>
		<div id="tit">
			Proyecto Final TDP
		</div>
            </a>
            <div id="loguin">
		
                <s:form action="logueo" method="post"> 
                    Usuario: <input type="text" name="user" size=10> 
                    ContraseÃ±a: <input type="password" name="pass" size=10> 
                    <input type="hidden" name="loguear" value="si">
                    <a href="/Proyecto_Final" id="button_enviar">Ingresar</a>
                    <a href="/Proyecto_Final" id="button_enviar">Registro</a>
                </s:form>
            </div>
            <div id="body">
		<div id="menu">
			
			<div class="item_menu">
			Item 1
			</div>
			<div class="item_menu">
			Item 2
			</div>
			<div class="item_menu">
			Item 3
			</div>
		</div>
		<div id="content">
			laskdnfo
		</div>
            </div>
            <div id="foot">
	
            </div>
        </div> 
    </body>
</html>
