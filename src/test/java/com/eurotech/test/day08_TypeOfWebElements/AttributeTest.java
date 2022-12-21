package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    // Gecerli bir deger kullanirsak o Attributenin degerini bize döndürür.
    // Eger olamayan bir Attribute yi gecicirsek bu sefer null sonucunu verir.
    // getAttribute ile HTML ile kullanabiliriz.

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement userInputBox=driver.findElement(By.cssSelector("#userName"));
        System.out.println("userInputBox.getAttribute(\"id\") = " + userInputBox.getAttribute("id"));
        System.out.println("userInputBox.getAttribute(\"class\") = " + userInputBox.getAttribute("class"));
        System.out.println("userInputBox.getAttribute(\"type\") = " + userInputBox.getAttribute("type"));
        System.out.println("userInputBox.getAttribute(\"placeholder\") = " + userInputBox.getAttribute("placeholder"));
        System.out.println("userInputBox.getAttribute(\"autocomplete\") = " + userInputBox.getAttribute("autocomplete"));


        System.out.println("userInputBox.getAttribute(\"outerHTML\") = " + userInputBox.getAttribute("outerHTML"));
        System.out.println("userInputBox.getAttribute(\"innerHTML\") = " + userInputBox.getAttribute("innerHTML"));


        driver.close();

    }
}
