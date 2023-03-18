package Gun03;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En sondan 2. adresi siliniz.
 */

    By AddressBook= By.linkText("Address Book");
    By NewAddress=By.linkText("New Address");

    By FirstName=By.id("input-firstname");

    By LastName=By.id("input-lastname");
    By Company=By.id("input-company");
    By Adreess1=By.id("input-address-1");
    By Adreess2=By.id("input-address-2");
    By City=By.id("input-city");
    By PostCode=By.id("input-postcode");
    By Country=By.id("input-country");
    By State=By.id("input-zone");
    By SabitAdrees=By.cssSelector("input[value='1']");
    By YedekAdrees=By.cssSelector("input[value='0']");

    By adressEklendiMesaji=By.cssSelector("div[class='alert alert-success alert-dismissible']");
    By Continue=By.cssSelector("input[value='Continue']");
    @Test(priority = 1)
    void adreeEkle1 () {
        WebElement adressBook=driver.findElement(AddressBook);
        adressBook.click();

        WebElement yeniAdress=driver.findElement(NewAddress);
        yeniAdress.click();

        WebElement firstName=driver.findElement(FirstName);
        firstName.sendKeys("Can");

        WebElement lastName=driver.findElement(LastName);
        lastName.sendKeys("Mirzat");

        WebElement sirket=driver.findElement(Company);
        sirket.sendKeys("IT");

        WebElement adrees1=driver.findElement(Adreess1);
        adrees1.sendKeys("zeytinburnu/istanbul");

        WebElement adrees2=driver.findElement(Adreess2);
        adrees2.sendKeys("Fatih/istanbul");

        WebElement city=driver.findElement(City);
        city.sendKeys("istanbul");

        WebElement postCod=driver.findElement(PostCode);
        postCod.sendKeys("34098");

        Select ulkeler=new Select(driver.findElement(Country));
        ulkeler.selectByValue("215");

        Select vilayet=new Select(driver.findElement(State));   //NoSuchElementException
//        vilayet.selectByVisibleText("İstanbul");
//        vilayet.selectByValue("3354");
        WebElement options=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
        wait.until(ExpectedConditions.stalenessOf(options));  //selectByIndex kullanabilmek icin bekletme
        vilayet.selectByIndex(40);

        //NoSuchElementException
        //selectByVisibleText, selectByValue : findElement gibi çalıştığından
        //                                      implictly wait i kullanır.  kulanmazsak hata verir
        //*****************************************************//
        //StaleElementReferenceException -> stale element hatası : tez buldum erken kaybettim
        // selectByIndex : implicitlyWait ie çalışMIYOR. ancak ExplicitWait ile çalışır

        //2.yontem
//      wait.until(ExpectedConditions.elementToBeClickable(Country)); //cok onemli konu, sitenin ozelligi niye bekleme gerekir onu inceliyip
                                                                     // Country elemenytlerini bulana kadar bekle diye de yapabiliriz

        WebElement sabitAdres=driver.findElement(SabitAdrees);
        sabitAdres.click();

        WebElement continueDevam=driver.findElement(Continue);
        continueDevam.click();

        //1.yontem
        WebElement eklendiMesaj=driver.findElement(adressEklendiMesaji);
        Assert.assertTrue(eklendiMesaj.getText().contains("successfully added"),"Ekleme islemi basarisiz");

        //2.yontem
        //Tools.suscessMesajidogulama();
    }
    @Test(dependsOnMethods = "adreeEkle1")
    void adreeDuzeltme () {

        List<WebElement> editAll=driver.findElements(By.linkText("Edit"));
        WebElement sonEdit=editAll.get(editAll.size()-1);
        sonEdit.click();

        WebElement firstName=driver.findElement(FirstName);
        firstName.clear();
        firstName.sendKeys("Can1");

        WebElement lastName=driver.findElement(LastName);
        lastName.clear();
        lastName.sendKeys("Mirzat2");

        WebElement continueDevam=driver.findElement(Continue);
        continueDevam.click();

        //1.yontem
        WebElement duzenlemeMesaj=driver.findElement(adressEklendiMesaji);
        Assert.assertTrue(duzenlemeMesaj.getText().contains("successfully updated"),"duzenleme islemi basarisiz");

        //2.yontem
        //Tools.suscessMesajidogulama();
    }

    @Test(dependsOnMethods = "adreeDuzeltme")
    void adreesSilme () {

        List<WebElement> delteAll=driver.findElements(By.linkText("Delete"));
        WebElement son2delte=delteAll.get(delteAll.size()-2);
        son2delte.click();

        //1.yontem
        WebElement silmeMesaj=driver.findElement(adressEklendiMesaji);
        Assert.assertTrue(silmeMesaj.getText().contains("successfully deleted"),"silme islemi basarisiz");

        //2.yontem
        //Tools.suscessMesajidogulama();
    }
}
