package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class GetElementScreenshot{
	
	public static void getElementScreenshot(WebElement ele,String methodname) throws Exception
	{
		
	File src = ele.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:\\Workspace\\GitlatestProgramsPractice\\elementScreenshot\\Screenshots\\"+methodname+".png"));
	}

}




