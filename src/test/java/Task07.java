import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task07 extends TestBase{


    @Test
    public void test01() throws InterruptedException {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(yaziTahtasi);

        for (int i=0; i<10; i++){
            actions.moveByOffset(-5, 5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);
        }
        actions.release().build().perform();

        Thread.sleep(5000);

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
        Thread.sleep(5000);


        //- Sayfayi kapatiniz
        driver.close();
    }

    // doubleClick ( ): WebElement’e çift tıklama yapar
    // clickAndHold (WebElement element): WebElement uzerinde click yapili olarak bizden komut bekler.
    // dragAndDrop (dragTarget, dropTarget): WebElement’i bir noktadan diğerine sürükler ve bırakır
    // moveToElement (WebElement element): Mouse’u istedigimiz WebElement’in uzerinde tutar
    // contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar.
    // release(WebElement element) - Sol tıklamayı serbest bırakır (basılı durumdadır).
    // build() - Bileşik bir eylem oluşturur
}
