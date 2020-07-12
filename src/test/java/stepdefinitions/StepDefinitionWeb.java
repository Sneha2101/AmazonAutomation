package stepdefinitions;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageobjects.HomePage;
import pageobjects.MobileHomeScreen;
import pageobjects.MobileSearchPage;
import pageobjects.ProductPage;
import pageobjects.SearchPage;
import utility.ReportUtil;
import utility.StepDefinitionBase;

public class StepDefinitionWeb extends StepDefinitionBase {
	HomePage hp;
	SearchPage sp;
	ProductPage pp;
	MobileHomeScreen mhs;
	MobileSearchPage msp;
	boolean coloursAvailable;

	@Given("^Amazon is open on \"([^\"]*)\"$")
	public void amazon_is_open_on_something(String browserType) throws Throwable {
		switch (browserType) {
		case "Web Browser":
			loadUrl("https://www.amazon.com");
			hp = new HomePage();
			environment = "web";
			scenario.write("Starting execution on Web Browser");
			break;
		case "Mobile browser":
			launchChrome("https://www.amazon.com");
			mhs = new MobileHomeScreen();
			environment = "mobile";
			scenario.write("Starting execution on Mobile Web Browser");
			break;
		default:
			driver.quit();
			scenario.write("Correct environment not present. Exiting !!!");
			break;
		}

	}

	@When("^User searches for \"([^\"]*)\"$")
	public void user_searches_for(String productName) throws Throwable {
		switch (environment) {
		case "web":
			hp.selectProduct(productName);
			break;
		case "mobile":
			mhs.selectProduct(productName);
			break;
		default:
			driver.quit();
			scenario.write("Correct environment not present. Exiting !!!");
			break;
		}

	}

	@Then("^verifies whether following options are available as options in the search results page 1$")
	public void verifies_whether_following_options_are_available_as_options_in_the_search_results_page_1(DataTable dt)
			throws Throwable {

		List<String> colours = dt.asList(String.class);

		SoftAssert as = new SoftAssert();
		for (String colour : colours) {
			if (environment.equals("web")) {
				coloursAvailable = sp.checkColourAvailable(colour);
				as.assertTrue(coloursAvailable);
			} else {
				coloursAvailable = true;
			}
		}

	}

	@Then("^user adds the product to the cart$")
	public void user_adds_the_product_to_the_cart() throws Throwable {
		pp = new ProductPage();
		pp.addtocart();

	}

	@And("^user then looks for variants locked to the carrier \"([^\"]*)\"$")
	public void user_then_looks_for_variants_locked_to_the_carrier_something(String carrierName) throws Throwable {
		if (environment.equals("web")) {
			sp = new SearchPage();
			sp.selectCarrier(carrierName);
		} else {
			msp = new MobileSearchPage();
			msp.selectCategory("Carrier Cell Phones");

		}
	}

	@And("^The user sets his US delivery zip code to \"([^\"]*)\"$")
	public void the_user_sets_his_us_delivery_zip_code_to_something(String zipCode) throws Throwable {

		switch (environment) {
		case "web":
			hp.changeZipcode(zipCode);
			break;
		case "mobile":
			mhs = new MobileHomeScreen();
			mhs.changeZipCode(zipCode);
			break;
		default:
			scenario.write("Correct environment not present. Exiting !!!");
			driver.quit();
			break;
		}
	}

	@And("^Select option \"([^\"]*)\" if present$")
	public void select_option_something_if_present(String colour) throws Throwable {
		if (coloursAvailable) {
			if (environment.equals("web")) {
				sp.selectColour(colour);
			} else {
				msp.selectColour(colour);
			}

		} else {
			sp.selectFirstOption();
			scenario.write("Colours not available. Thus selecting first option");
		}
	}

	@After
	public void closeDriver() throws Exception {
		if (driver != null)
			driver.quit();
		if (appiumDriver != null)
			appiumDriver.quit();
	}

	@Before
	public void before(Scenario scenario) {
		StepDefinitionBase.scenario = scenario;

	}

}
