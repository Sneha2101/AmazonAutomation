package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class CommonUIComponents extends StepDefinitionBase{
	
	
	
	public void explicitlyWait(WebElement element, int timeout) {
	WebDriverWait waitForElement = new WebDriverWait(driver, timeout);
	waitForElement.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void refresh() {
		driver.navigate().refresh();
		
	}
	
	public void takeScreenshotAndAttachToReport() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		   // embed it in the report.
		      scenario.embed(screenshot, "image/png"); 
		
	}

}
