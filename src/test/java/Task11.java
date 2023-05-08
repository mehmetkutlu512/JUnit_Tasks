import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class Task11 extends TestBase{
    /*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
*/

    @Test
    public void excelTest1() throws IOException {
        String desktopPath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\";
        String fileName = "data.xlsx";
        System.out.println(desktopPath);
        // Dosya oluşturulur
        File file = new File(desktopPath, fileName);
        if (file.createNewFile()){
            System.out.println("Dosya oluşturuldu : " + file.getAbsolutePath());
        } else {
            System.out.println("Dosya zaten var");
        }
        // Workbook ve Sheet oluşturulur

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        // Veriler hücrelere yazılır
        Row row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("email");
        row1.createCell(1).setCellValue("password");
        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("evren.techproed@gmail.com");
        row2.createCell(1).setCellValue("asdfgh");

        // Dosya kaydedilir
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();
    }

    @Test
    public void excelTest2() throws IOException {
        //    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
        FileInputStream fis = new FileInputStream("C:\\Users\\Mehmet\\OneDrive\\Masaüstü\\data.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String email = workbook.getSheet("Sheet0").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("Sheet0").getRow(1).getCell(0).toString();





        //    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        //    -Login olduğumuzu doğrulayalım
    }
}
