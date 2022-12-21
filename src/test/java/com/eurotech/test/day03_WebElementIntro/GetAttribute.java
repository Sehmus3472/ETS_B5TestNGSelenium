package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        // web elementlerin testini aliyoruz'isek bu method kullanilir getTexk methodu kadar kullanilan bir method degil ama bu getAttribute()
        // bize ayni sonucu verir. Bilinmesinde fayda var.

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://eurotech.study/login
        driver.get("http://eurotech.study/login");

        Thread.sleep(2000);  // Sayfanin hemen kapanmasini geciktirmek icin kullaniyoruz.

        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement emailInputBtn = driver.findElement(By.id("loginpage-input-email"));
        emailInputBtn.sendKeys("eurotech@gmail.com");

        String emailInputBtnAttributevalue = emailInputBtn.getAttribute("value");
        System.out.println("emailInputBtnAttribute = " + emailInputBtnAttributevalue);

        String password="Test12345!";
        WebElement passwordInputBtn = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBtn.sendKeys(password);

        String passwordInputBtnAttribute = passwordInputBtn.getAttribute("name");
        System.out.println("passwordInputBtnAttribute = " + passwordInputBtnAttribute);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        System.out.println("loginBtn.getAttribute : " + loginBtn.getAttribute("type"));

        driver.close(); // Acilan sayfayi kapatmamizi saglayan bir method.
                        // driver.quit() ise bütün pencereleri kapatiyor.

    }
}
