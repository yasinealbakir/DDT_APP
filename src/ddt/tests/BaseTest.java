package ddt.tests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

    protected WebDriver driver;

    public enum browsers {

        Chrome,
        Firefox,
        Edge,
        IE
    }

    public void selectBrowser(browsers browser) {
        if (browser == browsers.Chrome) {
            System.setProperty("webdriver.chrome.driver", "C:/selenium-driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == browsers.Firefox) {
            System.setProperty("webdriver.gecko.driver", "C:/selenium-driver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser == browsers.Edge) {
            System.setProperty("webdriver.edge.driver", "C:/selenium-driver/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.ie.driver", "C:/selenium-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

    public void navigateUrl(String url) {
        driver.get(url);

    }

    public String showAlert() {
        return driver.switchTo().alert().getText();
    }

    @Before
    public void setUp() {
        selectBrowser(browsers.Chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
