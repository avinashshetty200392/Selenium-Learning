package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.GetElementScreenshot;

public class ElementScreenshot {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void initializeBrowser() {
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty(
				"webdriver.gecko.driver",
				path+"\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.meripustak.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void clickOnLoginButton() throws Exception {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		WebElement loginButton = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		
		//Using Rectangle Class and its corresponding methods
		Rectangle rec = loginButton.getRect();
		System.out.println("Height: "+rec.getHeight()+","+"Width: "+rec.getWidth()+","+"Xcord: " +rec.getX()+","+"Ycord: "+rec.getY()+","+"Dimension: "+rec.getDimension());
		
		//Element Screenshot using getScreenshotAs method
		GetElementScreenshot.getElementScreenshot(loginButton,methodName);
		loginButton.click();
		

	}

	@Test(priority=2)
	public void enterUsername() throws Exception {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		WebElement usernameField = driver.findElement(By
				.id("ContentPlaceHolder1_txtLogEmail"));
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys("Avinash");
		GetElementScreenshot.getElementScreenshot(usernameField,methodName);
		driver.quit();

	}

}
