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
	<form name="formCerveja" action="Cerveja_servlet" method="post" onsubmit="return submitCerveja()">
		<table>	
			<tr>
				<td style="display:none;"><input type="hidden" name="id" value="<c:out value="${cerveja.id}"/>"></td>
				<td><input style="width:200px" type="text" pattern="[A-Za-z]{1,}" name="nome" placeholder="Nome" value="<c:out value="${cerveja.nome}"/>"></td>
			</tr>
			
			<tr>
				<td><input style="width:200px" type="number" min="0" max="100" step="0.1" name="alcool" placeholder="Indice alcoólico" value="<c:out value="${cerveja.indice_alcool}"/>"></td>
			</tr>
			
			<tr>
				<td><input style="width:200px" type="number"  min="0" name="ml" placeholder="Mililitros" value="<c:out value="${cerveja.mililitros}"/>"></td>
			</tr>
			
			<tr>
				<td><input style="width:200px" type="number" min="0"  name="preco" step="0.01" placeholder="Preço" value="<c:out value="${cerveja.preco}"/>"></td>
			</tr>
		</table>
		
		
		<input type="submit" value="Salvar"> 
		<button onclick="window.location.href='Cerveja_servlet?action=list';return false;">Cancelar</button>
	</form>
		<script src="scripts/script.js"></script>
</body>
</html>