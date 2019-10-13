import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class ExpectedConditionTitle {
	WebDriverWait wait;
	String pageTitle;
	private String url;
	String expectedPageTitle;
	@Test
	public void verifyTitleExpectedCondition() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Avinash\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		url = "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.14.0";
		expectedPageTitle = "Maven Repository: org.seleniumhq.selenium » selenium-java » 3.14.0";
		driver.get(url);

		pageTitle = driver.getTitle();
		System.out.println(pageTitle);

		WebElement popularCategoriesLink = driver.findElement(By.xpath("//a[contains(text(),'Popular Categories')]"));
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//used 
		wait.until(ExpectedConditions.and(ExpectedConditions.titleContains(expectedPageTitle),ExpectedConditions.urlToBe(url),ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/assets/images/392dffac024b9632664e6f2c0cac6fe5-logo.png']")),ExpectedConditions.elementToBeClickable(popularCategoriesLink)));
		popularCategoriesLink.click();
		driver.quit();
	}
}
