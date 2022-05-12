<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml" >
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">	   
	    <title>Compra & Venda</title>
	   <link rel="stylesheet" href="/css/style.css">
	    
	</head>
	<body>
		<main>
			<div id="login-container">
                        <%@include file="mensagem-validacao.jsp" %>
				<h1 class="login-title input-field first">Compra & Venda</h1>
				

				<form method="post" id="form-login" action="<c:url value='/login'/>"> 
					<input type="text" id="cpf" name="username" placeholder="Digite seu CPF" class="input-field second">
					<input type="password" id="password" name="password" placeholder="Digite sua senha" class="input-field third">				
					<button type="submit" class="input-field fourth">Entrar</button>
				</form>
			</div>
	    </main>
	</body>
</html>