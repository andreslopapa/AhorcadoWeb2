package com.agiles;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UITestAhorcado {

	@Test
	public void ingresarUnaSolaLetra() {
		open("/AhorcadoWeb/");
		
		 $("#letraInput").setValue("h");
		 $("#submit").click();
		 
		 $("#letrasUsadas").shouldHave(text("h"));
	}
}
