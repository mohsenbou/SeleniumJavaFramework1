package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPageObject;

public class Test1_GoogleSearchPageObject {
    private static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        googleSearchTest();
    }

    public static void googleSearchTest() throws InterruptedException {

        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        GoogleSearchPageObject searchPageObject = new GoogleSearchPageObject(driver);

        searchPageObject.setTextInSearchBox("Automation Step by Step");

        searchPageObject.clickSearchButton();

        Thread.sleep(2000);
        driver.close();
        driver.quit();

        System.out.println("==================Test1_GoogleSearchPageObject completed Successfully=====================");

    }
}
