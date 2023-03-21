package Gun07;

import Gun06._03_PlaceOrderElements;
import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListPOM extends BaseDriver {

    @Test
    @Parameters("searchTsxt")
    void begenilerdeVarMiTest(String arananKelime){

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();
        poe.aramaTusu.sendKeys(arananKelime);
        poe.aramaButunu.click();

        _03_WishListElements wls=new _03_WishListElements();
        int randumSayi=(int) (Math.random()*wls.urunlerinAdi.size());
        System.out.println("randumSayi = " + randumSayi);
        String aranacakKelime=wls.urunlerinAdi.get(randumSayi).getText();  //bunu assagda for dongu icindeki if de birek kullansam calismadi, nedenini anlamadim
        wls.urunleriBegenilerAtmaButunu.get(randumSayi).click();
        wls.wishlist.click();

        boolean bulundu=false;
        for (WebElement u:wls.begenilerUrunler) {
            if (u.getText().toLowerCase().contains(aranacakKelime.toLowerCase())){
                bulundu=true;
                break;
            }
        }
        if (bulundu=false)
            Assert.fail();
    }
}
