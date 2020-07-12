package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import utility.CommonMobileComponents;

public class MobileHomeScreen extends CommonMobileComponents{
	
	private MobileElement searchbox() {
		return appiumDriver.findElement(By.xpath("//*[@id='nav-search-keywords']"));
	}
	
	
	

			private MobileElement changeAddress() {
		return appiumDriver.findElement(By.id("glow-ingress-single-line"));
	}
			
			private WebElement usZipOption() throws InterruptedException {
				//waitTillElementVisible(By.id("GLUXMobilePostalCodeLink"));
				return appiumDriver.findElement(By.id("GLUXMobilePostalCodeLink"));
			}
			
			private MobileElement zipInput() {
				return appiumDriver.findElement(By.id("GLUXZipUpdateInput"));
			}
			
			private MobileElement applyButton() {
				return appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.app.Dialog/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
			}
			
			
			//android.widget.Button
	
	
	public void selectProduct(String productName) throws InterruptedException {
		//Thread.sleep(3000);
		searchbox().sendKeys(productName);
		searchbox().sendKeys(Keys.ENTER);
		
	}
	
	




	public void changeZipCode(String zipCode) throws InterruptedException {
		clickOn(changeAddress(),20);
		Thread.sleep(2000);
		do {
			
		usZipOption().click();
		
		System.out.println("Clicking");
		}while(!zipInput().isDisplayed());
		zipInput().sendKeys(zipCode);
		clickOn(applyButton(),20);
		
	}

}
