package com.eurotech.test.day09_TypeOfElements2;

import com.beust.ah.A;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        // 1 locate your dropdown just like any other web element with unique locator
        // 1, benzersiz konum belirleyiciye sahip diğer herhangi bir web öğesi gibi açılır listenizi bulun
        // which has "select" tag name --> "seç" etiketi adı olan

       WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        // 2 create select object by passing that  elements as a constructor
        // 2 bu öğeleri yapıcı olarak ileterek select nesnesi oluşturun

        Select color = new Select(colorDropdown);

        // 3 getOptions()  --> retorn all available options from the dropdown
        // 3 getOptions() --> açılır menüden mevcut tüm seçenekleri geri al

        List<WebElement> colorlist = color.getOptions();

        // 4 print size of the option --> Seçeneğin 4 baskı boyutu
        System.out.println("colorlist.size() = " + colorlist.size());

        // verify that size is 11
        Assert.assertEquals(colorlist.size(),11);

        // print option one by one
        for(WebElement element : colorlist){
            System.out.println("element.getText() = " + element.getText());
        }

        // verify that default color is red  ->
        // getFirstSelectedOption() bununda birinci siradaki objecti cagirir.
        String expectedColor= "Red";
        String actualColor = color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor,"Verify that default color is red");


        // *** How to Seect option from dropdown? --> Açılır menüden seçenek nasıl seçilir?

        // 1.Select using visible text -> 1.Görünür metni kullanarak seçin ->
        Thread.sleep(4000);
        color.selectByVisibleText("Yellow");

        expectedColor= "Yellow";
        actualColor= color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor);

        // 2. Select using INDEX  --> 2. INDEX'i kullanarak seçin
        Thread.sleep(4000);
        color.selectByIndex(0);
        expectedColor="Red";
        actualColor = color.getFirstSelectedOption().getText();

        System.out.println("actualColor = " + actualColor);

        Assert.assertEquals(actualColor,expectedColor);

        // 3 Select using Value
        Thread.sleep(3000);
        color.selectByValue("7");
        expectedColor="Voilet";
        actualColor = color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);

        Assert.assertEquals(actualColor,expectedColor);


        // How can we click each of element? --> click()--> Her bir öğeyi nasıl tıklatabiliriz?

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
