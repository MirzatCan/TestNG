package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {
    //arabanin

    //dependsOnMethods = {"String"}  ->  {} icindeki test calismazsa calismasin diye bagliyoruz
    @Test
    void starCar(){
        System.out.println("satarCar");
        Assert.fail();                      //starCar hata verdi
    }
    @Test(dependsOnMethods = {"starCar"})   //starcar hata verdigi icin bu da calisamaz
    void driveCar(){
        System.out.println("driveCar");
    }
    @Test(dependsOnMethods = {"driveCar","starCar"})  // coklu da yapabiliriz. bunlara bagli calisin diye
    void parkCart(){
        System.out.println("parkCart");
    }
    @Test(dependsOnMethods = {"parkCart"},alwaysRun = true)  //bagli ama yine de calissin, araba bozulduginda hersey dursun
    void stopCart(){                                         //ama eminiyet sistemi calismaya devam etsin gibi
        System.out.println("stopCart");
    }

    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.
}
