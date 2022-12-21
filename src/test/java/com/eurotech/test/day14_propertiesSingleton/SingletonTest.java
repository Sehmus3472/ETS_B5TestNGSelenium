package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
/*
    @Test
    public void test1(){
       //  Singleton singleton = new Singleton();
        String driver1 = Singleton.getInstance();
        String driver2 = Singleton.getInstance();

        System.out.println("driver1 = " + driver1);
        System.out.println("driver2 = " + driver2);
    }

    @Test
    public void test2(){
        // WebDriver driver = WebDriverFactory.getDriver("chrome");

        WebDriver driver= Driver.get();
        driver.get(ConfigurationReader.get("url"));

    }

 */

    @Test
    public void test3(){

        // bu yöntem ile her calisma icin yeni sayfa acaiyor.
        // WebDriver driver = WebDriverFactory.getDriver("chrome");

        WebDriver driver = Driver.get(); // Burda yeni kodumuz ile ise tüm testleri hepsini tek sayfada calistiriyor.
        driver.get("https://www.amazon.co.uk/");

        // Driver.get().get("https://www.amazon.co.uk/"); // Bu yöntem ile de yapabiliriz ama her seferinde sürücüye ihtiyacımız var

       //  Driver.closeDriver();
    }

    @Test
    public void test4(){

        // bu yöntem ile her calisma icin yeni sayfa aciyor.
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // WebDriver driver = Driver.get(); // Burda ise hepsini tek sayfada calistiriyor.

        driver.get("http://eurotech.study/login");

    }

}
