package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.CommonUIComponents;

public class HomePage extends CommonUIComponents{
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(id = "searchDropdownBox")
	WebElement categories;
	
	@FindBy(xpath="//span[@id='nav-search-submit-text']/parent::div/input")
	WebElement searchIcon;
	
	@FindBy(xpath="//span[contains(text(),'Change Address')]/preceding-sibling::input")
	WebElement changeAddress;
	@FindBy(id="GLUXZipUpdateInput")
	WebElement zipInput;
	
	@FindBy(xpath="//span[@id = 'GLUXZipUpdate']/descendant::input")
	WebElement apply;
	@FindBy(xpath="//div[@class='a-popover-footer']/descendant::*[@id='GLUXConfirmClose']")
	WebElement continuebutton;
	@FindBy(xpath = "//span[contains(text(),'90201')]")
	WebElement confirmation;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void selectProduct(String productName) {
		explicitlyWait(this.searchbox,5);
		this.searchbox.sendKeys(productName);
		this.searchIcon.click();
		takeScreenshotAndAttachToReport();
	}

	public void changeZipcode(String zipCode) {
		this.changeAddress.click();
		explicitlyWait(this.zipInput,5);
		this.zipInput.sendKeys(zipCode);
		this.apply.click();
		explicitlyWait(this.continuebutton,30);
		this.continuebutton.click();
		explicitlyWait(confirmation, 5);
		Assert.assertTrue("Delivery location not updated", confirmation.isDisplayed());
		
		
	}

	

	
	
	

}
