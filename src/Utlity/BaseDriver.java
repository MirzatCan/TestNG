package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIslemleri(){
        Logger logger= Logger.getLogger(""); // output a ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
        System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));  //Gun3  Class 2 de selectByIndex konusunda anlatildi
        loginTest();
    }

    @AfterClass
    public void kapatmaIslemleri(){
        Tools.bekle(3);
        driver.quit();
    }

    void loginTest () {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("CanMirzat19970324@gmail.com");

        WebElement passWord = driver.findElement(By.id("input-password"));
        passWord.sendKeys("970324");

        WebElement loginTusu = driver.findElement(By.cssSelector("input[value='Login']"));
        loginTusu.click();


        Assert.assertTrue(driver.getTitle().equals("My Account"));
    }

}
