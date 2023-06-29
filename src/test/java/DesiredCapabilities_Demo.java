import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {
    /***************
     *
     * @param args
     * @throws DesiredCapabilities IS DEPRECATED
     */
    public static void main(String[] args) throws InterruptedException {
        String path= System.getProperty("user.dir");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("ignoreProtectedModeSettings", true);

        System.setProperty("webdriver.firefox.marionette", path + "\\src\\test\\resources\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div")).click();

        driver.findElement(By.name("q")).sendKeys("Automation step by step");

        driver.findElement(By.xpath("//input[@value='Recherche Google']")).submit();

        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
}
