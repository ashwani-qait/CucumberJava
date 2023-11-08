package StepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;
import pages.loginPage;

public class OrangeHRMSteps {

	loginPage login;
	homePage home;
	WebDriver driver = null;

	@Before
	public void browseSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		login = new loginPage(driver);
		home = new homePage(driver);
	}

	@Given("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.navigate().to(url);
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("User click on login button")
	public void user_click_on_login_button() {
		login.clickonLoginButton();
	}

	@Then("verify Homepage title should be {string}")
	public void verify_HomePage_title(String expectedtitle) {
		home.verifyHomePageHeader(expectedtitle);
	}

	@When("User enters text {string} in search Textfield")
	public void user_enters_text_in_SearchField(String value) {
		home.enterTextinSearchField(value);
	}

	@And("verify that only {string} is visible in menu")
	public void verify_visible_menu(String menuOption) {
		home.verifyVisibleMenuOptions(menuOption);
	}

	@Then("verify no results is shown in menu")
	public void verify_noResults_isShown() {
		home.verifyNoResultsIsShownForMenuOption();
	}

	@Given("User navigate to configure & Holidays")
	public void user_navigate_Holiday_Tab() {
		home.clickOnMenuTab();
		home.clickOnNavBarConfigureTab();
		home.clickOnNavBarConfigureTabOption();
	}

	@And("verify all Holidays label and its date")
	public void verify_holidays_contents_And_Date(DataTable dataTable) {
		List<Map<String, String>> userMap = dataTable.asMaps(String.class, String.class);
		List<String> listOfExpectedHolidays = new ArrayList<String>();
		for (Map<String, String> holiday : userMap) {
			listOfExpectedHolidays.add(holiday.get("Holiday Name"));
		}

		List<String> listOfExpectedHolidayDates = new ArrayList<String>();
		for (Map<String, String> holiday : userMap) {
			listOfExpectedHolidayDates.add(holiday.get("Date"));
		}
		List<String> listOfActualHolidays = login.getListOfHolidays();
		List<String> listOfActualHolidaysDates = login.getListOfHolidaysDates();
		home.verifyListOfHolidayslabels(listOfActualHolidays, listOfExpectedHolidays);
		home.verifyListOfHolidayslabels(listOfActualHolidaysDates, listOfExpectedHolidayDates);
	}

	@Then("verify date of given Holiday name {string} and date {string}")
	public void verify_holidays_(String holidayName, String expectedHolidayDate) {

		List<String> listOfActualHolidays = home.getListOfHolidays();
		List<String> listOfActualHolidaysDates = home.getListOfHolidaysDates();

		int indexHoliday = listOfActualHolidays.indexOf(holidayName);
		String actualHolidayDate = listOfActualHolidaysDates.get(indexHoliday);
		Assert.assertEquals(actualHolidayDate, expectedHolidayDate);
	}

	@After
	void tearDown() {
		System.out.println("Enter the inside teardown");
		driver.close();
		driver.quit();
	}
}
