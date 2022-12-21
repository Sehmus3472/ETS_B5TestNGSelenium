package com.eurotech.test.day19_review;

import com.eurotech.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class StaleElement extends TestBase {

    @Test
    public void testName() {
        driver.get("https://freecrm.com/");
        WebElement loginBtn = driver.findElement(By.linkText("Login"));
        loginBtn.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345abc");

        driver.navigate().refresh();

        try {
            emailInput.sendKeys("eurotech@gmail.com");
            passwordInput.sendKeys("12345abc");
        } catch (StaleElementReferenceException e) {
            emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("eurotech@gmail.com");

            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("12345abc");
        }

    }
}

