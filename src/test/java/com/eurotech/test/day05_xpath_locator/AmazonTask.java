package com.eurotech.test.day05_xpath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         * go to the amazon webpage
         * write "selenium" to search box
         * verify that the result of the search
         */

        String product= "java";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();



        driver.findElement((By.xpath("//input[@type ='text']"))).sendKeys(product);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(1000);

        String actualText= driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]/..")).getText();

        System.out.println("actualText = " + actualText);

        if(actualText.contains(product)){
            System.out.println("PASS");
        }else{
            System.out.println("FAILED");
        }


        //driver.close();

    }
}
