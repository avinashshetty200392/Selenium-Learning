package screenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.GetElementScreenshot;

public class TakeElementScreenshot {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority=1)
	public void initializeBrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\Clone-GitHubProjects\\Selenium-Learning\\Selenium4-Alpha3\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.meripustak.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@Test(priority=2)
	public void clickOnLoginButton() throws Exception
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		String methodName=new Throwable().getStackTrace()[0].getMethodName();
		WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		GetElementScreenshot.getElementScreenshot(loginButton,methodName);		loginButton.click();
		
		
	}
	@Test(priority=3)
	public void enterUsername() throws Exception
	{
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		String methodName=new Throwable().getStackTrace()[0].getMethodName();
		WebElement usernameField= driver.findElement(By.id("ContentPlaceHolder1_txtLogEmail"));
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys("Avinash");
		GetElementScreenshot.getElementScreenshot(usernameField,methodName);
		driver.quit();
		
	}

}
