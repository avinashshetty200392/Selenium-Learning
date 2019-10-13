package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Common {
	private static WebDriver driver;

	private static Common id = new Common();

	private Common() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Avinash\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static Common getInitializeDriver() {
		return id;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void getScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils
				.copyFileToDirectory(
						src,
						new File(
								"E:\\Avinash\\SoapUI\\AutomationEclipse\\SingletonClass\\Screenshot"));

	}


}
