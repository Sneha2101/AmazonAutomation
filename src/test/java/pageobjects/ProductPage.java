package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUIComponents;

public class ProductPage extends CommonUIComponents {

	@FindBy(id = "add-to-cart-button")
	WebElement addTocart;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void addtocart() {
		takeScreenshotAndAttachToReport();
		try {
			addTocart.click();
		} catch (NoSuchElementException ex) {
			scenario.write("Add to cart option not present");
		}

	}

}
