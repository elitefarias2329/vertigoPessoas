$(function() {


	$( "#formPessoa" ).submit(function( event ) {
		  
		if(isPessoaValida()){
			$(this).submit();
		}
		else{
			alert("Os campos não podem estar em branco!");
			//event.preventDefault();	//cancela o submit
		}
		
	});


});




function isPessoaValida(){
	
	var isValido = true;
	
	if($( "#nomePessoa" ).val() == ''){
		isValido = false;
	}
	
	if($( "#sobrenomePessoa" ).val() == ''){
		isValido = false;
	}
	
	return isValido;
}