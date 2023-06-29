import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserTest {

    public static void main(String[] args) throws InterruptedException {

        String path= System.getProperty("user.dir");
        System.out.println("path: "+path);

        System.setProperty("webdriver.firefox.marionette", path + "\\src\\test\\resources\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        WebDriver driver = new EdgeDriver();


        driver.get("https://www.selenium.dev/");

        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
