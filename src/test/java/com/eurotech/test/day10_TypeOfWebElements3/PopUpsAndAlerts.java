package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void PopUpHtml() throws InterruptedException {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=b656a");

        // click the confirm button -->onayla düğmesini tıklayın
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();

        // click pop ups - yes--> pop-up'ları tıklayın - evet
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(2000);

        //verify that confirm is accepted --> onaylamanın kabul edildiğini doğrulayın
        String expectedMesssage="You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(),expectedMesssage);

    }

    @Test
    public void jsAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        //click -> Click for JS Alert Button-->JS Uyarı Butonu için tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //e.g.: 1 switch to JS alert popUp -->1 JS uyarı açılır penceresine geçiş
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        //click to OK -->Tamam için tıklayın
        alert.accept();
        Thread.sleep(1000);


        //e.g.: 2 Click For JS Confirm -->ör.: 2 JS Onayı İçin Tıklayın

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        //click to cancel -->iptal etmek için tıklayın
        alert.dismiss();
        Thread.sleep(1000);

        //e.g.: 3 click -> Click For JS Prompt -->3 tıklayın -> JS İstemi İçin Tıklayın
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //send keys to JS prompt -->anahtarları JS istemine gönder
        alert.sendKeys("Eurotech Batch 5");
        // to get text from pop up -->açılır pencereden metin almak için
        System.out.println("alert.getText() = " + alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);
    }

}
