import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task04 extends TestBase{

    @Test
    public void test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> webElementList = select.getOptions();
        for (WebElement each : webElementList){
            System.out.println(each.getText());
        }

        System.out.println("***********************************************");


        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//        for (int i=1; i<=5; i++){
//            ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//            select = new Select(ddm);
//            webElementList = select.getOptions();
//            webElementList.get(i).click();
//            Actions actions = new Actions(driver);
//            actions.sendKeys(Keys.ENTER).perform();
//            System.out.println(driver.getTitle());
//            driver.navigate().back();
//
//        }


        //2.Yol:

        int sayac=1;
        for (WebElement w:select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
            sayac++;
            if (sayac>=6){
                break;
            }
        }






        //Not: Select Class'ı kullanalım
    }
}
