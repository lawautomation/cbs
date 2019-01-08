package main;

import main.Creds.creds;
import main.User.User;
import main.User.userEnum;

public class Settings implements creds{
	
	//login and password settings
	private final static String LOGIN = "email@email.com";
	private final static String PASSWORD = "pws";
	
	//selenium driver settings
	static private String ChromeDriverDirectory = "/Users/lcren1026/Drivers/chromedriver";
	private static String csvConfig = "/Users/lcren1026/Drivers/Apple Account Gen.csv";
	
	//Territory and Emails settings
	static User territory= new User(userEnum.AU);  //Change territory to US, AU, or CAN
	static byte count = 2; // How many emails you want to create.
		
	public static  String getCSVConfig(){
			return csvConfig;
	}
		
	public static String getChromeDriverDirectory(){
		return ChromeDriverDirectory;
	}	
	
	public static String getLogin(){
		return LOGIN;	
}

   public static String getPwd(){
	return PASSWORD;	
}
	
}






