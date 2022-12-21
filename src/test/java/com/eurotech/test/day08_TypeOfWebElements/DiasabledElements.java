package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiasabledElements {

    /** What is disabled elements?
     * Disable mean means :
     * U can NOT interact the element
     * U can NOT click
     * or
     * U can NOT write something
     *
     */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement diasbleElement= driver.findElement(By.cssSelector("#input-example>input"));
        // bazi elementler tikladiktan sonra etkilesime girebiliyor bu tür elementlere diasble element denir.
        // .click() ile cagrilip tiklamak gerekir.
        Assert.assertFalse(diasbleElement.isEnabled(),"Verify that element is NOT enable or element is disable");

        //if we click the enable button it will be interactive --> etkinleştir düğmesine tıklarsak etkileşimli olacaktır

        WebElement enableButton= driver.findElement(By.cssSelector("#input-example>button"));
        enableButton.click();

        //there is a process and we add wait-->bir işlem var ve beklemeyi ekliyoruz
        Thread.sleep(4000);

        Assert.assertTrue(diasbleElement.isEnabled(),"Verify that element is enable");


        driver.close();

    }

}
