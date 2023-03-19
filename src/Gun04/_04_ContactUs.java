package Gun04;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _04_ContactUs extends BaseDriver {

    By ContactUs=By.linkText("Contact Us");

    By MesajTablo=By.id("input-enquiry");

    By Submit=By.cssSelector("input[value='Submit']");

    By Content=By.id("content");

    @Test
    @Parameters("mesaj")  //xml deki parametre adi ayni olmak zorunda
    void mesajGonderme(String gelenMesaj){
        // String gelenMesaj:metod için gerekli tanımlama aynı olmak zorunda değil
        WebElement contactUs=driver.findElement(ContactUs);
        contactUs.click();

        WebElement mesajTablo=driver.findElement(MesajTablo);
        mesajTablo.sendKeys(gelenMesaj);

        WebElement submitTusu=driver.findElement(Submit);
        submitTusu.click();

        WebElement content=driver.findElement(Content);

        Assert.assertTrue(content.getText().contains("Contact Us"),"mesaj gonderme basarizsiz oldu");


    }
}
