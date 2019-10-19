package newwindowstabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewWindowsTabs {
	WebDriver driver;

	@BeforeTest
	public void initializeBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path
				+ "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void openNewTab() {
		WebDriver tab = driver.switchTo().newWindow(WindowType.TAB);
		tab.get("https://in.yahoo.com/");
	}

	@Test
	public void openNewWindow() {
		WebDriver wind = driver.switchTo().newWindow(WindowType.WINDOW);
		wind.get("https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
