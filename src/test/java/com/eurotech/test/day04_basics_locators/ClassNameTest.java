package com.eurotech.test.day04_basics_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        // 1.way
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345!");

        // 2. way--lazy way
        // driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);   // 02:31 den devam edilecek

        WebElement experienceText= driver.findElement(By.className("my-2"));
        System.out.println("experienceText.getText() = " + experienceText.getText());

        // if there is a space in the className locator we can not use clasName locator ==>className bulucuda bir boşluk varsa, clasName bulucuyu kullanamayız
        // System.out.println("driver.findElement(By.className(\"navbar bg-dark\")).getText() = " + driver.findElement(By.className("navbar bg-dark")).getText());


        driver.close();

    }
}
