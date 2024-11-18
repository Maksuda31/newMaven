package TestRunners;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import ProjectWithPOM.ProjectWithPOM.Flight_Page;
import ProjectWithPOM.ProjectWithPOM.Login_Page;
import ProjectWithPOM.ProjectWithPOM.Registration_Page;
import Utilities.CrossBrowser;
import Utilities.ExtentReport;
import Utilities.ScreenShot;


public class TestRunner {
	
	private static final ExtentReport ExtentReportManager = null;
	WebDriver driver;
	ScreenShot srn= new ScreenShot();
	Properties P = new Properties();
	ExtentReports extent;
	ExtentTest test;
	ExtentReport ExtentReporterManager;
	
	@BeforeSuite
	public void reportSetup() {
		extent=ExtentReportManager.InitializeReports();
	}
	
	@BeforeMethod
	 public void beforeMethod() throws IOException {
		CrossBrowser br1= new CrossBrowser();
		driver=br1.initializeBrowser();
		extent.flush();
		srn.report(driver);
	  }	
  @Test(priority=1)
  public void Registration() throws IOException {
	  Registration_Page r= new Registration_Page(driver);
	  r.reg();
	  test=extent.createTest("Registration Test");
	  extent.flush();
	  test.log(Status.INFO, "Registration page interaction successfull");
	  Reporter.log("Registration done successfully");
	  srn.report(driver);
  }
  @Test(dataProvider="loginData",priority=2)
  public void Login(String Key) throws IOException {
	  test=extent.createTest("Login Test");
	  Login_Page lp= new Login_Page(driver);
	  lp.login(Key);
	  test.log(Status.INFO, "Login successfull");
	  extent.flush();

	  Reporter.log("Login successful for: " + Key);
	  srn.report(driver);
  }
  
  @Test(priority=3)
  public void Flights() {
	  Flight_Page fl=new Flight_Page(driver);
	  fl.flight();
	  Reporter.log("No seats available");
	  test=extent.createTest("Flight Page Test");
	  extent.flush();
	  test.log(Status.INFO, "Flight page interaction successfull");
  }
  
  @DataProvider(name = "loginData")
  public Object[][] loginDataProvider() {
      return new Object[][] {
          {"user1"},
          {"user2"},
          {"user3"},
      };
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
