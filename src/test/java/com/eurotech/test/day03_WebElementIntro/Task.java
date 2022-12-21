package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        /*
        -open chrome browser
        -go to https://www.amazon.com
        -enter 'Java' in the search button
        -click on search  button
        -verify that title has changed
         */



        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

        Thread.sleep(2000);

        WebElement searchBtn= driver.findElement(By.id("twotabsearchtextbox"));
        searchBtn.sendKeys("Java");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String expectedTitle = "Amazon.com : Java";
        String actualTitle= driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("pass");
        }else{
            System.out.println("fall");
        }


    }
}
