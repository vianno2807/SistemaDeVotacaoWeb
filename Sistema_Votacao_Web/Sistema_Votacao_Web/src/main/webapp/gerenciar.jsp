<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerencia</title>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
         integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
         crossorigin="anonymous">
      <link href="Eleicao.css" rel="stylesheet">
   </head>
   <body>
      <nav class="eleicaoNav">
         <ul>
            <h3><span style="color: orange;">Eleições online</span></h3>
            <a href="Votar.jsp" style="color: white">Votar</a>
            <a href="resultados.jsp" style="color: white">Resultados</a>
            <a href="cadastrarCandidato.jsp" style="color: white">Cadastrar Candidato</a>
            <a href="cadastrarEleicao.jsp" style="color: white">Cadastrar Eleição</a>
            <a href="Cadastro1.jsp" style="color: white">Cadastro</a>
            <a href="gerenciar.jsp" style="color: white">Gerenciar</a>
         </ul>
      </nav>
      <main class="eleicaoMain">
         <form action="GerenciamentoController" method="post" class="eleicaoForm">
         	<c:set var="nomeTabela" value="${sessionScope.nomeTabela}" />
            <h2 style="color: blue">Gerenciamento</h2>
               <label for="tipo" style="color: blue; margin-top: 100px;" for="nomeEleicao">Selecione a tabela</label> 
               <select name="tipo"  class="form-control" name="tipo">

                  <option value="">Escolher...</option>
                   <option value="1">Candidatos</option>
                   <option value="2">Eleicoes</option>
                   <option value="3">Usuarios</option>
                   <option value="4">Eleitores</option>
                   <option value="5">dadosExcluidos</option>
               </select>
               <br>
               <button type="submit" class="btn btn-outline-primary" name="pesquisar" value="pesquisar">Pesquisar</button>  
               <br>
               
               <c:choose>
                <c:when test="${nomeTabela eq 'Candidatos'}">
                 <div style="width: 90%; overflow: auto;">
                   <table class="table table-bordered" style="width: 90%; background-color: white; 
                    border-radius: 10px; overflow: hidden; " >
                  <thead class="dark">
                     <tr>
                        <th scope="col">id</th>
                        <th scope="col">Candidato</th>
                        <th scope="col">Partido</th>
                        <th scope="col">Numero</th>
                     </tr>
                    
                     <c:forEach items="${sessionScope.listaCand}" var="candidato">
                        <tr>
                           <td>${candidato.idCandidato} </td>
                           <td><input type ="text" name="nomeCandidato" style="width: 180px;" value="${candidato.nome}"></td>                       
                           <td><input type ="text" name="partidoCandidato" style="width: 100px;" value="${candidato.partido}"></td>
                           <td><input type ="text" name="numeroCandidato" style="width: 100px;" value="${candidato.numPartido}"></td>
                          <td>
                          	<center>                         	
                                <%-- <form method="post"  action="EditarItem">
                           	  	<input type="hidden" name="idCandidato" value="${candidato.idCandidato}">                           	  	
<!--                       			<input type="submit" name="editar" value="editar" style="width: 80px; height: 50px;">
 -->                      			</form> --%>
                          		<form method="post" action="DeletarItem">
                          			<input type="hidden" name="idCandidato" value="${candidato.idCandidato}">
                          			<input type="hidden" name="nome" value="${candidato.nome}">
                          			<input type="hidden" name="partido" value="${candidato.partido}">
                          			<input type="hidden" name="numPartido" value="${candidato.numPartido}">                         			
                          		    <input type="hidden" name="excluirCandidato" value="excluirCandidato">
                          			<input type="submit" name="excluir" value="excluir" style="width: 80px; height: 50px;">                          		                       			
                          		</form> 
                          		<td>
                          	<form method="post" action="AtualizarItemServlet">
                          		<input type="hidden" name="idCandidato" value="${candidato.idCandidato}">
                          		<input type="submit" name="editar" value="editar" style="width: 80px; height: 50px;">    	
                          	</form>
                          </td>                      		
                          	</center>
                          </td>
                        </tr>
                     </c:forEach>

                  </thead>
               </table>
               </div>
                </c:when>
                <c:when test="${nomeTabela eq 'Eleicoes'}">
                 <div style="width: 90%; overflow: auto;">
                   <table class="table table-bordered" style="width: 90%; background-color: white; border-radius: 10px; overflow: hidden;" >
                  <thead class="dark">
                     <tr>
                        <th scope="col">id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Datainicio</th>
                        <th scope="col">DataFim</th>
                     </tr>
                     <c:forEach items="${sessionScope.listaEle}" var="eleicao">
                        <tr>
                           <td>${eleicao.idEleicao}</td>
                           <td>${eleicao.nomeEleicao}</td>
                           <td>${eleicao.dataInicio}</td>
                           <td>${eleicao.dataFim}</td>
                            <td>
                          	<center>
                          		<form method="post" action="DeletarItem">
                          			<input type="hidden" name="idEleicao" value="${candidato.idEleicao}">
                          			  <input type="hidden" name="excluirEleicao" value="excluirEleicao">
                          			<input type="submit" name="excluir" value="excluir" style="width: 80px; height: 50px;">
                          		</form>
                      			<input type="submit" name="editar" value="editar" style="width: 80px; height: 50px;">
                          	</center>
                          </td>
                        </tr>
                     </c:forEach>
                  </thead>
               </table>
               </div>
                </c:when>
                <c:when test="${nomeTabela eq 'Usuarios'}">
                 <div style="width: 90%; overflow: auto;">
                   <table class="table table-bordered" style="width: 90%; background-color: white; border-radius: 10px; overflow: hidden;" >
                  <thead class="dark">
                     <tr>
                        <th scope="col">id</th>
                        <th scope="col">Login</th>
                        <th scope="col">Senha</th>
                        <th scope="col">Perfil</th>
                     </tr>
                     <c:forEach items="${sessionScope.listaUsu}" var="usuario">
                        <tr>
                           <td>${usuario.idUsuario}</td>
                           <td>${usuario.login}</td>
                           <td>${usuario.senha}</td>
                           <td>${usuario.perfil}</td>
                           <td>
                          	<center>
                          		<form method="post" action="DeletarItem">
                          			<input type="hidden" name="idUsuario" value="${candidato.idUsuario}">
                          			 <input type="hidden" name="excluirUsuario" value="excluirUsuario">
                          			<input type="submit" name="excluir" value="excluir" style="width: 80px; height: 50px;">
                          		</form>
                      			<input type="submit" name="editar" value="editar" style="width: 80px; height: 50px;">
                          	</center>
                          </td>
                        </tr>
                     </c:forEach>
                  </thead>
               </table>
               </div>
                </c:when> 
                       <c:when test="${nomeTabela eq 'Eleitores'}">
                        <div style="width: 90%; overflow: auto;">
                   <table class="table table-bordered" style="width: 90%; background-color: white; border-radius: 10px; overflow: hidden;" >
                  <thead class="dark">
                     <tr>
                        <!-- <th scope="col">id</th> -->
                        <th scope="col">Nome</th>
                        <th scope="col">Endereço</th>
                        <th scope="col">Registro de Eleitor</th>
                     </tr>
                     <c:forEach items="${sessionScope.listaEleit}" var="eleitores">
                        <tr>
                    <%-- <td>${eleitores.idEleitor}</td> --%>
                           <td>${eleitores.nome}</td>
                           <td>${eleitores.endereco}</td>
                           <td>${eleitores.numRegistroEleitor}</td>
                           <td>
                          	<center>
                          		<form method="post" action="DeletarItem">
                          			<input type="hidden" name="nome" value="${eleitores.nome}">
                          			 <input type="hidden" name="excluirEleitor" value="excluirEleitor">
                          			<input type="submit" name="excluir" value="excluir" style="width: 80px; height: 50px;">
                          		</form>
                      			<input type="submit" name="editar" value="editar" style="width: 80px; height: 50px;">
                          	</center>
                          </td>
                        </tr>
                     </c:forEach>
                  </thead>
               </table>
               </div>
                </c:when>
                <c:when test="${nomeTabela eq 'dadosExcluidos'}">
                 <div style="width: 90%; overflow: auto;">
                   <table class="table table-bordered" style="width: 90%; background-color: white; border-radius: 10px; overflow: hidden;" >
                  <thead class="dark">
                     <tr>
                        <th scope="col">idExclusão</th>
                        <th scope="col">Tabela</th>
                        <th scope="col">id</th>
                        <th scope="col">Dados</th>
                        <th scope="col">Data de Exclusão</th>
                     </tr>
                     <c:forEach items="${sessionScope.listaDados}" var="dadosExcluidos">
                        <tr>
                           <td>${dadosExcluidos.idExclusao}</td>
                           <td>${dadosExcluidos.tabelaExclusao}</td>
                           <td>${dadosExcluidos.id}</td>
                           <td>${dadosExcluidos.dados}</td>
                           <td>${dadosExcluidos.dataExclusao}</td>                           
                        </tr>
                     </c:forEach>
                  </thead>
               </table>
               </div>
                </c:when>
            </c:choose>              
         </form>
      </main>
   </body>
</html>