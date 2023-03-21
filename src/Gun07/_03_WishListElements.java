package Gun07;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _03_WishListElements {
    public _03_WishListElements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(css = "button[data-original-title='Add to Wish List']")
    List<WebElement> urunleriBegenilerAtmaButunu;

    @FindBy(css = "[class='caption']>h4")
    List<WebElement> urunlerinAdi;

    @FindBy(linkText = "wish list")
    WebElement wishlist;

    @FindBy(xpath = "//*[@class='text-left']//a")
    List<WebElement> begenilerUrunler;

}
