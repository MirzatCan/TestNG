package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _04_PlaceOrderClassAyirma extends BaseDriver {


     @Test
      void sepeteEklemeOnaylamaTest(){
         _03_PlaceOrderElements elements=new _03_PlaceOrderElements();  //  _03_PlaceOrderElements classini bagladik

         elements.aramaTusu.sendKeys("ipod");
         elements.aramaButunu.click();
         elements.eklemeler.get(0).click();
         elements.shoppingCart.click();
         elements.checkOut.click();

         wait.until(ExpectedConditions.elementToBeClickable(elements.step2Butun)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.step3Butun)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.step4Butun)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.step5MaviTik)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.step5Butun)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.confirm)).click();
         wait.until(ExpectedConditions.urlContains("success"));
         Assert.assertEquals(elements.sonMesaj.getText(),"Your order has been placed!","hata");
     }
}
