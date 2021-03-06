<%@page import="com.agiles.controladores.Ahorcado"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/inicio.css">
</head>
<body>
	<div class="container">
		<h1>Jugar ahorcado web</h1>
		<div class="crop-img"  >
			<img src=<%=request.getAttribute("urlHangman")==null?"images/playhangman1.png":request.getAttribute("urlHangman") %> alt="hangman" class="hangman">
		</div>
		
		<div>
		<span class="letras-palabra"><%=request.getAttribute("letrasPalabra")==null?new Ahorcado().mostrarPalabra():request.getAttribute("letrasPalabra") %></span>
		<br>
		<br>
		<%if(request.getAttribute("ganador")!=null && (Boolean)request.getAttribute("ganador")==true){ %>
		<div class="ganador-section">
			<h1 class="ganador-tit">
			Te salvaste!
			<br>
			<br>
			</h1>
		</div>
		<%}else if(request.getAttribute("perdedor")!=null && (Boolean)request.getAttribute("perdedor")==true){ %>
		<div class="perdedor-section">
			<h1 class="perdedor-tit">
			Perdiste!
			</h1>
			<br>
			<span class="palabraera">La palabra era:<%=" "+request.getAttribute("palabraera") %></span>
			<br>
			<br>
		</div>
		<%}else{ %>
		<span class="letrasUsadasTit">Letras usadas</span>
		<br> 
		<span id="letrasUsadas"><%= request.getAttribute("letrasUsadas")==null?"":request.getAttribute("letrasUsadas")%></span>
		<br>
		<br>
		<span class="errorestit">Errores Restantes:</span><span class="errores"><%=request.getAttribute("errores")==null?new Ahorcado().getErroresRestantes():request.getAttribute("errores") %></span>
		
		<br>
		<br>
		</div>
		
		<!-- <form method="POST" action="/AhorcadoWeb/AgregarLetra">
			<input type="text" id="letraInput" name="letraInput" maxlength="1">
			<input type="submit" id="submit" value="Aceptar">
		</form>  -->
		
		<div class="alphabets">
			<ul class="alphabet">
	                        <li><a id="lettera" href="AgregarLetra?letraInput=a">A</a></li>
	                        <li><a id="letterb" href="AgregarLetra?letraInput=b">B</a></li>
	                        <li><a id="letterc" href="AgregarLetra?letraInput=c">C</a></li>
	                        <li><a id="letterd" href="AgregarLetra?letraInput=d">D</a></li>
	                        <li><a id="lettere" href="AgregarLetra?letraInput=e">E</a></li>
	                        <li><a id="letterf" href="AgregarLetra?letraInput=f">F</a></li>
	                        <li><a id="letterg" href="AgregarLetra?letraInput=g">G</a></li>
	                        <li><a id="letterh" href="AgregarLetra?letraInput=h">H</a></li>
	                        <li><a id="letteri" href="AgregarLetra?letraInput=i">I</a></li>
	        </ul>
	        
	        <ul class="alphabet">
	                        <li><a id="letterj" href="AgregarLetra?letraInput=j">J</a></li>
	                        <li><a id="letterk" href="AgregarLetra?letraInput=k">K</a></li>
	                        <li><a id="letterl" href="AgregarLetra?letraInput=l">L</a></li>
	                        <li><a id="letterm" href="AgregarLetra?letraInput=m">M</a></li>
	                        <li><a id="lettern" href="AgregarLetra?letraInput=n">N</a></li>
	                        <li><a id="letter�" href="AgregarLetra?letraInput=enie">�</a></li>
	                        <li><a id="lettero" href="AgregarLetra?letraInput=o">O</a></li>
	                        <li><a id="letterp" href="AgregarLetra?letraInput=p">P</a></li>
	                        <li><a id="letterq" href="AgregarLetra?letraInput=q">Q</a></li>
	       </ul>
	       <ul class="alphabet lastalphabet">
	                        <li><a id="letterr" href="AgregarLetra?letraInput=r">R</a></li>
	                        <li><a id="letters" href="AgregarLetra?letraInput=s">S</a></li>
	                        <li><a id="lettert" href="AgregarLetra?letraInput=t">T</a></li>
	                        <li><a id="letteru" href="AgregarLetra?letraInput=u">U</a></li>
	                        <li><a id="letterv" href="AgregarLetra?letraInput=v">V</a></li>
	                        <li><a id="letterw" href="AgregarLetra?letraInput=w">W</a></li>
	                        <li><a id="letterx" href="AgregarLetra?letraInput=x">X</a></li>
	                        <li><a id="lettery" href="AgregarLetra?letraInput=y">Y</a></li>
	                        <li><a id="letterz" href="AgregarLetra?letraInput=z">Z</a></li>
	       </ul>
       </div>
       <br> 
       <%} %>
	   <a class="reiniciar" href="RestartGame">Reiniciar juego</a>
	</div>	
</body>
</html>
