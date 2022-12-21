package com.eurotech.test.day12_actionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ActionTest {
    //Hover Over: Progamda bazen mausu bir yerin üzerine getirdigimizde görünen bazi bilgiler var buna Hover over denir.
    //            tiklama yapmadan acilan yada görünen kisimdir.

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
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
    public void hoverOver(){
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img2 = driver.findElement(By.xpath("(//img)[3]"));

        // Action ---> class that contains all user interactions -->tüm kullanıcı etkileşimlerini içeren sınıf
        Actions actions = new Actions(driver);

        // move your mouse to the web element (hover over) --> farenizi web öğesine getirin (üzerine gelin)
        // perform the action , complete the action --> eylemi gerçekleştir, eylemi tamamla
        actions.moveToElement(img2).perform();


        WebElement view_profile2 = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile2.getText() = " + view_profile2.getText());

        Assert.assertTrue(view_profile2.isDisplayed(),"Verify that element is DISPLAYED");
    }

    @Test
    public void dragAndDrop(){

        // DraganDrop ()tut birak) da ise maus ile herhangi bir elementi tiklarak bir yerden baska bir yere sürükleme ile yapilan islemdir.
        // Bir yazi yada kutuyu mausa basili tutatak bir yerden baska bir yere sürüklemeye denir.

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));

        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);

        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        // first way -->ilk yol
        //Assert.assertEquals(verifyMessage.getText(),"Dropped!","verify that element has dropped");

        // second way-->ikinci yol
        Assert.assertTrue(verifyMessage.isDisplayed());

    }

    @Test
    public void dragAndDrop2(){
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));

        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        
        // second way --> ikinci yol
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
}
