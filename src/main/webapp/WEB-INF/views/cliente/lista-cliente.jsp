<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Compra & Venda - Lista de Clientes</title>
	    <link rel="stylesheet" href="../css/views.css">
	    <!-- Bootstrap -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">
	</head>
	
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Compra & Venda</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link" href="/clientes">Listar Clientes</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/clientes/cadastrarCliente">Cadastrar Cliente</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/vendas">Listar Vendas</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/vendas/cadastrarVenda">Cadastrar Vendas</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/logout">Sair</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		
		<main class="container">
			<h1>Lista de Clientes</h1>
	
			<table class="table table-hover table-responsive w-auto table-striped">
				<thead>
					<tr>
						<th scope="col">Nome:</th>
						<th scope="col">CPF:</th>
						<th scope="col"></th>
						<th scope="col">Ação</th>
						<th scope="col"></th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="clientes" items="${clientes}" varStatus="i">
					<tr>
						<td>
								<a href='<c:url value="/clientes/detalhes-cliente/${clientes.id}"/>'>
									${clientes.nome}
								</a>
							</td>
							
							<td>${clientes.cpf}</td>
						
						<td>
							<a href='<c:url value="/clientes/deletarCliente?id=${clientes.id}"/>'
								class="waves-effect waves-light btn-small">
								<button type="button" class="btn btn-danger">Excluir</button>
							</a>
						</td>
						
						<td>
							<a href='<c:url value="/clientes/editar-cliente?id=${clientes.id}"/>'>
								<button type="button" class="btn btn-primary">Editar</button>
							</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a class="btn-link" href="/clientes/cadastrarCliente">
				<button type="button" class="btn btn-success">Cadastrar Cliente</button>
			</a>
		</main>
		
		<footer class="footer-copyright fixed-bottom bg-dark text-center py-3">
			<span class="text-light align-middle">
				&copy; Compra & Venda - 2022 - Todos os direitos reservados.
			</span>
		</footer>

		<!--JavaScript bootstrap-->
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous">
		</script>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	</body>
</html>