<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>resultados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="Eleicao.css" rel="stylesheet">
</head>
<body>
		<jsp:useBean id="obj" class="controller.ListaEleicao" scope="page"/>
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
    </form>
	<main class="eleicaoMain">	
		<div class="eleicaoForm" >
		<h2 style="color: blue">Resultados</h2>
		<form id="form-1" action="ResultadosController" method="post">
		 <label style="color: blue; margin-top: 1px;" for="nomeEleicao"><strong>Selecione a eleição</strong></label> 			      
       		 <select name="eleicao"  class="selecao">
           		 <option value="">Escolher...</option>
           			 <c:forEach items="${obj.items}" var="eleicao">                        
                <option value="${eleicao.idEleicao}">${eleicao.nomeEleicao}</option>
            </c:forEach>
        </select> 
        <button type="submit" class="btn btn-outline-primary" name="buscarReseltado" value="buscarReseltado">Listar</button>
        <br> <br> <br> <br>
        		<table class="table table-bordered" style="width: 90%; margin-bottom: 20rem; margin-top: -50px; background-color: white; border-radius: 10px; overflow: hidden;">
				 <thead class="dark">
   				 <tr>
     			<th scope="col">Candidato</th>
     			 <th scope="col">Partido</th>
      			<th scope="col">Total de Votos</th>
   				 </tr> 	
   				 <c:forEach items="${sessionScope.listaR}" var="resultado">
	   				  <tr>
	   				  	<td>${resultado.nome} </td>
	   				  	<td>${resultado.partido} </td>
	   				  	<td>${resultado.totalVotos} </td>		
	   		 </c:forEach>	 			 
 			 </thead>
				</table>
			</form>
		</div>
	</main>
</body>
</html>