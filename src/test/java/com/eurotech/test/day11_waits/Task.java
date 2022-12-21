package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task {
    /*
    -Sayfaya gidecek 5 saniye durup gecip sayfaya gececez.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.close();

    }

    @Test
    public void task() {

        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("timerAlertButton")).click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();

        System.out.println("alert.getText() = " + alert.getText());

        Assert.assertEquals(alert.getText(),"This alert appeared after 5 seconds");

    }
}
