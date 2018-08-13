package com.agiles.UI.Cucumber;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.agiles.UI.selenide.TestUIAhorcado;
import com.codeborne.selenide.Selenide;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class CommonSteps {
	@Before
	public static void setupClass() {
	    ChromeDriverManager.getInstance().setup();
	}
	
	@Given("^an open browser with AhorcadoWeb/index\\.jsp$")
	public void an_open_browser_with_AhorcadoWeb_index_jsp() throws Throwable {
		new TestUIAhorcado().openBrowser();
	}
	
	
	@When("^I click the letter \"([^\"]*)\"$")
	public void i_click_the_letter(String letter) throws Throwable {
		if(letter.equals("ñ")){
			letter="enie";
		}
		$("#letter"+letter).click();
	}
}
