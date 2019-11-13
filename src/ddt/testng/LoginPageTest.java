package ddt.testng;

import ddt.collections.BaseCollection;
import ddt.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "getData")
    public void correctLoginTest(String username, String password) {

        driver.navigate().to(BaseCollection.LOGIN_URL);
        new LoginPage(driver).girisYap(username, password);
        driver.switchTo().alert().accept();
    }

    @DataProvider
    public String[][] getData() {
        return BaseCollection.xlsRead(BaseCollection.FILE_PATH_LOGIN);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
