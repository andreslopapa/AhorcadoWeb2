package com.agiles;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class UITestAhorcado {
	
	
	@Test
	public void ingresarUnaSolaLetra() {
		System.setProperty("selenide.browser", "chrome");
		open("/AhorcadoWeb/");
		

//		 $("#letraInput").setValue("h");
//		 $("#submit").click();
		 $("#letterh").click();
		 $("#letrasUsadas").shouldHave(text("h"));
	}
}
