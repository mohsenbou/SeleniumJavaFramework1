package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class TestNG_Demo2 {

    WebDriver driver = null;
    @BeforeTest
    public void setUpTest(){
        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void googleSearch2() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");;
        GoogleSearchPage.button_search(driver).submit();

        System.out.println("==================TestNG_Demo2 completed Successfully=====================");
    }
    @AfterTest
    public void tearDownTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
