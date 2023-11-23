<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Eleições online</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <link rel="stylesheet" href="Eleicao.css">
</head>
<body class="text-center">
<form action="LoginController">
    <c:set var="perfil" value="${sessionScope.perfil}" />
    <nav class="eleicaoNav">
        <ul>
            <h3>
                <span style="color: orange;">Eleições online</span>
            </h3>
            <c:choose>
                <c:when test="${perfil eq 'administrador'}">
                    <li><a href="Votar.jsp" style="color: white">Votar</a></li>
                    <li><a href="resultados.jsp" style="color: white">Resultados</a></li>
                    <li><a href="cadastrarCandidato.jsp" style="color: white">Cadastrar Candidato</a></li>
                    <li><a href="cadastrarEleicao.jsp" style="color: white">Cadastrar Eleição</a></li>
                    <li><a href="Cadastro1.jsp" style="color: white">Cadastro</a></li>
                    <li><a href="gerenciar.jsp" style="color: white">Gerenciar</a></li>
                </c:when>
                <c:when test="${perfil ne 'administrador'}">
                    <li><a href="Votar.jsp" style="color: white">Votar</a></li>
                    <li><a href="resultados.jsp" style="color: white">Resultados</a></li>
                </c:when>
            </c:choose>
        </ul>
    </nav>
    <main class="eleicaoMain">
    </main>
    </form>
</body>
</html>
