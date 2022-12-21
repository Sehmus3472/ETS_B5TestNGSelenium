package com.eurotech.test.day09_TypeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfWebElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/");

        // save our elements inside the list --> elemanlarımızı listenin içine kaydet
        List<WebElement> menuList=driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));
        //List<WebElement> menuList=driver.findElements(By.xpath("//li"));

        //get size -> returns the size of the element -->elemanın boyutunu döndürür
        System.out.println("menuList.size() = " + menuList.size());


        int expectedSize=44;
        int actualSize=menuList.size();
        // Bu da ayni sonucu verir bize.
        Assert.assertEquals(actualSize,expectedSize,"Verify that menu size is 44");

        System.out.println("menuList.get(0) = " + menuList.get(0).getText());

        menuList.get(0).click();
        Thread.sleep(2000);

        //print all elements --> tüm öğeleri yazdır
        //iter + enter to get each loop with shortcut --> kısayol ile her döngüyü almak için girin(for each)
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
        }

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}
