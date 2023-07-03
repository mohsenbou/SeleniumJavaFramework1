package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleSearchPage;

import java.time.Duration;

/**
 * Implicite wait: Is used to define a time (period) until when webdriver should wait before No Such Element exception
 * Explicite wait: can be set for specific elements (or specific condition e.g wait until element is clickable)
 */

public class SeleniumWaitDemo {

    public static void main(String[] args) {
        seleniumWaits();
    }

    public static void  seleniumWaits(){
        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        //explicit wait
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));

        driver.findElement(By.name("abcd"));

        driver.close();
        driver.quit();
    }
}
