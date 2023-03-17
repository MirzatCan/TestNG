package Gun01;

import org.testng.annotations.*;

/*     @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */
public class _02_Annotations {
    @BeforeClass
    public void beforClass(){
        System.out.println("Classtan once calisti");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Classtan sonra calisti");
    }

    @BeforeMethod //her metod dan once calisicam
    public void beforTest(){
        System.out.println("metodlardan once calisti");
    }

    @AfterMethod //her metod dan sonra calisicam
    public void afterTest(){
        System.out.println("metodlardan sonra calisti");
    }

    @Test
    public void test1(){
        System.out.println("test1 calisti.");
    }

    @Test
    public void test2(){
        System.out.println("test2 calisti.");
    }
}

