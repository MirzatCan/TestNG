package Gun02;


import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void EqualsOrnek() {
        String s1="Merhaba";
        String s2="Merhaba1";
        //Actual(olusan)   Expected(beklenen)  Mesaj(opsiyone/else gibi dusunucez)->beklenen olmzsa
        Assert.assertEquals(s1,s2,"esit degil");
    }

    @Test
    void NotEqualsOrnek() {
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertNotEquals(s1,s2,"esit");
    }

    @Test
    void TureOrnek() {
        int s1=50;
        int s2=502;

        Assert.assertTrue(s1==s2,"esit degil");
    }

    @Test
    void nullOrnek() {
        String s1=null;

        Assert.assertNull(s1,"olusan olmadi");   //beklenen null
    }

    @Test
    void direkFailOrnek() {  //sorum var
        int s3=50;

        if (s3==50)
            Assert.fail();   //  Assert.fail("esit degil");
    }
}
