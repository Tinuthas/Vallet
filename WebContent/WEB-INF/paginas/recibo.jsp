<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recibo</title>
</head>
<body>

<div class="recibo">
	<p>Modelo: ${VEICULO.modelo}</p>
	<p>Placa: ${VEICULO.placa}</p>
	<p>Hora de entrada: ${VEICULO.entrada}</p>
	<p>Hora de saida: ${VEICULO.saida}</p>
	<p>Valor pago: ${VEICULO.preco}</p>
	<a href="index.jsp">Volta para página inicial</a>
</div>

</body>
</html>