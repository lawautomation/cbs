package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.Driver.driver;
import main.User.User;

public class main {
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
					  drive.findElement(By.cssSelector("#account_name_text_field")).sendKeys(Settings.getLogin());
					  drive.findElement(By.cssSelector("#sign-in")).click();
					  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password_text_field")));
					  drive.findElement(By.cssSelector("#password_text_field")).sendKeys(Settings.getPwd());
					  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sign-in")));
					  drive.findElement(By.cssSelector("#sign-in")).click();
					  drive.switchTo().defaultContent();	  
					 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#itc-user-profile-control-js > div:nth-child(1) > div:nth-child(1)")));
					 drive.findElement(By.cssSelector("#itc-user-profile-control-js > div:nth-child(1) > div:nth-child(1)")).click();	   
	 
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ReactVirtualized__Table__headerColumn:nth-child(1)")));
					 if ( User.territory() == "USA") {
						  drive.findElement(By.cssSelector("ul.tb-dropdown__list:nth-child(2) li[title='CBS Mobile']")).click();
					  }
					  
					  else {
						  drive.findElement(By.cssSelector("ul.tb-dropdown__list:nth-child(2) li[title='CBS All Access International LLC']")).click();   
					  }
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ReactVirtualized__Table__headerColumn:nth-child(1)")));
					 drive.findElement(By.cssSelector("div.dynamic-filter___2Jw5S:nth-child(3) > ul:nth-child(2) > li:nth-child(1)")).click();					  
					  				  
				  }catch(WebDriverException e) {

					  System.out.println("Try again. Sign in incorrect or generator timed out");
					  drive.close();
					  Thread.dumpStack();
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
	    	PrintWriter pw = new PrintWriter(new File(Settings.getCSVConfig()));
	    	byte c = 1;
	    	while ( c <= Settings.count) {
	    		  try {
	    			  String email = Settings.territory.email()+ (int)(Math.random()*10000) +".com";
	    			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#firstName")));	
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ReactVirtualized__Table__headerColumn:nth-child(1)")));
					  drive.findElement(By.cssSelector(".tb-icon--plus-alt-filled")).click();
					  drive.findElement(By.cssSelector("#firstName")).sendKeys(Settings.territory.firstName());
					  drive.findElement(By.cssSelector("#lastName")).sendKeys(Settings.territory.lastName());
					  drive.findElement(By.cssSelector("#email")).sendKeys(email);
					  drive.findElement(By.cssSelector("#password")).sendKeys(Settings.territory.password());
					  drive.findElement(By.cssSelector("#confirmPassword")).sendKeys(Settings.territory.confirmPwd());
					  drive.findElement(By.cssSelector("#secretQuestion")).sendKeys(Settings.territory.secretQ());
					  drive.findElement(By.cssSelector("#secretAnswer")).sendKeys(Settings.territory.secretA());

					  Select Monthdropdown = new Select(drive.findElement(By.cssSelector(".date-selector > div:nth-child(1) > select:nth-child(1)")));
					  Monthdropdown.selectByValue("9");
					  
					  Select Daydropdown = new Select(drive.findElement(By.cssSelector(".date-selector > div:nth-child(2) > select:nth-child(1)")));
					  Daydropdown.selectByValue("18");
					  
					  Select Countrydropdown = new Select(drive.findElement(By.cssSelector(".territory-selector > div:nth-child(1) > select:nth-child(1)")));
					  Countrydropdown.selectByValue(Settings.territory.territory());
					  
					  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.tb-btn--primary:nth-child(2)")));
					  drive.findElement(By.cssSelector("button.tb-btn--primary:nth-child(2)")).click();	
					   				       
					  csv csvWrite = new csv();
					  try {
						csvWrite.csvWriter(email, User.password(), c, pw );

					} catch ( FileNotFoundException e) {
						System.out.println("CSV directory not found and could not be created. Please go into config");
					}
					  				  
				  }catch(WebDriverException e)
				  {
					  //drive.close();
					  System.out.println("Try again. Account maybe already created");
				  }
				  	
				c++; }
	    	drive.close();
	    	pw.close(); }
}
