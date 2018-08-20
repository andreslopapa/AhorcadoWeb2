package com.agiles.UI.Cucumber;

import static com.codeborne.selenide.Selenide.$;
import com.agiles.UI.selenide.TestUIAhorcado;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonSteps {

	
	@Given("^an open browser with AhorcadoWeb/index\\.jsp$")
	public void an_open_browser_with_AhorcadoWeb_index_jsp() throws Throwable {
		TestUIAhorcado.openBrowser();
	}
	
	
	@When("^I click the letter \"([^\"]*)\"$")
	public void i_click_the_letter(String letter) throws Throwable {
		if(letter.equals("ñ")){
			letter="enie";
		}
		$("#letter"+letter).click();
	}
}
