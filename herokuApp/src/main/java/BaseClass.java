import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class was created for initializing the browser driver
 * And in future to add the new functionality to make tests
 * Flexible and with more info in errors, screenshots and
 * Keep such functionality in one class for inheritance
 */
public class BaseClass {
    public static WebDriver driver;
    public Properties properties;

    public WebDriver DriverInitialization() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\browserSelection.properties");
        properties.load(fileInputStream);
        String browser_name = properties.getProperty("browser_name");

        if (browser_name.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser_name.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser_name.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\microsoftdriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        } else if (browser_name.equals("opera")) {
            System.setProperty("webdriver.opera.driver", "C:\\operadriver\\operadriver.exe");
            driver = new OperaDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public void clickOnLink(By element){
        driver.findElement(element).click();
    }
}
