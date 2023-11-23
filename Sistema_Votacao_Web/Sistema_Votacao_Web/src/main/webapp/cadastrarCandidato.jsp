<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Candidato</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet" href="Eleicao.css">
</head>
<body>
<jsp:useBean id="obj" class="controller.ListaEleicao" scope="page"/>
	<nav class="eleicaoNav">
		<ul>
			<h3>
				<span style="color: orange;">Eleições online</span>
			</h3>
			<a href="Votar.jsp" style="color: white">Votar</a>
			<a href="resultados.jsp" style="color: white">Resultados</a>
			<a href="cadastrarCandidato.jsp" style="color: white">Cadastrar Candidato</a>
			<a href="cadastrarEleicao.jsp" style="color: white">Cadastrar Eleição</a>
			<a href="Cadastro1.jsp" style="color: white">Cadastro</a>
			<a href="gerenciar.jsp" style="color: white">Gerenciar</a>
		</ul>
	</nav>
	<main class="eleicaoMain">
 		<form action="CadastroCadController?status=${param.status}" method="post" class="eleicaoForm">
			<h2 style="color: blue">Cadastrar Candidato</h2>
			<br>
			<div>
				<br>
				<label> <strong style="color: blue">Nome:</strong></label><br>
				<input type="text" name="nome" value="${param.nome}" required>
			</div>
			<div>
				<label style="color: blue"><strong>Senha:</strong></label><br>
				<input type="text" name="senha" value="${param.senha}" required>
			</div>
			<div>
				<label style="color: blue"><strong>Número do<br>partido:</strong></label>
				<input type="text" name="numPartido" value="${param.numPartido}" required>
			</div>
			<div>
				<label style="color: blue"><strong>Nome do<br>partido:</strong></label>
				<input type="text" name="partido" value="${param.partido}" required>
			</div>
		<form id="form-1" action="">
		 <label style="color: blue" for="nomeEleicao">Selecione a eleição</label> 
		  <select name="eleicao"  class="form-control" style="width: 400px;">
            <option value="">Escolher...</option>
            <c:forEach items="${obj.items}" var="eleicao">                        
                <option value="${eleicao.idEleicao}">${eleicao.nomeEleicao}</option>
            </c:forEach>
        </select> <br> <br>
        <div>
            <button type="submit" class="btn btn-outline-primary">Cadastrar</button>
            <% 
        String status = request.getParameter("status");
        if (status != null && status.equals("success")) {
            out.println("<span style='color: green;'>Cadastro realizado com sucesso!</span>");
        }
    %>
        </div>
	</main>
</body>
</html>