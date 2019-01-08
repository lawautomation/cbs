package main.Driver;

import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class desiredCap {

	 public static void getDesiredCapability() {
		  ChromeOptions cleanSession = new ChromeOptions(); 
		  cleanSession.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		  cleanSession.setCapability("chrome.switches", Arrays.asList("--incognito")); }
	 }
