package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.Creds.crediential;
import main.Driver.driver;
import main.User.User;
import main.User.userEnum;

public class main {
	
	static crediential cred = new crediential();
	
	//CHANGE ENUM SETTINGS TO CANAccount for CANADA OR AUACCOUNT for Australia
	static User info = new User(userEnum.USAccount);
	static String URL = "https://appstoreconnect.apple.com/access/testers";
	

	public static  void isSignIn() throws InterruptedException, IOException 
	{			
		WebDriver drive = driver.getdriver();
		try
		{	
			WebDriverWait wait = new WebDriverWait(drive, 60);
				  try {
					  driver.getdriver().navigate().to(URL);
					  
					  wait.until(ExpectedConditions.elementToBeClickable(By.id("aid-auth-widget-iFrame")));					  
					  drive.switchTo().frame("aid-auth-widget-iFrame");                      
					  drive.findElement(By.cssSelector("#account_name_text_field")).sendKeys(cred.getLogin());
					  drive.findElement(By.cssSelector("#sign-in")).click();
					  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password_text_field")));
					  drive.findElement(By.cssSelector("#password_text_field")).sendKeys(cred.getPwd());
					  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sign-in")));
					  drive.findElement(By.cssSelector("#sign-in")).click();
					  drive.switchTo().defaultContent();
					  drive.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					  boolean invisible2 = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(("async-loader-container___2bt-2"))));
					  
					  if ( invisible2)
					  {
						  drive.findElement(By.cssSelector("div.dynamic-filter___2Jw5S:nth-child(3) > ul:nth-child(2) > li:nth-child(1)")).click();
					  }
					  
				  }catch(WebDriverException e) {

					  System.out.println("Try again. Sign in incorrect or generator timed out");
					  drive.close();
				  } 
				  
				  try
				  {
					  drive.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					  boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(("async-loader-container___2bt-2"))));
					  
					  if ( invisible)
					  {
						  drive.findElement(By.cssSelector(".tb-icon--plus-alt-filled")).click();
					  }
				  }catch(TimeoutException e) {
					  drive.close();
					  System.out.println("Try again. Generator timed out");
				  }
			  
		  }catch  (WebDriverException e) 
		  {
			  Thread.currentThread().getStackTrace();
			  Thread.dumpStack();
		  }			
	}	  	    
	    public static void fillForm() throws IOException, FileNotFoundException  {
	    	WebDriver drive = driver.getdriver();
	    	WebDriverWait wait = new WebDriverWait(drive, 60);
			  try {
				  drive.findElement(By.cssSelector("#firstName")).sendKeys(info.firstName());
				  drive.findElement(By.cssSelector("#lastName")).sendKeys(info.lastName());
				  drive.findElement(By.cssSelector("#email")).sendKeys(info.email());
				  drive.findElement(By.cssSelector("#password")).sendKeys(info.password());
				  drive.findElement(By.cssSelector("#confirmPassword")).sendKeys(info.confirmPwd());
				  drive.findElement(By.cssSelector("#secretQuestion")).sendKeys(info.secretQ());
				  drive.findElement(By.cssSelector("#secretAnswer")).sendKeys(info.secretA());

				  Select Monthdropdown = new Select(drive.findElement(By.cssSelector(".date-selector > div:nth-child(1) > select:nth-child(1)")));
				  Monthdropdown.selectByValue("9");
				  
				  Select Daydropdown = new Select(drive.findElement(By.cssSelector(".date-selector > div:nth-child(2) > select:nth-child(1)")));
				  Daydropdown.selectByValue("18");
				  
				  Select Countrydropdown = new Select(drive.findElement(By.cssSelector(".territory-selector > div:nth-child(1) > select:nth-child(1)")));
				  Countrydropdown.selectByValue(info.territory());
				  				  
			  }catch(WebDriverException e)
			  {
				  //drive.close();
				  System.out.println("Try again. Account maybe already created");
			  }
			  
			  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.tb-btn--primary:nth-child(2)")));
			  drive.findElement(By.cssSelector("button.tb-btn--primary:nth-child(2)")).click();			  	
			 // drive.close();
			  
			  csv csvWrite = new csv();
			  try {
				csvWrite.csvWriter(User.email(), User.password() );
			} catch ( FileNotFoundException e) {
				System.out.println("CSV directory not found and could not be created. Please go into config");
			}
	    }

}
