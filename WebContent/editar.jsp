<%@page import="entity.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
</head>
<body>
	<h2>Editar Cliente</h2>
	<hr />
	<form id="form1" method="post" action="Controlador?cmd=atualizar&id=${editar.id}">
		<input type="hidden" value="${editar.id}"/>
		<table>
			<tr>
				<td>Nome: 
				<input type="text" name="nome" value="${editar.nome}"/></td>
			</tr>
			<tr>
				<td>Email: 
				<input type="text" name="email" value="${editar.email}" /></td>
			</tr>
			<tr>
				<td>Sexo: 
				<input type="radio" name="sexo" value="M"/>Masculino
				<input type="radio" name="sexo" value="F"/>Feminino</td>
			</tr>
			<tr>
			<td><input type="submit" value="Gravar"/>
			<a href="Controlador?cmd=listar">Listar</a></td>
			</tr>
		</table>
	</form>
	${msg}
</body>
</html>