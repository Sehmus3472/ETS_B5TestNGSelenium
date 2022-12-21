package com.eurotech.test.day21_FinalReview;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest extends TestBase {

    @DataProvider
    public Object[][] excelLOgin() {

        /**Sınıf Görevi
         * @DataProvider kullanarak DevEX kullanıcı kimlik bilgileriyle dört test verisi oluşturun
         * ve bu veri kümesini extensionReports ile yürütün
         */

        String[][] data = {
                {"ensar1905@gmail.com", "Gs1905"},
                {"emre@gmail.com", "Test12345!"},
                {"hakans@gmail.com", "hakan86"},
                {"Feride@gmail.com", "Test123456!"}
        };

        return data;
    }


    @Test(dataProvider = "excelLOgin")
    public void test(String email, String password) {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();


        extentLogger = report.createTest(email + "'s Login Test");

        extentLogger.info("Click understand button");
        loginPage.understandBtn_Loc.click();

        //1. way
        extentLogger.info("Enter email and password");
        loginPage.login_Mtd(email, password);

        //2. way
//        extentLogger.info("Enter username");
//        loginPage.usernameInput_loc.sendKeys(email);
//
//        extentLogger.info("Enter password");
//        loginPage.passwordInput_loc.sendKeys(password);
//
//        extentLogger.info("Click login button");
//        loginPage.loginBtn_loc.click();

        extentLogger.pass("PASSED");
    }


}
