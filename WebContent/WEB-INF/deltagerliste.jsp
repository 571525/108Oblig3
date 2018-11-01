<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="delt" items="${deltagere}">
			<c:if test="${delt.mobil==eier }">
				<tr bgcolor="#aaffaa">
					<c:if test="${delt.kjonn}">
						<td align="center">&#9792;</td>
					</c:if>
					<c:if test="${!delt.kjonn}">
						<td align="center">&#9794;</td>
					</c:if>
					<td>${delt.fornavn} ${delt.etternavn}</td>
					<td>${delt.mobil}</td>
				</tr>
			</c:if>
			<c:if test="${delt.mobil!=eier }">
				<tr>
					<c:if test="${delt.kjonn}">
						<td align="center">&#9792;</td>
					</c:if>
					<c:if test="${!delt.kjonn}">
						<td align="center">&#9794;</td>
					</c:if>
					<td>${delt.fornavn} ${delt.etternavn}</td>
					<td>${delt.mobil}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<p>
		<a href="logginn">Ferdig</a>
	</p>
</body>
</html>