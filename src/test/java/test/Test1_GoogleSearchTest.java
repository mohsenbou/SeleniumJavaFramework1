package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class Test1_GoogleSearchTest {

    private static WebDriver driver;

    public static void main(String[] args)  throws InterruptedException{
        googleSearch();
    }

    public static void googleSearch() throws InterruptedException {

        String projectPath= System.getProperty("user.dir");
        System.out.println("path: "+projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

//        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");;

//        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();
        GoogleSearchPage.button_search(driver).submit();

        Thread.sleep(2000);
        driver.close();
        driver.quit();

        System.out.println("==================Test1_GoogleSearchTest completed Successfully=====================");
    }
}
