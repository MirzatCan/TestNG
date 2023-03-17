package Gun02;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _04_SubscribeNewsLetter extends BaseDriver {
/*
      Senaryo
      1- Siteyi açınız.
      2- Newsletter  Subscribe işlemini abone lunuz(YES)
      3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
      4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
*/
    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("input[value='1']");
    By no=By.cssSelector("input[value='0']");
    By conti=By.cssSelector("input[value='Continue']");

    @Test(priority = 1)
    void NewsletterAboneOl() {
        WebElement newsletter=driver.findElement(link);
        newsletter.click();

        WebElement yesTusu=driver.findElement(yes);
        yesTusu.click();

        WebElement continueTusu=driver.findElement(conti);
        continueTusu.click();

        Tools.suscessMesajidogulama();
    }

    @Test(priority = 2)
    void NewsletterAboneliktenCikma() {
        WebElement newsletter=driver.findElement(link);
        newsletter.click();

        WebElement noTusu=driver.findElement(no);
        noTusu.click();

        WebElement continueTusu=driver.findElement(conti);
        continueTusu.click();

        Tools.suscessMesajidogulama();
    }

    @Test(priority = 3)
    void NewsletterAbonelikDurumuDistirme(){
        WebElement newsletter=driver.findElement(link);
        newsletter.click();

        WebElement yesTusu=driver.findElement(yes);
        WebElement noTusu=driver.findElement(no);

        if (yesTusu.isSelected())
            noTusu.click();
        else
            yesTusu.click();

        WebElement continueTusu=driver.findElement(conti);
        continueTusu.click();

        Tools.suscessMesajidogulama();

    }


}
