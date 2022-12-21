package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName = driver.findElement(By.id("userName"));

        inputUserName.sendKeys("Mike");

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys("mike@gmail.com");

        Thread.sleep(3000);


       // driver.close();
    }
}
