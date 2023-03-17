package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

//    public static void main(String[] args) {
        //websitesini ac
        //login islemini yap
        //driveri kapat
//    }

//  @Test JUnit
//  public void test(){
//      websitesini ac
//      login islemini yap
//       driveri kapat
//   }

    // Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    @Test(priority = 1)
    public void webSiteyiAc(){
        System.out.println("websitesi acildi.");
    }

    @Test(priority = 2)
    public void loginIsleminiYap(){
        System.out.println("login yapildi");
    }
    @Test(priority = 3)
    public void diriveriKapat(){
        System.out.println("diriver kapatildi");
    }

}
