package main.Driver;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.config;


public class driver {
	static String ChromeDriverEXE = "webdriver.chrome.driver";
	public static WebDriver driver;	

	public driver() throws IOException {		
		try
		{
			  if (driver == null) {
				  desiredCap.getDesiredCapability();
				  System.setProperty(ChromeDriverEXE, config.getChromeDriverDirectory());
			      driver = new ChromeDriver();
		}		  
		  }catch  (IllegalStateException | java.lang.NullPointerException e) 
		  {
			  System.out.println("Webdriver is not pointed to the right directory. Please see Stack Trace below:");
		  }
		return;
	}
	
   public static WebDriver getdriver() {
	   return driver;
   }
}
