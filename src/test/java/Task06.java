import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task06 extends TestBase{


    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();


        // İkinci emoji öğelerini yazdırınız
        System.out.println(driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']")).getText());

        // Parent iframe e geri donun
        driver.switchTo().parentFrame();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> listText = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        int i=0;
        for (WebElement each : listText){
            //List<String> stringList = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","k","l"));
            String[]stringList ={"a","b","c","d","e","f","g","h","i","k","l"};
            listText = driver.findElements(By.xpath("//*[@data-upgraded=',MaterialTextfield']"));
            each.sendKeys(stringList[i]);
            i++;
        }


        // Apply button a basiniz
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}
