package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AutoITDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        test();
    }

    public static void test() throws IOException, InterruptedException {
        String projectPath= System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.file.io/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#qc-cmp2-ui > div.qc-cmp2-footer.qc-cmp2-footer-overlay.qc-cmp2-footer-scrolled > div > button.css-1litn2c")).click();
        driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div.css-1dk3fy0 > div > div.css-z256ob > div > div.css-s26718 > div.css-10akxzu > div > div > div.css-x8ya6q > div > label")).click();

        Runtime.getRuntime().exec("C:\\Dev\\tuto selenium\\FileUploadScript.exe");

        Thread.sleep(3000);
//        driver.close();
//        driver.quit();

    }
}
