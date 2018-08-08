package com.agiles.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AgregarLetra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AgregarLetra() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Ahorcado juego;
		if(session.getAttribute("juego") != null) {
			juego = (Ahorcado)session.getAttribute("juego");
		} else {
			juego = new Ahorcado();
			
		}
		
		String letra = (String)request.getParameter("letraInput");
		if(letra.isEmpty()||letra==null){
			letra="";
		}else{
			juego.ingresarLetra(letra.charAt(0));
			
		}
		session.setAttribute("juego", juego);
		request.setAttribute("letrasUsadas", juego.getLetrasUsadas());
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
	}

}
