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
	    <title>Compra & Venda - Detalhes da Categoria</title>
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
								<a class="nav-link active" aria-current="page" href="/">Home</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/funcionarios">Funcionários</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/cadastrarFuncionario">Cadastrar Funcionário</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/clientes">Listar Clientes</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/cadastrarCliente">Cadastrar Cliente</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/fornecedores">Listar Fornecedores</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/cadastrarFornecedor">Cadastrar Fornecedor</a>
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
			<h1>Informações de Categoria</h1>
			
			<div class="container">
				<p>
					<strong>Nome da Categoria:</strong> <span >${categorias.nome_categoria}</span>
				</p>
				
				<a class="btn-link" href="/categorias">
					<button type="button" class="btn btn-info">Voltar</button>
				</a>
			</div>
			
			<h2>Registrar Produtos</h2>
			
			<br>
			
			<form method="post">
				<div class="form-group">
					<div class="row">
						<div class="col">
							<label for=""><strong>Nome do Produto</strong></label>
							<input type="text" value="" name="nome_produto" class="form-control" placeholder="Nome do Produto" required />
						</div>

						<div class="col">
							<label for=""><strong>Descrição</strong></label>
							<input type="text" value="" name="descricao" class="validate form-control" required />
						</div>

						<div class="col">
							<label for=""><strong>Preço de Compra</strong></label>
							<input type="number" value="" name="preco_compra" class="form-control" placeholder="Preço da Compra" required />
						</div>
						
						<div class="col">
							<label for=""><strong>Preço de Venda</strong></label>
							<input type="number" value="" name="preco_venda" class="form-control" placeholder="Preço de Venda" required />
						</div>
						<div class="col">
							<label for=""><strong>Quantidade Disponível</strong></label>
							<input type="number" value="" name="quantidade_disponivel" class="form-control" placeholder="Quantidade Disponível" required />
						</div>
						<div class="col">
							<label for=""><strong>Liberado</strong></label>
							<input type="text" value="" name="liberado_venda" class="form-control" placeholder="Liberado" required />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-success">
					Adicionar Compra
				</button>
			</form>
			
			<br>
			
			<table class="table table-hover table-responsive w-auto table-striped">
				<thead>
					<tr>
						<th scope="col">Nome do Produto</th>
						<th scope="col">Descrição:</th>
						<th scope="col">Preço de Compra:</th>
						<th scope="col">Preço de Venda:</th>
						<th scope="col">Quantidade Disponível:</th>
						<th scope="col">Liberado:</th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="produtos" items="${produtos}" varStatus="i">
					<tr>
						<td>
							<span>${produtos.nome_produto}</span>
						</td>
						
						<td>
							<span>${produtos.descricao}</span>
						</td>
						
						<td>
							<span>${produtos.preco_compra}</span>
						</td>
						<td>
							<span>${produtos.preco_venda}</span>
						</td>
						<td>
							<span>${produtos.quantidade_disponivel}</span>
						</td>
						<td>
							<span>${produtos.liberado_venda}</span>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		
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