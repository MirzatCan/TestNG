package Gun02;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {

    @Test
    void loginTest (){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("CanMirzat19970324@gmail.com");

        WebElement passWord=driver.findElement(By.id("input-password"));
        passWord.sendKeys("970324");

        WebElement loginTusu=driver.findElement(By.cssSelector("input[value='Login']"));
        loginTusu.click();


        Assert.assertTrue(driver.getTitle().equals("My Account"));  //title bdan test etmek
//        Assert.assertEquals(driver.getTitle(),"My Account","login Olamadi");
//        Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));  //url sinde test etmek

    }


}
