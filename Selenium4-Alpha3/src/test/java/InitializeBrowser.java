import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import static java.lang.System.*;

public class InitializeBrowser {
	WebDriver driver;

	@Test(priority=1)
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\Avinash\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@Test(priority=2)
	public void selectherbalTea() throws Exception
	{
		WebElement newMessageWindow=driver.findElement(By.id("draga"));
		WebElement dragMeButton=driver.findElement(withTagName("button").below(newMessageWindow));
		dragMeButton.click();
		Thread.sleep(3000);
		dragMeButton.click();
		WebElement alertBoxButton = driver.findElement(By.id("alert"));
		alertBoxButton.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		driver.quit();
	}
}
