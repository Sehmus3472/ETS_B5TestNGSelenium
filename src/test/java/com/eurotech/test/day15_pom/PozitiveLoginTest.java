package com.eurotech.test.day15_pom;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.test.day14_propertiesSingleton.LoginTest;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PozitiveLoginTest extends TestBase {

    LoginPage loginPage=new LoginPage();


    @Test
    public void login() {
        driver.get(ConfigurationReader.get("url1"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginPage.loginBtn.click();

        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");

    }

    @Test
    public void loginWithMethod() { // test gecmedi
        driver.get(ConfigurationReader.get("url1"));
        loginPage.login();
        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");

    }

    @Test
    public void loginAsPerform() {
        driver.get(ConfigurationReader.get("url1"));

        loginPage.loginAsPerform();
        BrowserUtils.waitFor(2);

        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void loginAsProblemMethod() {
        driver.get(ConfigurationReader.get("url1"));

        loginPage.loginAsProblem();

        Assert.assertEquals(loginPage.productsText.getText(), "PRODUCTS");
    }

    @Test
    public void hoverTest(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        BrowserUtils.hover(img3);

    }


}
