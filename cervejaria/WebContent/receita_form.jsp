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
	<form name="formReceita" action="Receita_servlet" method="post" onsubmit="return submitReceita()">
		<p style="display:inline">Cerveja:</p>
		<select name="Cerveja">
			<c:forEach items="${cervejas}" var="cerveja">
				<option value="${cerveja.id}">${cerveja.nome}</option>
			</c:forEach>
		</select>
		<br>
		<p style="display:inline">Ingrediente:</p>
		
		<div  style="display:inline">
	        <select name="ingrediente">
	        	<c:forEach items="${insumos}" var="insumo">
	        		<option value="${insumo.id}">${insumo.nome}</option>
        		</c:forEach>
	        </select>
	        <input style="width:100px" type="number" min="0" name="quantidade" value="${quantidade}" placeholder="Quantidade"/>
	        <select name="unidade" >
	        	<c:forEach items="${unidades}" var="unidade">
	        		<option value="${unidade.id}">${unidade.nome}</option>
        		</c:forEach>
	        </select>
		</div>
		<br>
		<input type="submit" value="Salvar"> 
		<button onclick="window.location.href='Receita_servlet?action=list';return false;">Cancelar</button>		
	</form>
<script src="scripts/script.js"></script>
</body>
</html>



		<%-- 
		<script src="jquery-3.5.1.min.js"></script>
		<script>
		$(document).ready(function() {
		    var max_fields = 10;
		    var wrapper = $(".container1");
		    var add_button = $(".add_form_field");

		    
		    $(add_button).click(function(e) {
		        e.preventDefault();
		        
		        $(wrapper).append('<div>'+
		        '<select name="ingrediente[]"><c:forEach items="${insumos}" var="insumo"><option value="${insumo.id}">${insumo.nome}</option></c:forEach></select>'+
		        '<input type="number" min="0" name="quantidade" value="${quantidade}" placeholder="Quantidade"/>'+
		        '<select name="unidade[]" ><c:forEach items="${unidades}" var="unidade"><option value="${unidade.id}">${unidade.nome}</option></c:forEach></select>'+
		        '<a href="#" class="delete">Remover</a></div>'); //add input box
		        
		    });

		    $(wrapper).on("click", ".delete", function(e) {
		        e.preventDefault();
		        $(this).parent('div').remove();
		        
		    });

		}); 
		</script>

		<div class="container1">
    		<button class="add_form_field">Adicionar ingrediente &nbsp; 
      		<span style="font-size:16px; font-weight:bold;">+ </span>
    		</button>
		</div> 
		--%>