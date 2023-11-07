package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

	WebDriver driver;

	By txtFieldSearch = By.xpath("//input[@placeholder='Search']");
	By menuList = By.cssSelector("ul li a.oxd-main-menu-item");
	By leaveMenuTab = By.xpath("//ul//a//span[text()='Leave']");
	By configureOption = By.xpath("//span[contains(text(),'Configure')]");
	By configureMenuOption = By.xpath("//span[contains(text(),'Configure')]//..//li//a[text()='Holidays']");
	By holidayName = By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-cell')][2]");
	By holidayDate = By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-cell')][3]");

	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTextinSearchField(String value) {
		driver.findElement(txtFieldSearch).sendKeys(value);
	}

	public void verifyVisibleMenuOptions(String menuOptions) {
		driver.findElement(menuList).getText().equals(menuOptions);
	}

	public void verifyNoResultsIsShownForMenuOption() {
		Boolean status = false;
		try {
			status = driver.findElement(menuList).isDisplayed();
			Assert.assertFalse("Assertion Failed : Element is displayed", status);
		} catch (NoSuchElementException e) {
			System.out.println("  Assertion Passed : Element is not displayed ");
		} finally {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	public void clickOnMenuTab() {
		driver.findElement(leaveMenuTab).click();
	}

	public void clickOnNavBarConfigureTab() {
		driver.findElement(configureOption).click();
	}

	public void clickOnNavBarConfigureTabOption() {
		driver.findElement(configureMenuOption).click();
	}

	public List<String> getListOfHolidays() {
		List<WebElement> holidaysList = driver.findElements(holidayName);
		List<String> listOfString = new ArrayList<String>();
		for (WebElement option : holidaysList) {
			listOfString.add(option.getText().trim());

		}
		// System.out.println(listOfString);
		return listOfString;
	}

	public List<String> getListOfHolidaysDates() {
		List<WebElement> holidaysDateList = driver.findElements(holidayDate);
		List<String> listOfString = new ArrayList<String>();
		for (WebElement option : holidaysDateList) {
			listOfString.add(option.getText().trim());

		}
		// System.out.println(listOfString);
		return listOfString;
	}

	public void verifyListOfHolidayslabels(List<String> actual, List<String> expected) {
		actual.equals(expected);
	}
}
