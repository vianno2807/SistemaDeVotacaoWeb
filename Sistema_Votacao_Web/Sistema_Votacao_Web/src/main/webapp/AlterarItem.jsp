<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="perfil" value="${sessionScope.candidato}" />
	<form action="AtualizarItemServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${candidato.nome}">
        <input type="hidden" name="idCandidato" value="${candidato.idCandidato}">
        <label for="partido">Partido:</label>
        <input type="text" id="partido" name="partido" value="${candidato.partido}">
        <label for="numPartido">Numero:</label>
        <input type="text" id="numPartido" name="numPartido" value="${candidato.numPartido}">
        
        <input type="submit" name="salvar" value="Salvar">
    </form>
</body>
</html>