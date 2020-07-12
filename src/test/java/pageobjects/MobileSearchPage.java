package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import utility.CommonMobileComponents;

public class MobileSearchPage  extends CommonMobileComponents{
	
	private MobileElement filters() {
		return appiumDriver.findElement(By.id("s-all-filters"));
	}
	
	
	private MobileElement category() {
		return appiumDriver.findElement(By.xpath("//*[@id='departments']"));
	}
	
	private MobileElement selectcategory() {
		return appiumDriver.findElement(By.xpath("//android.view.View[@content-desc='Carrier Cell Phones']/android.view.View"));
	}


	public void selectCategory(String string) {
		try {
		if(category().isDisplayed()) {
		//category().click();
		selectcategory().click();
		}
		}
		catch(NoSuchElementException ex) {
			System.out.println("Filter not applied");
		}
	}


	public void selectColour(String colour) {
			WebElement colourOption = appiumDriver.findElement(By.xpath("//android.view.View[contains(text(),'"+colour+"')]/parent::a"));
			colourOption.click();
		}
}
