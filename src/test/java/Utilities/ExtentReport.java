package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentSparkReporter rp;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports InitializeReports() {
		
		//location of the report
		ExtentSparkReporter rp= new ExtentSparkReporter("D:\\Eclipse\\ProjectWithPOM\\target.png");
		rp.config().setDocumentTitle("Automation Report");
		rp.config().setReportName("Functional Report");
		
		extent= new ExtentReports();
		extent.attachReporter(rp);
		extent.setSystemInfo("Tester", "Maksuda");
		
		return extent;
	}
}
