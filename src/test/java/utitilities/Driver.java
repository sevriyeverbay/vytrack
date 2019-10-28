package utitilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private Driver() {
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = "chrome";
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().clearPreferences();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.get("https://qa2.vytrack.com/user/login");
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        }
    }