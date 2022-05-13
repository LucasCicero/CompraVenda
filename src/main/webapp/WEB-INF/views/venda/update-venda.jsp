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
	    <title>Compra & Venda - Atualizar Venda</title>
	    <link rel="stylesheet" href="/css/views.css">
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
								<a class="nav-link" href="/produtos">Cadastrar Vendas</a>
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
			<%@include file="../mensagem-validacao.jsp" %>
			
			<form method="post">
				<h1>Atualizar Venda</h1>

				<div class="form-group">
					<label for=""><strong>Quantidade Vendida:</strong></label>
					<input type="number" class="form-control" value="${vendas.quantidade_venda}" name="quantidade_venda" required />
				</div>
				
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for=""><strong>Data Vendida:</strong></label>
							<input type="date" class="form-control" value="${vendas.data_venda}" name="data_venda" required/>
						</div>
					</div>
					
					<div class="col">
						<div class="form-group">
							<label for=""><strong>Valor da Venda:</strong></label>
							<input type="number" class="form-control" value="${vendas.valor_venda}" name="valor_venda" required />
					 	</div>
					</div>
				</div>
				
                <div class="row">
                	<div class="col">
						<div class="form-group">
							<label for=""><strong>Id do Cliente:</strong></label>
							<input type="number" class="form-control" value="${vendas.clientes.id}" name="id_cliente" placeholder="Id do Cliente" required />
						</div>
					</div>

                   	<div class="col">
						<div class="form-group">
							<label for=""><strong>Id do Produto:</strong></label>
							<input type="number" class="form-control" value="${vendas.produtos.id}" name="id_produtos" placeholder="Id do produto" required />
						</div>
					</div>
             	</div>
	
				<button type="submit" class="btn btn-success">
					Atualizar Venda
				</button>
				
				<a class="btn-link" href="/vendas">
					<button type="button" class="btn btn-info">Voltar</button>
				</a>
			</form>
		</main>
		
		<br>
		
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