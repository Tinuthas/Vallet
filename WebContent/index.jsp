<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty USUARIO}">
			<fieldset>
				<legend>Efetuar login:</legend>
				<form action="controller" method="post">
					<input id="login" name="login" placeholder="Digite seu login"><br>
					<input id="senha" name="login" placeholder="Digite sua senha"><br>
					<button name="enviar" value="Login">Enviar</button>
				</form>
			</fieldset>
		</c:when>
		<c:otherwise>
			<div class="bemVindo">
				<p>Bem-Vindo ${USUARIO.login} |</p>
				<form action="controller" method="post" id="deslogar">
					<input type="hidden" name="enviar" value="Logout"> <a
						href="#" onClick="document.getElementById('deslogar').submit();">Deslogar</a>
				</form>
			</div>

			<fieldset>
				<legend>Dados de entrada</legend>
				<form action="controller" method="post">
					<input id="modelo" placeholder="Digite o modelo do veiculo"
						name="modelo"><br> <input id="modelo"
						placeholder="Digite a placa do veiculo (AAA-9999)" name="placa"><br>
					<button name="enviar" value="Recibo">Cadastrar entrada</button>
				</form>
			</fieldset>
			
			<div class="veiculoEstacionado">
				<table>
					<thead>
						<tr>
							<th>Modelo</th>
							<th>Placa</th>
							<th>Entrada</th>
							<th>Ações</th>
						</tr>
						<c:forEach var="veiculo" items="${LISTAVEICULO}">
							<tr>
								<td>${veiculo.modelo}</td>
								<td>${veiculo.placa}</td>
								<td>${veiculo.entrada}</td>
								<td>
									<button>Saída</button>
								</td>
							</tr>
						</c:forEach>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
	
</body>
</html>