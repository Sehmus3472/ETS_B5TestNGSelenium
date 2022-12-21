package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    /*
    - Explicitwait bir kosula göre calisisr.
    - Tek bir element icin calisir.
    - Verilen görevi belirtilen süreden daha kisa yaparsa beklemeden diger kodlara gecer.
     */

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver,15);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void explicitwait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver,15);

        driver.findElement(By.cssSelector("#start>button")).click();

        WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        //it will wait up to 15 seconds until hello element is visible
        //merhaba öğesi görünene kadar 15 saniye kadar bekleyecektir

        wait.until(ExpectedConditions.visibilityOf(helloText));

        System.out.println("helloText.getText() = " + helloText.getText());

        Assert.assertEquals(helloText.getText(),"Hello World!");
    }

    @Test
    public void explicitwait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver,15);

        driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();

        WebElement imputBox = driver.findElement(By.cssSelector("#input-example>input"));

        wait.until(ExpectedConditions.elementToBeClickable(imputBox));

        imputBox.sendKeys("Eurotech");
        WebElement messageText = driver.findElement(By.cssSelector("#input-example>p"));
        System.out.println("messageText.getText() = " + messageText.getText());

        Assert.assertEquals(messageText.getText(),"It's enabled!");

    }

}
