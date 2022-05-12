<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Compra & Venda - Detalhes dos produtos</title>
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
					<a class="navbar-brand" href="/">Compra & Venda</a>
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
							<sec:authorize access="hasRole('COMPRADOR')">
							<li class="nav-item">
								<a class="nav-link" href="/fornecedores">Listar Fornecedores</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/fornecedores/cadastrarFornecedor">Cadastrar Fornecedor</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/compras">Listar Compras</a>
							</li>
							
							</sec:authorize>
							<li class="nav-item">
								<a class="nav-link" href="/logout">Sair</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		
		<main class="container">
			<h1>Informações dos Produtos</h1>
			
			<div class="container">
				<p>
					<strong>Nome do Produto:</strong> <span>${produtos.nome_produto}</span>
				</p>
				
				<p>
					<strong>Descrição:</strong> <span>${produtos.descricao}</span>
				</p>
				
				<p>
					<strong>Preço de Compra:</strong> <span>${produtos.preco_compra}</span>
				</p>
				
				<p>
					<strong>Preço de Venda:</strong> <span>${produtos.preco_venda}</span>
				</p>
				
				<p>
					<strong>Quantidade Disponivel:</strong> <span>${produtos.quantidade_disponivel}</span>
				</p>
				
				<p>
					<strong>Liberado:</strong> <span>${produtos.liberado_venda}</span>
				</p>
				
				<a class="btn-link" href="/produtos">
					<button type="button" class="btn btn-info">Voltar</button>
				</a>
			</div>
			<br>
			
			<%@include file="../mensagem-validacao.jsp" %>
		<sec:authorize access="hasRole('COMPRADOR')">
			<h2>Registrar Compra do produto</h2>
			
			<br>
			
			<form method="post">
				<div class="form-group">
					<div class="row">
						<div class="col">
							<label for=""><strong>Quantidade Comprada:</strong></label>
							<input type="number" value="" name="quantidade_compra" class="form-control" placeholder="Quantidade Comprada" required />
						</div>

						<div class="col">
							<label for=""><strong>Data da Compra:</strong></label>
							<input type="date" value="" name="data_compra" class="validate form-control" required />
						</div>

						<div class="col">
							<label for=""><strong>Valor da Compra</strong></label>
							<input type="number" value="" name="valor_compra" class="form-control" placeholder="Valor da Compra" required />
						</div>
						
						<div class="col">
							<label for=""><strong>Id Fornecedor</strong></label>
							<input type="number" value="" name="id_fornecedor" class="form-control" placeholder="Id do fornecedor" required />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-success">
					Adicionar Compra
				</button>
			</form>
		</sec:authorize>	
			<br>
			
			<table class="table table-hover table-responsive w-auto table-striped">
				<thead>
					<tr>
						<th scope="col">Quantidade Comprada</th>
						<th scope="col">Data da Compra:</th>
						<th scope="col">Valor da Compra:</th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="compras" items="${compras}" varStatus="i">
					<tr>
						<td>
							<span>${compras.quantidade_compra}</span>
						</td>
						
						<td>
							<span>${compras.data_compra}</span>
						</td>
						
						<td>
							<span>${compras.valor_compra}</span>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</main>
		
		<footer class="footer-copyright bg-dark text-center py-3">
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