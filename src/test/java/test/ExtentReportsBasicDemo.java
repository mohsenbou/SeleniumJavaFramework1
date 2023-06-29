package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportsBasicDemo {

    private static WebDriver driver= null;
    public static void main(String[] args) throws InterruptedException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target\\extentReport.html");
        extent.attachReporter(spark);

        ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");

        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        test1.log(Status.INFO, "Starting test Case");
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();
        test1.pass("Navigated to google.com");

        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        test1.pass("Enter text in the send box");

        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();
        test1.pass("Pressed Keyboard enter key");

        /*******************************************second test********************************/
        ExtentTest test2 = extent.createTest("Google Search Test Two", "this is a test to invalidate google search functionality");

        test2.log(Status.INFO, "Starting test Case");
        driver.get("https://www.google.com/");
        test2.pass("Navigated to google.com");

        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        test2.pass("Enter text in the send box");

        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();
        // best practise: put it in a try catch
        test2.fail("Pressed Keyboard enter key");

        Thread.sleep(2000);
        driver.close();
        driver.quit();
        test2.pass("Close the browser");
        test2.info("test completed");
        extent.flush();
        System.out.println("==================Test ExtentReportsBasicDemo completed Successfully=====================");

    }
}
