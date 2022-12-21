package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

        // ChechBox Istedigini secip secmemede sikinti yapmayan bir elementir.
        // Belli bir grup ChechBox sectiysek yada secmediysek herhangi bir sekilde ChechBox etkilenmiyor.
        //  isSelected() methodu kullaniyoruz herhangi bir secilme olup olmadigini anlamak icin kullaniyoruz.
        // click() methodu kullaniyoruz hem secme hemde secmeyi kaldirmak icin.

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
         driver.manage().window().maximize(); // Testimiz bazen gecmeye bilir selenium sayfa üstünde test yaptigindan
        // sayfanin hepsi görünmez bu yukardaki kodu

        WebElement sports=driver.findElement(By.cssSelector("[id='hobbies-checkbox-1']"));
        Assert.assertFalse(sports.isSelected()); // assert: false, condition: false, test: PASS

        WebElement reading=driver.findElement(By.cssSelector("[id='hobbies-checkbox-2']"));
        Assert.assertFalse(reading.isSelected()); // assert: false, condition: false, test: PASS

        WebElement music=driver.findElement(By.cssSelector("[id='hobbies-checkbox-3']"));
        Assert.assertFalse(music.isSelected()); // assert: false, condition: false, test: PASS

        // Class Task
        // complete the task
        // click all the checkbox
        // than assert that is selected or not


        WebElement sportsCheckBox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));

        Thread.sleep(2000);
        sportsCheckBox.click();
        Thread.sleep(2000);

        Assert.assertTrue(sportsCheckBox.isSelected(),"verify that sports is selected");

        driver.close();

    }

    @Test
    public void test2 () throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        Assert.assertTrue(checkBox2.isSelected(), "verify that checkbox 2 is selected");
        Assert.assertFalse(checkBox1.isSelected(), "verify that checkbox 1 is NOT selected");

        checkBox1.click();

        Thread.sleep(3000);

        driver.close();


    }


    @Test
    public void test3() throws InterruptedException {

        //https://the-internet.herokuapp.com/dynamic_loading

        //Homework

        //Example 2: Element rendered after the fact -->click
        //click that element
        //verify that hello world is not displayed
        //click start button
        //verify that hello element is displayed
        //and verify that "Hello World!" text is present


        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(6000);


        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello World!']"));

        //Assert.assertFalse(hello.isDisplayed(),"Verify that element is NOT displayed");

        Assert.assertTrue(hello.isDisplayed(),"verify that element is displayed");

        driver.close();

    }

}
