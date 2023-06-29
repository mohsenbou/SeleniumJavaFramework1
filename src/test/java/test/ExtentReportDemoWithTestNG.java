package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportDemoWithTestNG {

    ExtentReports extent;
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target\\extentReport_TestNG.html");
        extent.attachReporter(spark);

        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void test1(){
        ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();
        test1.pass("Navigated to google.com");

        test1.log(Status.INFO,"this step show usage of log");
        test1.pass("Enter text in the send box");
        test1.fail("Pressed Keyboard enter key");
        test1.addScreenCaptureFromPath("screenshot.png");

    }
    @Test
    public void test2(){
        ExtentTest test2 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");

        driver.get("https://automationstepbystep.com/");
        test2.pass("Navigated to google.com");

        test2.log(Status.INFO,"this step show usage of log");
        test2.pass("Enter text in the send box");
        test2.pass("Pressed Keyboard enter key");
        test2.addScreenCaptureFromPath("screenshot.png");

    }

    @AfterTest
    public void tearDownTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        System.out.println("==================Test ExtentReportDemoWithTestNG completed Successfully=====================");
    }
    @AfterSuite
    public void tearDown(){
        extent.flush();
        System.out.println("==================Test ExtentReportDemoWithTestNG completed Successfully=====================");
    }
}
