import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class Task10 extends TestBase{
    @Test
    public void test01() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        Thread.sleep(3000);
        String windowHandleSelenium = driver.getWindowHandle();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']"));
        //WebElement browser = driver.findElement(By.xpath("(//p//button)[81]"));
        Actions actions = new Actions(driver);

        //actions.moveToElement(browser).perform();

        actions.scrollToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN);
        driver.findElement(By.xpath("(//a[text()='documentation'])[5]")).click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//span[text()='ChromeDriver 113.0.5672.63']")).click();

        //Açılan pencerede chromedriver'i indirelim
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            if (!each.equals(windowHandleSelenium)){
                driver.switchTo().window(each);
            }
        }
        driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();

        //Driver'in indiğini doğrulayalım

        Files.exists(Paths.get("C:/Users/Mehmet/Downloads/chromedriver_win32.zip"));
        //"C:\Users\Lenovo\Downloads\chromedriver_win32.zip"
    }



}
