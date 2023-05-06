import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task02 extends TestBase{
    @Test
    public void task02() {
        //*** Aşağıdaki Task'i Junit framework'u ile yapınız
        //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //- Add Element butonuna 100 defa basınız
        WebElement addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));

        for (int i = 0; i < 10; i++) {
            addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));
            addElement.click();
        }

        //- 10 defa basıldığını test ediniz
        List<WebElement> webElementList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(10, webElementList.size());


        //- 9 defa delete butonuna basınız
        WebElement delete = driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));

        for (int i = 0; i < 9; i++) {
            delete = driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));
            delete.click();
        }


        //- 9 defa basıldığını doğrulayınız
        delete = driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));
        Assert.assertTrue(delete.isDisplayed());


        //- Sayfayı kapatınız
        driver.close();
    }
}
