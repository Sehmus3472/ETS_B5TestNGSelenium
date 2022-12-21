package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {



        // We have to  enter this line every time we want to open chome/firefox/safari ...
        // Her açmak istediğimizde bu satırı girmek zorundayız  chrome/firefox/safari ....
         WebDriverManager.chromedriver().setup();

        // Webdriver represent the browser   // Web sürücüsü tarayıcıyı temsil eder
        // we are creating driver for Chrome browser   // Chrome tarayıcı için sürücü oluşturuyoruz

         WebDriver driver = new ChromeDriver(); // poly (polimorfizim) örnegi

                // firefox example
        //WebDriverManager.firefoxdriver().setup();
        //WebDriver driver = new FirefoxDriver();

        driver.get("https://www.eurotechstudy.com/");



    }

}
