<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>| App RH - UC 12 |</title>
</head>

<body>
    <c:if test="${empty mensagem}" >
	<div class="alert alert-success alert-dismissible" role="alert">

		<span >${mensagem}</span>
	</div>
	</c:if>
	
	 <c:if test="${not empty mensagem}" >
	<div class="alert alert-success alert-danger" role="alert">

		<span>${mensagem_erro}</span>
	</div>
	</c:if>
</body>

</html>