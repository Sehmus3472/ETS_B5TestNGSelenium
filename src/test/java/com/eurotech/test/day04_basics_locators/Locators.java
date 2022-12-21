package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName = driver.findElement(By.id("userName"));
        inputUserName.sendKeys(faker.name().firstName());

        WebElement inputUserEmail=driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(3000);


    }
}
