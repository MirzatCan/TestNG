package Gun04;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
*/
public class _05_SearchFunctionality extends BaseDriver {
    By Arama= By.name("search");
    By AramaButunu=By.cssSelector("button[class='btn btn-default btn-lg']");

    By UrunBasliklari=By.cssSelector("[class='caption'] > h4");
    @Test
    @Parameters("kelime")
    void arananKelimeVarMi(String gelenKelime){
        WebElement aramaTusu=driver.findElement(Arama);
        aramaTusu.sendKeys(gelenKelime);

        WebElement aramaButinu=driver.findElement(AramaButunu);
        aramaButinu.click();

        List<WebElement> urunBasliklari=driver.findElements(UrunBasliklari);

        for (WebElement e:urunBasliklari) {
            Assert.assertTrue(e.getText().toLowerCase().contains(gelenKelime.toLowerCase()),"baslikta aranan kelime bulunamadi");
        }

    }


}
