package ddt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    By inputKullaniciAdi = By.id("kullaniciAdi");
    By inputSifre = By.id("parola");
    By btnGiris = By.id("btnGirisYap");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void girisYap(String username, String password) {
        driver.findElement(inputKullaniciAdi).sendKeys(username);
        driver.findElement(inputSifre).sendKeys(password);
        driver.findElement(btnGiris).click();
    }

}
