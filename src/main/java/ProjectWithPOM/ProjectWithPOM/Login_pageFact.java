package ProjectWithPOM.ProjectWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_pageFact {

	WebDriver driver;
	
	@FindBy(name="userName")
    WebElement user;
    
    @FindBy(name="password")
    WebElement pass;
                
    
    public void Login() {
        user.sendKeys("shams");
        pass.sendKeys("Shams1");
    }
    
    public Login_pageFact(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
}
