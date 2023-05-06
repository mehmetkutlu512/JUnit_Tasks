import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03 {

    static WebDriver driver;
    WebElement aramaKutusu;


    @BeforeClass
    public static void beforeClass() throws Exception {
        //-BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        //-Before methodunda http://www.google.com adresine gidin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception {

        driver.get("http://www.google.com");

    }

    @Test
    public void test1() throws InterruptedException {


        //-Üç farklı test methodu ile;
        //-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);

        //-AfterClass ile kapatın
    }

    @Test
    public void test2() throws InterruptedException {
        //-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("Lord of the Rings", Keys.ENTER);

    }

    @Test
    public void test3() throws InterruptedException {
        //-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);

    }

    @After
    public void tearDown() throws Exception {
        //-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc = sonucYazisi.getText().split(" ")[1];
        System.out.println(sonuc);

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
