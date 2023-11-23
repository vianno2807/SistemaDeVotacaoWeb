<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cadastro</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link rel="stylesheet" href="Eleicao.css">
</head>
<body class="text-center">
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
    <form action="cadastrocontroller?status=${param.status}" method="post" class="eleicaoForm">
    <h2 style="color: blue">Cadastrar Usuario</h2>
        <div>
            <label> <strong style="color: blue">Nome:</strong></label><br>
            <input type="text" name="nome" value="${param.nome}" required>
        </div>
        <div>
            <label style="color: blue"><strong>Senha:</strong></label><br>
            <input type="text" name="senha" value="${param.senha}" required>
        </div>
        <div>
            <label style="color: blue"><strong>Registro de<br>Eleitor:</strong></label>
            <input type="text" name="registro" value="${param.registro}" required>
       </div>
        <div>
            <label style="color: blue"><strong>Endereço:</strong></label><br>
            <input type="text" name="endereco" value="${param.endereco}" required>
          
        </div>
        <div class=".form-check-inline"  style="margin-right: center">
            <input class="form-check-input" type="radio" value="Eleitor" name="perfil" id="inlineRadio1">
            <label style="color: blue; margin-left: center" class="form-check-label" for="inlineRadio1">Eleitor</label>
        </div>
        <div >
            <input class="form-check-input" type="radio" style="margin-left: -159px" value="Administrador" name="perfil" id="inlineRadio2" >
            <label style="color: blue; margin-left: 65px" class="form-check-label" for="inlineRadio2">Administrador</label>
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
