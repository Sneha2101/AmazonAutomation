package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonMobileComponents extends StepDefinitionBase{
	
	
	
//	public void explicitlyWait(WebElement element, int timeout) {
//	WebDriverWait waitForElement = new WebDriverWait(driver, timeout);
//	waitForElement.until(ExpectedConditions.visibilityOf(element));
//	}
	
	public void clickOn(MobileElement element,int timeOut) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		System.out.println("Clicked on element");
	}
	
	public int waitTillElementVisible(By by) throws InterruptedException {
		int counter=1;
		
		
		do {
		try {
		
		if( appiumDriver.findElement(by).isDisplayed())
		{
			break;
		}
		}
		catch(NoSuchElementException ex)
		{
			counter++;
			System.out.println("Waiting for "+counter+" sec");
			Thread.sleep(1000);
		}
	}while(counter<=20);
		return counter;
	}

}
