package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class SeleniumFuentWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void  test() throws InterruptedException {
        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        driver.findElement(By.name("q")).sendKeys("Abcd");
        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement linkElement = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.Z26q7c.UK95Uc.jGGQ5e > div > a > h3"));
                System.out.println("apply");
                if(linkElement.isEnabled()){
                    System.out.println("Element Found");
                }
                return linkElement;
            }
        });

        element.click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
