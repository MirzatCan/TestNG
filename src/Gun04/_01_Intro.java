package Gun04;

import org.testng.annotations.*;

public class _01_Intro {
    /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroups
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroups
       @AfterTest
     @AfterSuit
   */

    @BeforeSuite
    void bSuite(){System.out.println("Before Suite");}
    @BeforeTest
    void bTest(){System.out.println("Before Test");}
    @BeforeGroups
    void bgroups(){System.out.println("Before Groups");}
    @BeforeClass
    void bclass(){System.out.println("Before Class");}
    @BeforeMethod
    void bmetod(){System.out.println("Before Method");}
    @Test
    void Intro1_Test1(){System.out.println("Intro1->Test1");}
    @Test
    void Intro1_Test2(){System.out.println("Intro1->Test2");}
    @AfterMethod
    void Ametod(){System.out.println("After Method");}
    @AfterClass
    void aclass(){System.out.println("After Class");}
    @AfterGroups
    void agroups(){System.out.println("After Groups");}
    @AfterTest
    void aTest(){System.out.println("After Test");}
    @AfterSuite
    void aSuite(){System.out.println("After Suite");}


}
