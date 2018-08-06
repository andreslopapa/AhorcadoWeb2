package com.agiles;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UITestAhorcado {

	@Test
	public void indexInitialTest() {
		open("/AhorcadoWeb/");
		
		$("h2").shouldHave(text("Andres Manda Papa!"));
	}
}
