<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>SISTEMA VOTAÇÃO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link href="Signin.css" rel="stylesheet">
</head>
<body class="text-center">

	<form class="form-Signin" action="login" method="post">
		<img width="100" height="100"
			src="https://img.icons8.com/parakeet/100/private2.png" alt="private2" />
		<font color="white">
			<h1 class="h3 mb-3 font-weight-normal">Login</h1> <br>
		</font>
		<div>

			<input type="text" name="usuario" id="usuario"  value="${param.usuario}" class="form-control"
				placeholder="Usuário" required autofocus>
				<label for="inputPassword" class="sr-only">Senha</label> 
				<input type="password" id="senha" value="${param.senha}" name="senha" class="form-control"
				placeholder="Senha" required >

		</div>

		<button type="submit" class="btn btn-outline-light">Entrar</button>
		
	</form>
</body>
</html>