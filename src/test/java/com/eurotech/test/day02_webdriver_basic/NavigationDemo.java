package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // go to google -->Google'a git
        // go to facebook --> facebook git
        // turn back --> geri dön
        // you should see google again --> google'ı tekrar görmelisin


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        // wait 2 second here and then move on // burada 2 saniye bekleyin ve devam edin
        // Bununla bekletme süresini ayarlar.
        Thread.sleep(2000);

        // Navgate to another website with different selenium method
        // Farklı selenyum yöntemiyle başka bir web sitesine gidin
        driver.navigate().to("https://de-de.facebook.com/ ");

        Thread.sleep(3000);

        // goes back to previous page   // önceki sayfaya geri döner
        driver.navigate().back();

        // goes back to back  // geri geri gider
        driver.navigate().forward();

        Thread.sleep(2000);

        // refresh to webpage  // web sayfasına yenile
        driver.navigate().refresh();

    }
}
