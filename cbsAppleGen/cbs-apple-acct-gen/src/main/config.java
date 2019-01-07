package main;

//Change directory to meet your local or remote settings

public class config {
	
	//Use your selenium driver directory
	static private String ChromeDriverDirectory = "/Users/lcren1026/Drivers/chromedriver";
	//Use your csv driver directory
	private static String csvConfig = "/Users/lcren1026/Drivers/Apple Account Gen.csv";
	
	public static  String getCSVConfig(){
		return csvConfig;
	}
	
	public static String getChromeDriverDirectory(){
		return ChromeDriverDirectory;
	}

}


