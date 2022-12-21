package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChance {
    public static void main(String[] args) {

        // open Chorme brower

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to "http://eurotech.study/login"

        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();

        // click to login btn

        String name = "ali";
        int num = 4;
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        // verify not changed is Url

        String expectedUrl= "http://eurotech.study/login";  // Beklenen sonuc
        String actualUrl= driver.getCurrentUrl();  // Test sonucu elde edilen sonuc
        System.out.println("actualUrl=" + actualUrl);

        if(expectedUrl.equals(actualUrl)){ // Yapilan islemde iki sayfanin ayni olup olmadigini test etmek icin kullaniyoruz.
            System.out.println("pass");
        }else{
            System.out.println("Fail");
        }

        driver.close();  // bu yöntem acik olan sayfayi kapatir.


    }
}
