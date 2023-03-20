package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert(){
        String s1="Merhaba";
        System.out.println("Harc Assert oncesi");  //calisir
        Assert.assertEquals("Merhaba123",s1,"esit degil");   //burda kirilir
        System.out.println("Harc Assert sonrasi");  //calismaz
    }

    @Test
    void softAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("www.facebook.com/homepage",strHomePage);  //True
        System.out.println("soft assert1");
        softAssert.assertEquals("www.facebook.com/profile",strCartPage);   //false
        System.out.println("soft assert2");
        softAssert.assertEquals("www.facebook.com/settings",strEditAccount); //false
        System.out.println("soft assert3");

        softAssert.assertAll(); // butun assert sonuclarini isleme koyar
        System.out.println("soft assertAll sonrasi -> Aktiflik sonrasi ");
        //bu bolum assertAll sonrasi oldugu icin hata olustugunda calismaz

    }
}
