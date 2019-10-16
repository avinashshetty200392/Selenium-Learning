package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ElementScreenshot {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,10);
	
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
		String methodName=new Throwable().getStackTrace()[0].getMethodName();
		WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		//ElementScreenshot.getElementScreenshot(loginButton,methodName);
		
	}
	@Test(priority=3)
	public void enterUsername() throws Exception
	{
		String methodName=new Throwable().getStackTrace()[0].getMethodName();
		WebElement usernameField= driver.findElement(By.id("ContentPlaceHolder1_txtLogEmail"));
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys("Avinash");
		//ElementScreenshot.getElementScreenshot(usernameField,methodName);
		driver.quit();
		
	}

}
