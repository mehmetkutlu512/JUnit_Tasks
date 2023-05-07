import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task08 extends TestBase{

    @Test
    public void test01() throws InterruptedException {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-175,0);//Genellikle slider' lar için bu method kullanılır
        Thread.sleep(5000);

        actions.dragAndDropBy(maviTus,-80,0);
        Thread.sleep(5000);

        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();
        Thread.sleep(5000);



        //-Sarı olduğunu test edelim

        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        //Assert.assertTrue(sari.isDisplayed());
        assert sari.isDisplayed();
    }
}
