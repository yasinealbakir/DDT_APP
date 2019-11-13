package ddt.tests;

import ddt.collections.BaseCollection;
import ddt.collections.KullaniciTanimlamaCollection;
import ddt.pages.KullaniciTanimlamaPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class KullaniciTanimlamaTest extends BaseTest {

    String ad;
    String soyad;
    String cinsiyet;
    String unvan;

    public void goToUrl() {
        navigateUrl(KullaniciTanimlamaCollection.URL);
    }

//    @Parameterized.Parameters
//    public static List<String[]> getData() {
//        return BaseCollection.csvRead("C:\\selenium-driver\\kullanici-listesi.csv");
//    }

    @Parameterized.Parameters
    public static String [][] getData()
    {
        return BaseCollection.xlsRead(BaseCollection.FILE_PATH);
    }
    
    @Test
    public void kullaniciEkleTest() throws InterruptedException {
        goToUrl();
        new KullaniciTanimlamaPage(driver).kullaniciEkle(ad, soyad, cinsiyet, unvan);
        Assert.assertEquals(KullaniciTanimlamaCollection.BASARILI_TANIMLAMA_MESAJ, showAlert());

    }

    public KullaniciTanimlamaTest(String ad, String soyad, String cinsiyet, String unvan) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.unvan = unvan;
    }

}
