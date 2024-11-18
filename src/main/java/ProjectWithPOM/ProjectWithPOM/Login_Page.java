package ProjectWithPOM.ProjectWithPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	WebDriver driver;
	Properties P = new Properties();
		
	 public Login_Page(WebDriver driver) throws IOException {
	        this.driver = driver;
	    }
	
	public void login(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Eclipse\\ProjectWithPOM\\config.properties");
	    P.load(fis);
	    
	    String user = P.getProperty(Key+".username");
        String pass = P.getProperty(Key+".password");
        
        String userLocator = P.getProperty("userLocator");
        String passLocator = P.getProperty("passLocator");
        String submitLocator = P.getProperty("submitLocator");
        
//      WebElement ur= driver.findElement(By.name(userLocator));
//      WebElement ps=driver.findElement(By.name(passLocator));
        
        driver.findElement(By.name(userLocator)).sendKeys(user);
        driver.findElement(By.name(passLocator)).sendKeys(pass);
        driver.findElement(By.name(submitLocator)).click();
	}
    
}
