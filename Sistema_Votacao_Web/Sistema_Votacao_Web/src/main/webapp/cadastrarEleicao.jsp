<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Eleição</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">
	<link rel="stylesheet" href="Eleicao.css">
</head>
<body>
	<nav class="eleicaoNav">
		<ul>
			<h3>
				<span style="color: orange;">Eleições online</span>
			</h3>

			<a href="Votar.jsp" style="color: white">Votar</a>
			<a href="resultados.jsp" style="color: white">Resultados</a>
			<a href="cadastrarCandidato.jsp" style="color: white">CadastrarCandidato</a>
			<a href="cadastrarEleicao.jsp" style="color: white">Cadastrar Eleição</a>
			<a href="Cadastro1.jsp" style="color: white">Cadastro</a>
			<a href="gerenciar.jsp" style="color: white">Gerenciar</a>
		</ul>
	</nav>
	<main class="eleicaoMain">
		<form action="CadastroEleicaoController?status=${param.status}" method="post" class="eleicaoForm">
			<h2 style="color: blue">Cadastrar eleição</h2>
			<div>
				<label> <strong style="color: blue">Nome da Eleicão:</strong></label>
				<input type="text" name="nomeEleicao" value="${param.nomeEleicao}">
			</div>
			<div>
				<label style="color: blue"><strong>Data de Inicio :</strong></label>
				<input type="date" name="dataInicio" value="${param.dataInicio}">
			</div>
			<div>
				<label style="color: blue"><strong>Data de <br>	Encerramento:
				</strong></label>
				<input type="date" name="dataFim" value="${param.dataFim}">
			</div>
			<br>
			<div>
				<button type="submit" class="btn btn-outline-primary">Cadastrar</button>
				 <% 
        String status = request.getParameter("status");
        if (status != null && status.equals("success")) {
            out.println("<span style='color: green;'>Cadastro realizado com sucesso!</span>");
        }
    %>
			</div>
		</form>
</main>
</body>
</html>