package test;

import cucumber.api.java.en.When;
import main.main;
import main.Driver.driver;

public class steps {
	
	@When("^user creates account$")
	 public void createAppleAcc() throws Exception {
		driver driver = new driver();	
		main.isSignIn();
		main.fillForm() ;
	    }
}
