package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
	WebDriver driver;
    Properties P = new Properties();

    public WebDriver initializeBrowser() throws IOException {
        // Load the properties file
        FileInputStream fis = new FileInputStream("D:\\Eclipse\\ProjectWithPOM\\config.properties");
        P.load(fis);
        
        // Read the browser name from the properties file
        String browserName = P.getProperty("browser");
        
        // Switch based on the browser name
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
                
            case "edge":
                driver = new EdgeDriver();
                break;
                
            case "firefox":
                driver = new FirefoxDriver();
                break;
                
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserName);
        }  
        // Open the URL from the properties file
        driver.get(P.getProperty("url"));
        
        // Return the initialized WebDriver instance
        return driver;
    }
}
