package Gun07;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {
    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
    @Test
    @Parameters("searchTsxt")
    void begenilerdeVarMiTest(String arananKelime){
        WebElement aramaTusu = driver.findElement(By.name("search"));
        aramaTusu.sendKeys(arananKelime);
        WebElement aramaButunu = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        aramaButunu.click();
        List<WebElement> urunleriBegenilerAtmaButunu=driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        List<WebElement> urunlerinAdi=driver.findElements(By.cssSelector("[class='caption']>h4"));
        int randumSayi=(int) (Math.random()*urunlerinAdi.size());
        System.out.println("randumSayi = " + randumSayi);
        String aranacakKelime=urunlerinAdi.get(randumSayi).getText();  //bunu assagda for dongu icindeki if de birek kullansam calismadi, nedenini anlamadim
        urunleriBegenilerAtmaButunu.get(randumSayi).click();
        WebElement wishlist=driver.findElement(By.linkText("wish list"));
        wishlist.click();

        List<WebElement> begenilerUrunler=driver.findElements(By.xpath("//*[@class='text-left']//a"));

        boolean bulundu=false;
        for (WebElement u:begenilerUrunler) {
            if (u.getText().toLowerCase().contains(aranacakKelime.toLowerCase())){
                bulundu=true;
                break;
            }
        }

        if (bulundu=false)
            Assert.fail();
    }
}
