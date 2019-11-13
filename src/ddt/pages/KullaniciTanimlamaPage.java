package ddt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class KullaniciTanimlamaPage {

    private final WebDriver driver;
    Select selectUnvan = null;
    By inputAd = By.id("txtAd");
    By inputSoyad = By.id("txtSoyad");
    By rdErkek = By.id("radioErkek");
    By rdKadin = By.id("radioKadin");
    By drpUnvan = By.id("drpUnvan");
    By btnKaydet = By.id("btnKaydet");

    public KullaniciTanimlamaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void kullaniciEkle(String ad, String soyad, String cinsiyet, String unvan) throws InterruptedException {

        driver.findElement(inputAd).sendKeys(ad);
        Thread.sleep(1000);
        driver.findElement(inputSoyad).sendKeys(soyad);
        Thread.sleep(1000);

        //Cinsiyet seçimi
        if (!cinsiyet.equals("Erkek")) {
            driver.findElement(rdKadin).click();
        } else {
            driver.findElement(rdErkek).click();

        }
        Thread.sleep(1000);

        //Ünvan seçimi
        selectUnvan = new Select(driver.findElement(drpUnvan));
        switch (unvan) {
            case "Seçiniz":
                selectUnvan.selectByIndex(0);
                break;
            case "Proje Mühendisi":
                selectUnvan.selectByIndex(1);
                break;
            case "Yazılım Test Uzmanı":
                selectUnvan.selectByIndex(2);
                break;
            case "Takım Lideri":
                selectUnvan.selectByIndex(3);
                break;
            case "Müdür":
                selectUnvan.selectByIndex(4);
                break;
            default:
                selectUnvan.selectByIndex(5);
                break;
        }
        Thread.sleep(1000);
        driver.findElement(btnKaydet).click();
        Thread.sleep(1000);
    }
}
