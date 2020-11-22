import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
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
            String downloadFilepath = "C:\\Users\\vladyslav.bilenko\\Desktop\\My projects\\JavaSeleniumTests\\herokuApp\\src\\main\\resources\\downloads";
            HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
            chromePreferences.put("profile.default_content_settings.popups", 0);
            chromePreferences.put("download.default_directory", downloadFilepath);
            chromePreferences.put("disable-popup-blocking", true);
            chromePreferences.put("download.prompt_for_download", false);
            chromePreferences.put("safebrowsing.enabled", true);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePreferences);
            chromeOptions.addArguments("--test-type");
            chromeOptions.addArguments("--disable-extensions"); //to disable browser extension popup

            driver = new ChromeDriver(chromeOptions);
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

    public void navigateBackInPage() {
        driver.navigate().back();
    }

    public void clickOnLink(By element) {
        driver.findElement(element).click();
    }
}
