<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Compra & Venda - Cadastrar Fornecedor</title>
	    
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
								<a class="nav-link" href="/clientes">Listar Cliente</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/cadastrarCliente">Cadastrar Cliente</a>
							</li>
							
							<li class="nav-item">
								<a class="nav-link" href="/fornecedor">Listar Fornecedor</a>
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
			<h1>Cadastro de Fornecedor</h1>
	
			<%@ include file="../mensagem-validacao.jsp" %>	
	
			<form method="post">
				<div class="form-group">
					<label for=""><strong>Razão Social:</strong></label>
					<input type="text" class="form-control" value=""
					placeholder="Razão Social" name="razao_social" required>
				</div>
	
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for=""><strong>CNPJ:</strong></label>
							<input type="text" value="" name="cnpj" placeholder="Digite o cnpj" class="form-control" required />
						</div>
					</div>
					
					<div class="col">
						<label for=""><strong>Endereço:</strong></label>
						<input type="text" value="" name="endereco" class="form-control" placeholder="Digite o endereço" required />
					</div>
					
					<div class="col">
						<label for=""><strong>Bairro:</strong></label>
						<input type="text" value="" name="bairro" class="form-control" placeholder="Digite o bairro" required />
					</div>
					
					<div class="col">
						<label for=""><strong>Cidade:</strong></label>
						<input type="text" value="" name="cidade" class="form-control" placeholder="Digite a cidade" required />
					</div>
					
					<div class="col">
						<label for=""><strong>UF:</strong></label>
						<input type="text" value="" name="uf" class="form-control" placeholder="Digite o uf" required />
					</div>
					
					<div class="col">
						<label for=""><strong>CEP:</strong></label>
						<input type="text" value="" name="cep" class="form-control" placeholder="Digite o cep" required />
					</div>
					
					<div class="col">
						<label for=""><strong>Telefone:</strong></label>
						<input type="text" value="" name="telefone" class="form-control" placeholder="Digite o telefone" required />
					</div>
					
					<div class="col">
						<label for=""><strong>E-mail:</strong></label>
						<input type="text" value="" name="email" class="form-control" placeholder="Digite o email" required />
					</div>
				</div>
				
				<button type="submit" class="btn btn-success">Adicionar Fornecedor</button>
			</form>
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