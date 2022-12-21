package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        // Task open chrome  and navigate to https://www.eurotechstudy.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       //  driver.get("https://www.eurotechstudy.com/");


        // getting title with selenium   // selenyum ile başlık alma
//        String title= driver.getTitle();
//        System.out.println("title = " + title);


        driver.get("https://de-de.facebook.com/ ");

        String expectedTitle = " Facebook – Anmelden oder Registrieren";

        String actualTitle=driver.getTitle();

        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));

        if (expectedTitle.equals(actualTitle)){ // beklenen baslik esittir aktuel basliga
            System.out.println("passed");
        } else {
            System.out.println("Failed");
        }

        // get the url from browser  // url'yi tarayıcıdan al
        String currentUrl = driver.getCurrentUrl();  // gecerli URL
        System.out.println("currentUrl = " + currentUrl);


        // get the source of the page  // sayfanın kaynağını al
        String pageSource= driver.getPageSource();  // Sayfanin kaynagini almak icin
        System.out.println("pageSource = " + pageSource);


    }
}
