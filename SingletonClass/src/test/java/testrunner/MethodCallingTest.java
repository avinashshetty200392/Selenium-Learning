package testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import scripts.LoginPage;
import utility.Common;

public class MethodCallingTest {
	private WebDriver driver;
	LoginPage lp;

	@Test
	public void launchApplication() {
		Common d = Common.getInitializeDriver();
		driver = Common.getDriver();
		driver.get("https://www.meripustak.com/");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void enterbookName() {
		lp.enterBookname("CA");
	}

	@Test(priority = 2)
	public void clickOnSearchButton() throws InterruptedException {
		lp.clickSearchButton();
	}

	@Test(priority = 3)
	public void selectBookFromTheList() {
		String author = lp.selectBook();
		Assert.assertEquals(author, "CA G Sekar and CA B Saravana Prasath",
				"This is not the book we are searching for");
	}

	@AfterMethod
	public void takescreenshotAfterEachMethod() throws Exception {
		Common.getScreenShot();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
