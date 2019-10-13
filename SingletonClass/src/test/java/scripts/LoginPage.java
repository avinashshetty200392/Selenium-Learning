package scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Waits;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "txtsearch")
	private WebElement searchText;

	@FindBy(id = "btnsearch")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@id='book_list']/ul/li//div[3]/a")
	private List<WebElement> listofBooks;

	@FindBy(xpath = "//img[@title='Student Handbook on Corporate & Economic Law for CA Final New Syllabus at Meripustak']")
	private WebElement bookimage;

	@FindBy(xpath = "//h2[contains(text(),'Books from same Author: ')]/a")
	private WebElement authorname;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterBookname(String user) {
		Waits.waitInSecsVisibility(driver, searchText, 10);
		searchText.sendKeys(user);
	}

	public void clickSearchButton() throws InterruptedException {
		Thread.sleep(2000);
		searchButton.click();
	}

	public String selectBook() {
		Waits.waitInSecs(driver, listofBooks, 10);
		System.out.println("Count of books: " + listofBooks.size());
		String bookName = null;
		for (WebElement book : listofBooks) {
			bookName = book.getText();
			if (bookName
					.equalsIgnoreCase("Student Handbook on Corporate & Economic Law for CA Final New Syllabus")) {
				book.click();
				break;
			}
		}
		Waits.waitInSecsVisibility(driver, bookimage, 10);
		return authorname.getText();
	}
}
