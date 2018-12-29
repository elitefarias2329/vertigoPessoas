<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    
    <title>Vertigo Pessoas</title>
    
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
    <script src="${contextPath}/resources/js/jquery-3.3.1.js" ></script>
    <script src="${contextPath}/resources/js/pessoa/pessoa.js"></script>

</head>


<body>

	<div class="container">

		<form:form methodParam="POST" 
				   action="${contextPath}/pessoaView/salvar" 
				   modelAttribute="pessoa"
				   cssClass="form-signin"
				   id="formPessoa" >
				   
				   <h2 class="form-heading">Cadastrar Pessoa</h2>
				   
				   <div class="form-group">
				   		<form:input id="nomePessoa" path='nome' type='text' class="form-control" placeholder="Nome" />
				   		<div class="text-danger"><form:errors path="nome" /></div>
				   		 
				   </div>

				   <div class="form-group">
				   		<form:input id="sobrenomePessoa" path='sobrenome' type='text' class="form-control" placeholder="Sorbenome" />
				   		<div class="text-danger"><form:errors path="sobrenome" /></div>
				   </div>
				   
				   <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
				   
				   
					<c:if test="${not empty sucesso}">
				   		<br/>
				   		<div class="form-group">
				   			<div class="alert alert-success" role="alert">${sucesso}</div>
				   		</div>
				   </c:if>
				   
					<c:if test="${not empty listaPessoas}">
						<br/>
						<br/>
						<br/>
						<h2>Lista de Pessoas</h2>
				   		<table class="table  table-striped table-bordered  text-center ">
					  		<thead class="table-warning">
							    <tr>
							      <th scope="col">Nome</th>
							      <th scope="col">Sobrenome</th>
							    </tr>
							  </thead>
					  			<tbody>
					  			<c:forEach var="o" items="${listaPessoas}">
					    		<tr>
			                		<td>${o.nome}</td>
			                		<td>${o.sobrenome}</td>   
					            </tr>
			          			</c:forEach>
					  			</tbody>
						</table>
				   </c:if>

		</form:form>
	</div>
</body>
</html>
