package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepDefinitionBase {
	public static WebDriver driver;
	public static AppiumDriver<MobileElement> appiumDriver;
	public static String environment;
	public static Scenario scenario;
	
	public void loadUrl(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\eclipse-workspace\\AmazonAutomation\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
	    driver.get(url);
	   
	    
	}
	
	
	public void launchChrome(String url) throws MalformedURLException, InterruptedException {
DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "OnePlus 5T");
		caps.setCapability("udid", "31d57fcf"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		appiumDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);	
		appiumDriver.get(url);
	}
	
	public void launchURLinEmulator(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\eclipse-workspace\\AmazonAutomation\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();	
		
		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "Nexus 5");


		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);
	    driver.get(url);
		
	}

}
