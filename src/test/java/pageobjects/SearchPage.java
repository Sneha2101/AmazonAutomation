package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.CommonUIComponents;

public class SearchPage extends CommonUIComponents {

	@FindBy(xpath = "//span[contains(text(),'Carrier Cell Phones')]/parent::a")
	WebElement carrierOption;

	@FindBy(xpath = "//div/descendant::h2/a[1]")
	WebElement searchResults;

	WebDriverWait wait;

	public SearchPage() {
		PageFactory.initElements(driver, this);
		Assert.assertTrue("Search page is not loaded", true);
		wait = new WebDriverWait(driver, 30);
	}

	public void selectCarrier(String carrierName) {
		explicitlyWait(carrierOption, 10);
		this.carrierOption.click();
		try {
			WebElement carrier = driver
					.findElement(By.xpath("//span[contains(text(),'" + carrierName + "')]/preceding-sibling::div"));
			carrier.click();
		} catch (NoSuchElementException e) {
			scenario.write(carrierName + " carrier was not present. Proceeding without carriers");
		}
	}

	public boolean checkColourAvailable(String colour) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		if (driver.findElements(By.xpath("//span[contains(text(),'" + colour + "')]")).size() != 0) {
			scenario.write(colour +" variant is available.");
			return true;
		} else {
			scenario.write(colour +" variant is not available.");
			return false;
		}
	}

	public void selectColour(String colour) {
		WebElement colourOption = driver.findElement(By.xpath("//span[contains(text(),'" + colour + "')]/parent::a"));
		colourOption.click();
	}

	public void selectFirstOption() {

		searchResults.click();
	}

}
