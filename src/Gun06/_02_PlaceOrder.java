package Gun06;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class _02_PlaceOrder extends BaseDriver {

 /**
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
     By Arama= By.name("search");
     By AramaButunu=By.cssSelector("button[class='btn btn-default btn-lg']");

     By UrunEklemeButunu=By.xpath("//span[text()='Add to Cart']");
     By Mesaj=By.cssSelector("div[class='alert alert-success alert-dismissible']");
     By ShoppingCart=By.linkText("shopping cart");
     By Checkout=By.linkText("Checkout");
     By Step2Butun=By.id("button-payment-address");

     By Step3Butun=By.id("button-shipping-address");

     By Step4Butun=By.id("button-shipping-method");
     By Step5MaviTik=By.name("agree");
     By Step5Butun=By.id("button-payment-method");

     By Confirm=By.id("button-confirm");
     By SonMesaj=By.cssSelector("[id='content']>h1");

     @Test
     void sepeteEklemeOnaylamaTest(){
         WebElement aramaTusu = driver.findElement(Arama);
         aramaTusu.sendKeys("ipod");

         WebElement aramaButinu = driver.findElement(AramaButunu);
         aramaButinu.click();

         List<WebElement> eklemeler = driver.findElements(UrunEklemeButunu);
         eklemeler.get(0).click();

         WebElement mesaj = driver.findElement(Mesaj);

         WebElement shoppingCart= driver.findElement(ShoppingCart);
         shoppingCart.click();

         WebElement checkOut= driver.findElement(Checkout);
         checkOut.click();

         WebElement step2Butun= wait.until(ExpectedConditions.elementToBeClickable(Step2Butun));
         step2Butun.click();

         WebElement step3Butun= wait.until(ExpectedConditions.elementToBeClickable(Step3Butun));
         step3Butun.click();

         WebElement step4Butun= wait.until(ExpectedConditions.elementToBeClickable(Step4Butun));
         step4Butun.click();

         WebElement step5MaviTik= wait.until(ExpectedConditions.elementToBeClickable(Step5MaviTik));
         step5MaviTik.click();

         WebElement step5Butun= wait.until(ExpectedConditions.elementToBeClickable(Step5Butun));
         step5Butun.click();

         WebElement confirm= wait.until(ExpectedConditions.elementToBeClickable(Confirm));
         confirm.click();

         wait.until(ExpectedConditions.urlContains("success"));

         WebElement sonMesaj=driver.findElement(SonMesaj);

         Assert.assertEquals(sonMesaj.getText(),"Your order has been placed!","hata");


         // bu soruda bekletme konusu cok cok cok onemli
     }
}
