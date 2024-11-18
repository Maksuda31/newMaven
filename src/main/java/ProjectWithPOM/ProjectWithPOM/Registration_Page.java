package ProjectWithPOM.ProjectWithPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration_Page {
	
	WebDriver driver;
	
	By FName=By.xpath("//input[@name='firstName']");
	By LName=By.xpath("//input[@name='lastName']");
	By ph=By.xpath("//input[@name='phone']");
	By email=By.xpath("//input[@name='userName']");
	
	By regi=By.xpath("//td[@class='mouseOut']//a[@href='register.php']");
	
	By ad=By.xpath("//input[@name='address1']");
	By ct=By.xpath("//input[@name='city']");
	By st=By.xpath("//input[@name='state']");
	By pc=By.xpath("//input[@name='postalCode']");
	By cn=By.xpath("//select[@name='country']");
	
	By user1=By.xpath("//input[@name='email']");
	By pass1=By.xpath("//input[@name='password']");
	By con=By.xpath("//input[@name='confirmPassword']");
	
	public void reg() {
		driver.findElement(regi).click();
		driver.findElement(FName).sendKeys("Maks");
		driver.findElement(LName).sendKeys("Akt");
		driver.findElement(ph).sendKeys("210");
		driver.findElement(email).sendKeys("mak@hotmail.com");
		driver.findElement(ad).sendKeys("Nice Place");
		driver.findElement(ct).sendKeys("Nice");
		driver.findElement(pc).sendKeys("21042");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(cn));
		Select s = new Select(e);
		s.selectByVisibleText("UNITED STATES");
		  
		driver.findElement(user1).sendKeys("Maks");
		driver.findElement(pass1).sendKeys("xyz");
		driver.findElement(con).sendKeys("xyz");
	
	}
	 public Registration_Page(WebDriver driver) {
	        this.driver= driver;
	    }
}
