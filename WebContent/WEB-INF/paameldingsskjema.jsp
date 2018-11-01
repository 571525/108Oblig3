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
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned" action="paamelding">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> 
				<input type="text" name="fornavn" value="${paamelding.fornavn}" /> <font color="red">${paamelding.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> 
				<input type="text" name="etternavn" value="${paamelding.etternavn}" /> <font color="red">${paamelding.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> 
				<input type="text" name="mobil" value="${paamelding.mobil}" /> <font color="red">${paamelding.mobilFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> 
				<input type="password" name="passord" value="${paamelding.passord}" /> <span id="passIndik"><font color="red">${paamelding.passordFeil}</font></span>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> 
				<input type="password" name="passordRepetert" value="${paamelding.passordRepetert}" /> <font color="red">${paamelding.passordRepetertFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> 
				<input type="radio" name="kjonn" value="mann" <c:if test="${paamelding.kjonn==\"mann\"}">checked</c:if> />mann 
				<input type="radio" name="kjonn" value="kvinne" <c:if test="${paamelding.kjonn==\"kvinne\"}">checked</c:if>/>kvinne 
				<font color="red">${paamelding.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld meg på</button>
			</div>
		</fieldset>
	</form>

	<script type="text/javascript">
	<!--TODO validering og passord-->	
	</script>

</body>
</html>