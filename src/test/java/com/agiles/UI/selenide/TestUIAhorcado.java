package com.agiles.UI.selenide;

import org.junit.Assert;
import org.junit.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.*;


public class TestUIAhorcado {

	
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
		 Assert.assertTrue($(".hangman").getAttribute("src").matches(".*/images/playhangman1.png"));
		 
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
		 $(".ganador-tit").shouldHave(text("Te Salvaste!"));
		 $(".perdedor-section").shouldNot(exist);
		 $(".hangman").isImage();
		 Assert.assertTrue($(".hangman").getAttribute("src").matches(".*/images/playhangman1.png"));
		 
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
		 $(".perdedor-tit").shouldHave(text("Perdiste!"));
		 $(".palabraera").shouldHave(text("La palabra era: hola"));
		 $(".hangman").isImage();
		 Assert.assertTrue($(".hangman").getAttribute("src").matches(".*/images/playhangman6.png"));
		 
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
		 $(".ganador-tit").shouldHave(text("Te Salvaste!"));
		 $(".perdedor-section").shouldNot(exist);
		 $(".hangman").isImage();
		 Assert.assertTrue($(".hangman").getAttribute("src").matches(".*/images/playhangman2.png"));
		 
	
	}
	
	
	
	public static void openBrowser(){
		
		try{

			System.setProperty("selenide.browser", "chrome");
			WebDriverRunner.clearBrowserCache();
			if(!System.getProperty("user.name").toLowerCase().equals("travis")){
				open("http://localhost:8080/AhorcadoWeb/");
			}
			else{
				String urlToRemoteWD = "http://localhost:4444/wd/hub";
				System.setProperty("webdriver.chrome.driver","/home/travis/virtualenv/chromedriver");
				Configuration.remote=urlToRemoteWD;
				WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				open("http://ahorcadoweb.jelastic.saveincloud.net/index.jsp");
			}
			Selenide.clearBrowserCookies();
			
			
		    
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}


