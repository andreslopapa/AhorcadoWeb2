package com.agiles;

import static org.junit.Assert.*;

import org.junit.Test;

import com.agiles.controladores.Ahorcado;

public class TestAhorcado {
	
	@Test
	public void ingresarUnaSolaLetra() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('h');
		
		String letra = ahorcado.getLetrasUsadas();
		
		assertEquals("h", letra);
	}
	
	@Test
	public void juegoGanado() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('h');
		ahorcado.ingresarLetra('o');
		ahorcado.ingresarLetra('l');
		ahorcado.ingresarLetra('a');
		
		boolean ganador = ahorcado.isGanador();
		
		assertEquals(true, ganador);
	}
	
	@Test
	public void juegoPerdido() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('h');
		ahorcado.ingresarLetra('a');
		ahorcado.ingresarLetra('l');
		ahorcado.ingresarLetra('a');
		
		boolean ganador = ahorcado.isGanador();
		
		assertEquals(false, ganador);
	} 
	
	@Test
	public void juegoGanadoConCincoLetras() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('p');
		ahorcado.ingresarLetra('j');
		ahorcado.ingresarLetra('n');
		
		int errores = ahorcado.getErroresRestantes();
		
		assertEquals(1, errores);
	}  
	
	@Test
	public void finConErroresRestantesCero() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('p');
		ahorcado.ingresarLetra('j');
		ahorcado.ingresarLetra('m');
		ahorcado.ingresarLetra('d');
		
		int errores = ahorcado.getErroresRestantes();
		
		assertEquals(0, errores);
	} 
	
	@Test
	public void mostrarLetrasIngresadas() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('p');
		ahorcado.ingresarLetra('j');
		ahorcado.ingresarLetra('n');
		
		String letras = ahorcado.getLetrasUsadas();
		
		assertEquals("pjn", letras);
	}
	
	@Test
	public void irMostrandoPalabra() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarLetra('h');
		ahorcado.ingresarLetra('j');
		ahorcado.ingresarLetra('l');
		
		String mostrado = ahorcado.mostrarPalabra();
		
		assertEquals("h_l_", mostrado);
	}


	@Test
	public void ingresarPalabraCompleta() {
		Ahorcado ahorcado = new Ahorcado();
		
		ahorcado.ingresarPalabra("hola");
		
		String mostrado = ahorcado.getLetrasUsadas();
		
		assertEquals("hola", mostrado);
	}
	
	@Test
	public void cargarNuevaPalabra() {
		Ahorcado ahorcado = new Ahorcado();

		int cantidadAntes = ahorcado.getCantidadPalabras(); 
		ahorcado.addPalabra("hola");
		int cantidadDespues = ahorcado.getCantidadPalabras();
		
		assertTrue(cantidadDespues == (cantidadAntes+=1));
	}
	
	@Test
	public void seleccionarPalabra() {
		Ahorcado ahorcado = new Ahorcado();

		ahorcado.seleccionarPalabra("hola");
		juegoGanado();
	}
}
