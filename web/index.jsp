<%@page import="java.io.InputStream"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
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
		<div id="tit">
			Proyecto Final TDP
		</div>
            </a>
            <header>
                    <h1></h1>
                    <s:form action="login">
                            <label id="label">Usuario: <s:textfield name="userName" id="user"/></label>
                            <label id="label">Password: <s:password name="password" id="pass"/></label>
                            <s:submit value="Login"/>
                    </s:form>
            </header>
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
