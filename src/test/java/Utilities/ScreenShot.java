package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	WebDriver driver;
	public void report(WebDriver driver) throws IOException {
		
		
		TakesScreenshot scr=(TakesScreenshot) driver;
		File f=scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("D:\\ProjectScreenShots\\screen"+System.currentTimeMillis()+".jpeg"));
}
}
