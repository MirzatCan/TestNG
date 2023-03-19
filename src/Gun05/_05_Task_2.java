package Gun05;

import Utlity.BaseDriverParametre;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task_2 extends BaseDriverParametre {
    /** Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
        sonrasında fakrlı tarayıcılar ile çalıştırınız. (crossbrowser)
        sonrasında paralel çalıştırınız.(parallel)
          */

    By Arama= By.name("search");
    By AramaButunu=By.cssSelector("button[class='btn btn-default btn-lg']");

    By UrunBasliklari=By.cssSelector("[class='caption'] > h4");
    @Test(dataProvider = "aramaData")
    void arananKelimeVarMi(String veri) {
        WebElement aramaTusu = driver.findElement(Arama);
        aramaTusu.clear();   //arama kutusunu temizlememiz lazim. cunku her seferinde tekrar login olmiyoruz, driver tekrar tekrar yeniden calismiyor.
        aramaTusu.sendKeys(veri);

        WebElement aramaButinu = driver.findElement(AramaButunu);
        aramaButinu.click();

        List<WebElement> urunBasliklari = driver.findElements(UrunBasliklari);

        for (WebElement e : urunBasliklari) {
            Assert.assertTrue(e.getText().toLowerCase().contains(veri.toLowerCase()), "baslikta aranan kelime bulunamadi");
        }

    }
    @DataProvider
    public Object[] aramaData(){
        Object[] data={"mac","ipod","samsung"};
        return data;
    }
}
