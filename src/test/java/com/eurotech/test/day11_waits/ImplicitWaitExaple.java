package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitExaple {
    /*
    - Implicitwait her faid elemenet sonra yani kendisinden sonra calisan her elementten sonra calisir.
    - Verilen süreden önce bulduysa kodu kalan süreyi beklemeden diger kodlari calistirir.
    - En cok kullanacagimiz bir yöntemdir.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Testin bekleme süresine ihtiyaci icin bunu Befor mottoda yazdik ki
         // her calistirdigimiz testten önce calissin ki bekle sürecinin dolayi testlerimiz hata vermesin her test yenine yari yazmak yerine
        // Befor method icinde yazdik ki her testen once otomatikmem calissin.

        //used for selenium version 4 --> slemium versoin 4 icin  bekleme sürec bu sekilde kullanilir.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void implicitWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement messageText = driver.findElement(By.cssSelector("#checkbox-example>p"));

        System.out.println("messageText.getText() = " + messageText.getText());

        Assert.assertEquals(messageText.getText(),"It's gone!");

    }

    @Test
    public void implicitWait2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#input-example>button")).click();

        WebElement enableMessage = driver.findElement(By.cssSelector("#input-example>p"));

        System.out.println("enableMessage.getText() = " + enableMessage.getText());

        Assert.assertEquals(enableMessage.getText(),"It's enabled!");

    }

}
