<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
	
	<button onclick="window.location.href='Receita_servlet?action=add';">Adicionar</button>
	<table>
		<tr>
			<th>Cerveja</th>
			<th>Ingredientes</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${receitas}" var="receita">
		<tr>
			<td><c:out value="${receita.getCerveja_id().getNome()}"></c:out></td>
			<td><c:out value="${receita.getQuantidade()} ${receita.getUnidades_id().getNome()} de ${receita.getInsumos_id().getNome()}"></c:out></td>
  			<td><button onclick="window.location.href='Receita_servlet?action=edit&cerveja_id=<c:out value="${receita.getCerveja_id().getId()}"/>&insumo_id=<c:out value="${receita.getInsumos_id().getId()}"/>&unidade_id=<c:out value="${receita.getUnidades_id().getId()}"/>';">Editar</button> 
  			<button onclick="window.location.href='Receita_servlet?action=delete&cerveja_id=<c:out value="${receita.getCerveja_id().getId()}"/>&insumo_id=<c:out value="${receita.getInsumos_id().getId()}"/>&unidade_id=<c:out value="${receita.getUnidades_id().getId()}"/>';">Deletar</button></td>
			
		</tr>
		</c:forEach> 
	</table>
</body>
</html>