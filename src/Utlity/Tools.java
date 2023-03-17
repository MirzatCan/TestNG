package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools {
    public static void bekle(int sn)  {
        // bekle islemi
        try {
            Thread.sleep(1000*sn);   // Thread.sleep(1000*sn); sleep altinda kirmizi hata cizgi
        } catch (InterruptedException e) { //cikiyor, onu tiklatip sagtaraftan duzeltme seceneginden
            throw new RuntimeException(e); //try catch secenegini seciyoruz.
        }
    }

    public static void suscessMesajidogulama(){
        WebElement basariliMesaji=BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        Assert.assertTrue(basariliMesaji.getText().contains("Success"),"basarisiz oldu");
    }
}
