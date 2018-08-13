package com.agiles.UI.selenide;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import static com.codeborne.selenide.Selenide.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;


public class TestUIAhorcado {
	
	@Before
	public static void setupClass() {
	    ChromeDriverManager.getInstance().setup();
	}
	
	@Test
	public void ingresarUnaSolaLetra() {
		
		 openBrowser();
		 $("#letterh").click();
		 $("#letrasUsadas").shouldHave(text("h"));
		 $(".letras-palabra").shouldHave(text("h _ _ _ "));
		 $(".errores").shouldHave(text("4"));
		 $(".ganador-section").shouldNot(exist);
		 $(".perdedor-section").shouldNot(exist);
		 $(".hangman").isImage();
		 $(".hangman").shouldHave(attribute("src","http://localhost:8080/AhorcadoWeb/images/playhangman1.png"));
	}
	
	@Test
	public void juegoGanado() {
		
		 openBrowser();
		 $("#letterh").click();
		 $("#lettero").click();
		 $("#letterl").click();
		 $("#lettera").click();
		 $("#letrasUsadas").shouldNot(exist);
		 $(".letras-palabra").shouldHave(text("h o l a "));
		 $(".errores").shouldNot(exist);
		 $(".alphabets").shouldNot(exist);
		 $(".ganador-tit").shouldHave(text("Te Salvaste Perro!"));
		 $(".perdedor-section").shouldNot(exist);
		 $(".hangman").isImage();
		 $(".hangman").shouldHave(attribute("src","http://localhost:8080/AhorcadoWeb/images/playhangman1.png"));
	}
	
	@Test
	public void juegoPerdido() {
		
		 openBrowser();
		 $("#letterg").click();
		 $("#letterr").click();
		 $("#lettere").click();
		 $("#lettert").click();
		 $("#letterz").click();
		 $("#letrasUsadas").shouldNot(exist);
		 $(".letras-palabra").shouldHave(text("_ _ _ _ "));
		 $(".errores").shouldNot(exist);
		 $(".alphabets").shouldNot(exist);
		 $(".ganador-section").shouldNot(exist);
		 $(".perdedor-tit").shouldHave(text("Perdiste Perro!"));
		 $(".palabraera").shouldHave(text("La palabra era: hola"));
		 $(".hangman").isImage();
		 $(".hangman").shouldHave(attribute("src","http://localhost:8080/AhorcadoWeb/images/playhangman6.png"));
	}
	
	@Test
	public void juegoGanadoConCincoLetras(){
		openBrowser();
		 $("#letterh").click();
		 $("#letterr").click();
		 $("#letterl").click();
		 $("#lettera").click();
		 $("#lettero").click();
		 $("#letrasUsadas").shouldNot(exist);
		 $(".letras-palabra").shouldHave(text("h o l a "));
		 $(".errores").shouldNot(exist);
		 $(".alphabets").shouldNot(exist);
		 $(".ganador-tit").shouldHave(text("Te Salvaste Perro!"));
		 $(".perdedor-section").shouldNot(exist);
		 $(".hangman").isImage();
		 $(".hangman").shouldHave(attribute("src","http://localhost:8080/AhorcadoWeb/images/playhangman2.png"));
	
	}
	
	
	
	public void openBrowser(){
		
		try{
//		System.setProperty("webdriver.chrome.driver","/usr/bin/google-chrome");
		ChromeDriverManager.getInstance().setup();
		String urlToRemoteWD = "http://localhost:4444/wd/hub";
		RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD),DesiredCapabilities.chrome());
		WebDriverRunner.setWebDriver(driver);
		
		System.setProperty("selenide.browser", "Chrome");
//		WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
//		SeleniumServer _server = new SeleniumServer(); 
//		_server.boot(); 
//		_server.start();
	    open("/AhorcadoWeb/index.jsp");
	    Selenide.clearBrowserCookies();
	    /*when you launch selenium it creates a 
	     * temporary profile and when you close it,selenium deletes it*/}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}


