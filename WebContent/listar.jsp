<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clientes</title>
</head>
<body>
	<h2>Clientes</h2>
	<hr />
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Sexo</th>
			<th>Opções</th>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<input type="hidden" value="${cliente.id}">
			<tr>
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
				<td>${cliente.sexo}</td>
				<td><a href="Controlador?cmd=editar&id=${cliente.id}">Editar</a>
					<a href="Controlador?cmd=deletar&id=${cliente.id}">Deletar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="sistema.jsp">Cadastrar</a>
</body>
</html>