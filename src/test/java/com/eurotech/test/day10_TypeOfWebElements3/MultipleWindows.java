package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.close();
        driver.quit();
    }


    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle(); // Basligini alacak.
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

        Thread.sleep(2000);

       //  String titleAfterClick = driver.getTitle();

        String currentTab = driver.getWindowHandle();  // title THe internet and has Id --> başlıgin  İnternet ve kimliği var.
        // her sayinin id sini almaya yardimci olur. Gectigi yeni sayfayi kontrol etmemize olanak verir.
        System.out.println("currentTab = " + currentTab);
        //CDwindow-FCA114EF84849ED4EE4F7FE3AFC82013
        //CDwindow-8C9BAB11C957A95C71F45659A6EBC37E // it wil change every time --> her seferinde değişecek

        Set<String> windoHandles = driver.getWindowHandles();


        System.out.println("driver.getTitle() = " + driver.getTitle() );
        // First and most important thing --> İlk ve en önemli şey
        // HasSet is a collection of an items where every item is unique!--> HasSet, her öğenin benzersiz olduğu bir öğe koleksiyonudur!

        for (String tab : windoHandles) { // go and check one by one  --> git tek tek kontrol et

            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows(){

        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            //if(driver.getTitle().equals("New Window")){
            if(driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
                break;
            }

        }

        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    }

