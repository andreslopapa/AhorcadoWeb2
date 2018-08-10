package com.agiles.UI.Cucumber;

import com.codeborne.selenide.Configuration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;

public class WinTheGameStepDefinitions {
	@Given("^an open browser with AhorcadoWeb/index\\.jsp$")
	public void an_open_browser_with_AhorcadoWeb_index_jsp() throws Throwable {
//		ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        System.setProperty("webdriver.chrome.driver","/usr/bin/google-chrome");
//        WebDriver browser = new ChromeDriver(options);
        
		Configuration.browser = "chrome";
	    Configuration.startMaximized = false;
        
	    open("/AhorcadoWeb/index.jsp");
	}
	
	@When("^I click the letter \"([^\"]*)\"$")
	public void i_click_the_letter(String letter) throws Throwable {
		if(letter.equals("ñ")){
			letter="enie";
		}
		$("#letter"+letter).click();
	}
	

	@Then("^a message saying \"([^\"]*)\" should appear$")
	public void a_message_saying_should_appear(String winTit) throws Throwable {
		$(".ganador-tit").shouldHave(text(winTit));
	}

	@Then("^the keyboard should disappear$")
	public void the_keyboard_should_disappear() throws Throwable {
		$(".alphabets").shouldNot(exist);
	}

	@Then("^the remaining errors should disappear$")
	public void the_remaining_errors_should_disappear() throws Throwable {
		$(".errorestit").shouldNot(exist);
		$(".errores").shouldNot(exist);
	}

	@Then("^the entered letters should disappear$")
	public void the_entered_letters_should_disappear() throws Throwable {
		$(".letrasUsadasTit").shouldNot(exist);
		$(".letrasUsadas").shouldNot(exist);
	}


}
