package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
        driver.quit();
    }


    @Test
    public void ifarme() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // How to switch the Iframe --> Iframe nasıl değiştirilir

        // *** First way : using name or ID --> İlk yol : isim veya kimlik kullanmak
       driver.switchTo().frame("mce_0_ifr");

       // driver.findElement(By.cssSelector("#tinymce")).sendKeys("Eurotech Batch 5");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();  // Bu icteki testi siler.
        textArea.sendKeys("Eurotech Batch 5 was here ");

        driver.switchTo().parentFrame(); // Alttaki islem yeni yavru classa gectigi icin bu islem ile
        // ana classa gecip islem yapmamaiz gerekiyor aksi takdirde yaptigimiz islem hata verir.

        // **** Second way : switching index
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech Batch 5 was here for the 2nd time");

        driver.switchTo().parentFrame();

        //***** Third way : using web element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.sendKeys("This is third way");

        Thread.sleep(4000);
    }

    @Test
    public void nestedIframe(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switch to middle frame and get middle text --> orta çerçeveye geç ve orta metni al
            // we need to go first parent -> ilk ebeveyne gitmeliyiz
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        // go to Right frame and get text
            // driver.switchTo().defaultContent()://selenium switch the top
            // driver.switchTo().frame("frame-top");
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"Body\")).getText() = " + driver.findElement(By.tagName("Body")).getText());

        // go to bottom frame and get text

        // go to left frame and get text


    }

}
