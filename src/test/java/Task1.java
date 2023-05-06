import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task1 extends TestBase{

     List<WebElement> webDriverList;

    @Test
    public void task01() throws InterruptedException {

        //*** Aşağıdaki Task'i Junit framework'u ile yapınız
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım
        webDriverList = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for (int i = 0; i < webDriverList.size(); i++) {
            webDriverList = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            webDriverList.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+1 + ". Sayfa Başlığı = " + driver.getTitle());
            driver.navigate().back();

        }

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
