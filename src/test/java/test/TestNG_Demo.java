package test;

import config.PropertiesFile;
import demo.Log4jDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class TestNG_Demo {

    WebDriver driver = null;
    public static String browserName= null;
    private static Logger logger = LogManager.getLogger(Log4jDemo.class);


    @BeforeTest
    public void setUpTest(){

        String projectPath= System.getProperty("user.dir");
        PropertiesFile.getProperties();

        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        logger.info("Browser started");
    }
    @Test
    public void googleSearch() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
        GoogleSearchPage.button_search(driver).submit();

        System.out.println("==================TestNG_Demo completed Successfully=====================");
    }
    @AfterTest
    public void tearDownTest() throws InterruptedException {
        PropertiesFile.setProperties();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
