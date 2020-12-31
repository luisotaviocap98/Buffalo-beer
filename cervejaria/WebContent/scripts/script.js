/**
 * 
 */
function submitCerveja(){
	if (formCerveja.nome.value === ""){
		alert("Digite o nome");
		return false;
	}else if (formCerveja.alcool.value === ""){
		alert("Digite o indice alcoólico");
		return false;
		
	}else if (formCerveja.ml.value === ""){
		alert("Digite o volume em mililitros");
		return false;
	}else if (formCerveja.preco.value === ""){
		alert("Digite o preço");
		return false;
	}else{
		document.forms["formCerveja"].submit();
	}
}

function submitReceita(){
	if (formReceita.quantidade.value === ""){
		alert("Digite a quantidae");	
		return false;
	}else{
		document.forms["formReceita"].submit();
	}
}

function submitUnidade(){
	if (formUnidade.nome.value === ""){
		alert("Digite o nome");
		return false;	
	}else{
		document.forms["formUnidade"].submit();
	}
}

function submitInsumo(){
	 if (formInsumo.nome.value === ""){
		alert("Digite o nome");	
		return false;
	}else{
		document.forms["formInsumo"].submit();
	}
}