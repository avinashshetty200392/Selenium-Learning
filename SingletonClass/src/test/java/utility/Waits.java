package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	private WebDriver driver;


	public static void waitInSecsVisibility(WebDriver driver,WebElement ele,int secs) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public static void waitInSecs(WebDriver driver,List<WebElement> ele,int secs) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public static void waitInSecsClickable(WebDriver driver,WebElement ele,int secs) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
