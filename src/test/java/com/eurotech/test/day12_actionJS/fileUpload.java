package com.eurotech.test.day12_actionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fileUpload {

    //
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void fileUploadTest1() {
        driver.get("https://the-internet.herokuapp.com/upload");

        // testimize yada koda herhangi bir dosya kaydetmek yada eklemek icin kullaniyoruz cok tercih edilen bir yol degil

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        chooseFile.sendKeys("C:/Users/sehmu/Desktop/EurotechB5.txt.txt");

        driver.findElement(By.id("file-submit")).click();

        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText, "EurotechB5.txt.txt");


    }

    @Test
    public void fileUploadTest2() {  //  testimize yada koda herhangi bir dosya kaydetmek yada eklemek icin kullaniyoruz.
        // Tercih edilen bir yöntemdir.

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir")); // bu calistiracagim
        // methodun yolunu vermis oluyor.
        // System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("os.name"));// Bilgisayar sistemi ile
        // ilgili bilgiler verir. Yani hangi bilsiyasar ve program kullanildigi ile ilgili.
        // System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

        chooseFile.sendKeys("C:/Users/sehmu/Desktop/EurotechB5.txt.txt");

        String projectPath=System.getProperty("user.dir");

        String filePath="src/test/resources/EurotechB5.txt";

        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        chooseFile.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText, "EurotechB5.txt");

    }

}
