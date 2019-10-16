package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class GetElementScreenshot{
	
	public static void getElementScreenshot(WebElement ele,String methodname) throws Exception
	{
		
	File src = ele.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir");
	String des= path+"\\Screenshots\\"+methodname+".png";
	System.out.println(des);
	FileUtils.copyFile(src, new File(des));
	}

}




