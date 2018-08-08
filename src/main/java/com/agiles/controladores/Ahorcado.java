package com.agiles.controladores;

import java.util.ArrayList;

import com.agiles.modelos.Palabra;

public class Ahorcado {
	private ArrayList<Palabra> palabras;
	private char[] palabraActual;
	private char[] letrasIngresadas;
	private int cantidadLetrasIngresadas;
	private int erroresRestantes;
	
	public Ahorcado() {
		cantidadLetrasIngresadas = 0;
		erroresRestantes = 4;
		
		palabras = new ArrayList<Palabra>();
		palabras.add(new Palabra("hola"));
		seleccionarPalabra("hola");
		letrasIngresadas = new char[palabraActual.length+erroresRestantes];
	}
	
	public void seleccionarPalabra(String palabraSeleccionada) {
		for(Palabra palabra : palabras) {
			if(new String(palabra.getPalabra()).equals(palabraSeleccionada)) {
				palabraActual = palabra.getPalabra();
				return;
			}
		}
		
		Palabra seleccionada = new Palabra(palabraSeleccionada);
		palabras.add(seleccionada);
		palabraActual = seleccionada.getPalabra();
	}
	
	
	
	public void ingresarLetra(char letra) {
		
		for(char letraI:letrasIngresadas){
			if(letraI==letra){
				return;
				/*para verificar que no este ya*/
			}
		}
		letrasIngresadas[cantidadLetrasIngresadas] = letra;
		cantidadLetrasIngresadas++;
		
		boolean existeEnPalabra = false;
	
		for(char letraPalabra : palabraActual) {
			if(letraPalabra == letra) {
				existeEnPalabra = true;
			}
		}
		
		if(!existeEnPalabra) {
			erroresRestantes--;
		}
		
	}
	
	public int getErroresRestantes() {
		return erroresRestantes;
	}
	
	public boolean isGanador() {
		int letrasBien = 0;
		//int letrasBienAnterior;
		
		for(char letraIngresada : letrasIngresadas) {
			/* letrasBienAnterior = 0;;
			*/
			for(char letraPalabra : palabraActual) {
				if(letraIngresada == letraPalabra) {
					letrasBien++;
				}
			} 
			
			
//			if(palabraActual[letrasBien] == letraIngresada) {
//				letrasBien++;
//			} 
		}
		
		if(letrasBien >= palabraActual.length && erroresRestantes > 0) {
			return true;
		} 
		
		return false;
	}
	
	public String getLetrasUsadas() {
		String concatenado = "";
		for(char letra : letrasIngresadas) {
			if(letra != '\u0000') {
				concatenado+= letra;
			}
		}
		return concatenado;
	}
	
	public String mostrarPalabra() {
		String palabraMostrar = "";
		
		boolean letraExiste = false;
		
		for(char letraPalabra : palabraActual) {
			letraExiste = false;
			
			for(char letraIngresada : letrasIngresadas) {
				if(letraIngresada == letraPalabra) {
					letraExiste = true;
				}
			} 
			
			if(letraExiste) {
				palabraMostrar += letraPalabra+" ";
			} else {
				palabraMostrar += "_ ";
			}
		}
		
		return palabraMostrar;
	}
	
	public void ingresarPalabra(String palabra) {
		for(char letra : palabra.toCharArray()) {
			ingresarLetra(letra);
		}
	}
	
	public int getCantidadPalabras() {
		return palabras.size();
	}
	
	public void addPalabra(String palabra) {
		palabras.add(new Palabra(palabra));
		letrasIngresadas = new char[palabra.length()+erroresRestantes];
	}
	
	public String getPalabraActual(){
		return new String(this.palabraActual);
	}
}
