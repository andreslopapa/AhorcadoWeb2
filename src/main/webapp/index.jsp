<html>
<head>
<link rel="stylesheet" type="text/css" href="css/inicio.css">
</head>
<body>
<h1>Jugar ahorcado web</h1>

<div>Letras usadas <span id="letrasUsadas">
<%= request.getAttribute("letrasUsadas") %>
</span></div>

<form method="POST" action="/AhorcadoWeb/AgregarLetra">
	<input type="text" id="letraInput" name="letraInput">
	<input type="submit" id="submit" value="Aceptar">
	<a href="/AhorcadoWeb/RestartGame">Reiniciar juego</a>
</form>
</body>
</html>
