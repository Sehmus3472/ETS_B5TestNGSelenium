package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // WebDriverWait wait=new WebDriverWait(driver,15);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", demoTable);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void printTable() {

        // tablo alarak islem yaptik bu textin calismasinda kolaylik saglar cobuk cabuk testimiz bozulmaz.
        WebElement tableDemo = driver.findElement(By.xpath("//table[@border='1']"));

        System.out.println("tableDemo.getText() = " + tableDemo.getText());

        Assert.assertTrue(tableDemo.getText().contains("Mecca"));
    }

    @Test
    public void getAllHeaders(){

        // get allColumn headers --> tüm sütun başlıklarını al
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        // get size
        System.out.println("allHeaders.size() = " + allHeaders.size());  // size = 7

        // to get allHeaders --> use foreach loop  ==> tüm Başlıkları almak için -> foreach döngüsünü kullanın
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }

        // to get allRow headers  ==> tüm Satır başlıklarını almak için

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        //get size  --> //boyutu al
        System.out.println("allRows.size() = " + allRows.size());
        for (WebElement allRow : allRows) {
            System.out.println("allRow.getText() = " + allRow.getText());
        }
    }

    @Test
    public void getRows() {

        //all rows ile yani  bu method da ise bir satirin tamamini alarak hepsini alma yapiyoruz.
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("allRows.size() = " + allRows.size());

        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        for (int i = 1; i <= allRows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]"));
            // burda iki degeri birbirleri esitleyerek tirnak "+i+" acarak dinamik kismi koletera ekleyip yazdigimiz kodu dinamik yaptik.
            System.out.println(i + " row = " + row.getText());
        }
    }

    @Test
    public void getAllCellOnOneRow(){
        // Bu method da ise hücresel olarak almamizi saglar.Yani kutu kutu yazdirir.
        //task -> get Burj Khalifa's info as a list --> Burj Khalifa'nın bilgilerini bir liste olarak alın

        List<WebElement> burjKhalifa = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        System.out.println("burjKhalifa.size() = " + burjKhalifa.size());

        Assert.assertEquals(burjKhalifa.size(),6);

        for (WebElement burj : burjKhalifa) {
            System.out.println("burj.getText() = " + burj.getText());
        }
    }

    @Test
    public void getSingleCell(){
        // Tablodaki sadece tek bir hücreyi almak icin kullanacagimiz method.
        // task one cell --> görev bir hücre
        // get Height from Clock Tower Hotel --> Clock Tower Hotel'den Yükseklik al
        //verify that height is 601m --> yüksekliğin 601m olduğunu doğrulayın

        WebElement heightClockTowerHotel = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("heightClockTowerHotel.getText() = " + heightClockTowerHotel.getText());
        Assert.assertEquals(heightClockTowerHotel.getText(),"601m");

    }

    @Test
    public void printAllCellByIndex(){

        // *** we need nested loop --> iç içe döngüye ihtiyacımız var
        // *** we need methods --> yöntemlere ihtiyacımız var

        int rowNumber=getNumberOfRows();
        int columnNumber=getNumberOfColumn();

        System.out.println("rowNumber = " + rowNumber);  // 4
        System.out.println("columnNumber = " + columnNumber);  // 7

        // iterate through each row on the table --> tablodaki her satırda yineleme
        for (int i = 1; i <=rowNumber ; i++) {
            // iterate through each row cell in the row --> satırdaki her satır hücresini yinele
            for (int j = 1; j < columnNumber; j++) {
                // bununla dinamik bir kod yaziyoruz. "+i+" ve "+j+"
                String cellPath="//table[@border='1']/tbody/tr["+i+"]/td["+j+"]"; //
                System.out.println("cellPath = " + cellPath);
                WebElement cell = driver.findElement(By.xpath(cellPath));
                System.out.println("cell.getText() = " + cell.getText());
            }
        }

    }

    private int getNumberOfColumn() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

}
