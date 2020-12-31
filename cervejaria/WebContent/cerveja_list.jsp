<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cervejaria</title>
<link rel="icon" href="Imagens/caneca.png"> 
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="nav">
	</div>
	<script src="jquery-3.5.1.min.js"></script>
	<script>
	$(function(){
  		$("#nav").load("navbar.html");
	});
	</script>
	
	<button onclick="window.location.href='Cerveja_servlet?action=add';">Adicionar</button>
	<table>
		<thead>
  		<tr>
    		<th>Nome</th>
    		<th>Teor alcoolico (%)</th>
    		<th>Volume (ml)</th>
    		<th>Preço (R$)</th>
    		<th>Opções</th>
  		</tr>
		</thead>
		<tbody>
		<c:forEach items="${cervejas}" var="cerveja">
		<tr>
			<td><c:out value="${cerveja.nome}"></c:out></td>
			<td><c:out value="${cerveja.indice_alcool}"></c:out></td>
			<td><c:out value="${cerveja.mililitros}"></c:out></td>
			<td><c:out value="${cerveja.preco}"></c:out></td>			
  			<td><button onclick="window.location.href='Cerveja_servlet?action=edit&id=<c:out value="${cerveja.id}"/>';">Editar</button> 
  			<button onclick="window.location.href='Cerveja_servlet?action=delete&id=<c:out value="${cerveja.id}"/>';">Deletar</button></td>
			
		</tr>
		</c:forEach>
  		</tbody>
	</table>
</body>
</html>