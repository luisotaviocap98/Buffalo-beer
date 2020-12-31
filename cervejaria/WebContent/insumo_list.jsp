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

	<button  onclick="window.location.href='Insumo_servlet?action=add';">Adicionar</button>
	<table>
  		<tr>

    		<th>Nome</th>
    		<th>Opções</th>
  		</tr>

  		<c:forEach items="${insumos}" var="insumo">
  		<tr>

  			<td><c:out value="${insumo.nome}"></c:out></td>
  			<td><button onclick="window.location.href='Insumo_servlet?action=edit&id=<c:out value="${insumo.id}"/>';">Editar</button> 
  			<button onclick="window.location.href='Insumo_servlet?action=delete&id=<c:out value="${insumo.id}"/>';">Deletar</button></td>
		</tr>
  		</c:forEach>
	</table>
</body>
</html>