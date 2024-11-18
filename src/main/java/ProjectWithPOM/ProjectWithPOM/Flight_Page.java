package ProjectWithPOM.ProjectWithPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Flight_Page {
	WebDriver driver;
	
		By flts=By.xpath("//a[@href='reservation.php']");
		By depart=By.xpath("//select[@name='fromPort']");
		By month1=By.name("fromMonth");
		By day1=By.xpath("//select[@name='fromDay']");
		By arrive=By.xpath("//select[@name='toPort']");
		By month2=By.xpath("//select[@name='toMonth']");
		By day2=By.xpath("//select[@name='toDay']");
		By airline=By.xpath("//select[@name='airline']");
		By FindFlights=By.xpath("//input[@name='findFlights']");
	 
	 public void flight() {
		 
		 
		 driver.findElement(flts).click();
		 WebElement e=driver.findElement(depart);
		 Select s = new Select(e);
	     s.selectByVisibleText("New York");
		 
	     WebElement e2=driver.findElement(month1);
		 Select s2 = new Select(e2);
	     s2.selectByVisibleText("December");
	     
	     WebElement e3=driver.findElement(day1);
		 Select s3 = new Select(e3);
	     s3.selectByVisibleText("25");
	     
	     WebElement e4=driver.findElement(arrive);
		 Select s4 = new Select(e4);
	     s4.selectByVisibleText("Paris");
			
	     WebElement e5=driver.findElement(month2);
		 Select s5 = new Select(e5);
	     s5.selectByVisibleText("March");
	     
	     WebElement e6=driver.findElement(day2);
		 Select s6 = new Select(e6);
	     s6.selectByVisibleText("6");
	     
	     WebElement e7=driver.findElement(airline);
		 Select s7 = new Select(e7);
	     s7.selectByVisibleText("Blue Skies Airlines");
	     
		driver.findElement(FindFlights).click();	
		 
	 }
	 public Flight_Page(WebDriver driver) {
	        this.driver= driver;
	    }
}
