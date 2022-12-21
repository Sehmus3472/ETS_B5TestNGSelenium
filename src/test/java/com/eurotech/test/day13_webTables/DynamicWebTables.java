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

import java.util.concurrent.TimeUnit;

public class DynamicWebTables {

    //
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void dynamicTableTest(){
        // dynamictable demek aldigimiz degerler üstünü tiladigimizda degerlerin degismesi demektir ve bu ismem de dynamic yapilidir.

        driver.get("https://demoqa.com/webtables");

        WebElement aldenName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]"));

        System.out.println("aldenName.getText() = " + aldenName.getText());

        WebElement lastName = driver.findElement(By.xpath("//div[text()='Last Name']"));
        lastName.click();

        //System.out.println("aldenName.getText() = " + aldenName.getText());

        // Assert.assertEquals(aldenName.getText(),"Cantrell");

        String name="Alden";

        WebElement alden = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='"+name+"']"));
        System.out.println("after click = "+alden.getText());

        Assert.assertEquals(alden.getText(),"Alden");

    }

}
