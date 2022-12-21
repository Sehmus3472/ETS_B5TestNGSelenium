package com.eurotech.test.day09_TypeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }


        @Test
        public void test1() throws InterruptedException {
            driver.get("https://demo.aspnetawesome.com/");

            WebElement papayaDropdown=driver.findElement(By.xpath("(//div[text()='Papaya'])[1]"));

            //click dropdown to see available options
            Thread.sleep(2000);
            papayaDropdown.click();

            //get the options with findelements method and finding common locator between then
            List<WebElement> papayaList = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));

            System.out.println("papayaList.size() = " + papayaList.size());


            Assert.assertEquals(papayaList.size(),5); // --> shot way


            //Task
            // index and click()

            // print then one by one
            for (WebElement papaya : papayaList) {
                System.out.println("papaya.getText() = " + papaya.getText());
            }

            Assert.assertEquals(papayaList.get(3).getText(),"Nuts");


            papayaList.get(2).click();

            Thread.sleep(1000);


        }


    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
