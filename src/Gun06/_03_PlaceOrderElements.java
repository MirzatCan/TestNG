package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class _03_PlaceOrderElements {
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
    public _03_PlaceOrderElements() {
        PageFactory.initElements(BaseDriver.driver,this);
        //driver.findElement() in hepsi icin gecerli.
    }

    @FindBy(name = "search")
    public WebElement aramaTusu;
    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement aramaButunu;
    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> eklemeler;
    @FindBy(linkText = "shopping cart")
    public WebElement shoppingCart;
    @FindBy(linkText = "Checkout")
    public WebElement checkOut;

    @FindBy(id = "button-payment-address")
    public WebElement step2Butun;
    @FindBy(id = "button-shipping-address")
    public WebElement step3Butun;
    @FindBy(id = "button-shipping-method")
    public WebElement step4Butun;
    @FindBy(name = "agree")
    public WebElement step5MaviTik;
    @FindBy(id = "button-payment-method")
    public WebElement step5Butun;
    @FindBy(id = "button-confirm")
    public WebElement confirm;
    @FindBy(css = "[id='content']>h1")
    public WebElement sonMesaj;

}
