package demo;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {

        String projectPath= System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);



        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        driver.findElement(By.name("q")).sendKeys("Automation");
//        driver.findElement(By.xpath("//input[@value='Google Search']")).submit();

        Thread.sleep(2000);
        driver.close();
        driver.quit();

        System.out.println("==================Test completed Successfully=====================");

    }
}
