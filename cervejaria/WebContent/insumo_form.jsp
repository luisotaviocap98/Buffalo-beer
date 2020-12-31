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
	<form name="formInsumo" method="post" action="Insumo_servlet" onsubmit="return submitInsumo()">
		<table>
			<tr>
				<td style="display:none;"><input type="hidden" name="id" value="<c:out value="${insumo.id}"/>"></td>
				<td><input type="text" pattern="[A-Za-z]{1,}" name="nome" placeholder="Nome" value="<c:out value="${insumo.nome}" />"></td>
			</tr>
		</table>
		<input type="submit" value="Salvar">
		<button onclick="window.location.href='Insumo_servlet?action=list';return false;">Cancelar</button>
	</form>
		<script src="scripts/script.js"></script>	
</body>
</html>