package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
    @Test
    public void test1(){
        System.out.println("I am inside test 1");
    }
    @Test
    public void test2(){
        System.out.println("I am inside test 2");

        String path= System.getProperty("user.dir");
        System.out.println("path: "+path);

        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        driver.findElement(By.name("q")).sendKeys("Automation step by step");
        driver.findElement(By.name("qab")).sendKeys("Automation step by step");

    }
    @Test
    public void test3(){
        System.out.println("I am inside test 3");
        throw new SkipException("This test is skipped");
    }
}
