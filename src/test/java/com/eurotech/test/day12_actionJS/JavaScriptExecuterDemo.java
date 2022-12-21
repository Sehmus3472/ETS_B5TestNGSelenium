package com.eurotech.test.day12_actionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterDemo {

    // Bazen her sey normal olmasina ragmen seleniumda yazdigimizda kodumuz hata verebilir.
    // Böyle bir dururmda click() methodu ise yaramadiginda JavaScriptExecuter methodunu kullaniriz.Güclü bir alt yapisi var.
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void clickWithJS() {

        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Germany"));
        //ask google to --> how to click with js executor -->google'a sor --> js yürütücüsü ile nasıl tıklanır
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", germany);

    }

    @Test
    public void typeWithJS() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text = "Hello World!";

        // ask to google --> How to sendKeys using with JS executor

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // ask to google --> How to scroll down in selenium JS executor
        // google'a sor --> Selenium JS yürütücüsünde nasıl aşağı kaydırılır

        // Bu method ile maus'u yukari dogri getirdigimizde bize asagi kismi yukari dogru cektigimizde ise asagi yönü bize verecek.
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }
    }

    @Test
    public void scrollToElement() {

        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement germany = driver.findElement(By.linkText("Germany"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // ask to google --> How to scroll into view with js Executor
        // google'a sor --> js Executor ile görünüme nasıl kaydırılır

        jse.executeScript("arguments[0].scrollIntoView(true);", germany);

        jse.executeScript("arguments[0].click();", germany);

    }
}
