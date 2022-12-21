package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://eurotech.study/");

        Thread.sleep(2000);  // main yanina eksep ediyor zaman belirledigimizde bunu da thread ile yapiyor.

        driver.close();  // close current tab  // gecerli olan sayfayi kapamamizi saglar.

        // driving new browser tab // sürüş yeni tarayıcı sekmesi ==>  // if we don't it will give invalid sesssion Id Exception
        driver=new ChromeDriver();                                       // yapmazsak geçersiz oturum kimliği İstisnası verir
        driver.get("https://www.facebook.com/");

        Thread.sleep(2000);

        driver.quit();  // close all tabs  // acik olan site icerisindeki bütün sayfalari yani tab lar kapanir.



    }
}
