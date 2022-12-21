package com.eurotech.test.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername() {  // yanlış kullanıcı adı testi
        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong username Test");

        extentLogger.info("click Understand button");
        loginPage.understandBtn_Loc.click();

        extentLogger.info("Enter wrong username");
        loginPage.usernameInput_loc.sendKeys("eurot@gmail.com");

        extentLogger.info("Enter correct password");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        String actualMessage = loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that NOT log in");  //Giriş YAPMADIĞINIZI doğrulayın
        Assert.assertEquals(actualMessage, "Invalid Credential!");  // burdan bir harf cikardigimizda olumsuz test ornegi yapar.

        extentLogger.pass("PASSED");
    }


    @Test
    public void wrongPassword(){
        LoginPage loginPage=new LoginPage();

        extentLogger=report.createTest("Wrong Password Test");

        extentLogger.info("click Understand button");
        loginPage.understandBtn_Loc.click();

        extentLogger.info("Enter correct username");
        loginPage.usernameInput_loc.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter wrong password");
        loginPage.passwordInput_loc.sendKeys("wrong password");

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        String actualMessage=loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");

        extentLogger.pass("PASSED");

    }
}
