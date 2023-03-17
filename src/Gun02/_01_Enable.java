package Gun02;

import Utlity.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_Enable {

    @Test
    void test1 (){
        System.out.println("Test1");
    }

    @Test(enabled = false)   //aktif degil calisma demek
    void test2 (){
        System.out.println("Test2");
    }

    @Test
    void test3 (){
        System.out.println("Test3");
    }

    public static WebDriver driver;
    @BeforeClass
    void baslangicIslemleri(){
        System.out.println("Baslangic islemleri yapiliyor");
        System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
    }

    @AfterClass
    void kapatmaIslemleri(){
        System.out.println("Kapatma islemleri");
        Tools.bekle(3);
        driver.quit();
    }



}
