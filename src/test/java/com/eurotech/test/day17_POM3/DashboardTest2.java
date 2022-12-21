package com.eurotech.test.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();


    @Test
    public void verifyList(){
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText= "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),
                            expectedText,"Verify that log in successfully");

        List<String>expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        List<String>actualList = new ArrayList<>();

        for (WebElement menu : dashboardPage.menuList_loc) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }

        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);

        Assert.assertEquals(actualList,expectedList,"Verify that lists are matched" +
                "");
    }

    @Test
    public void listVerify2(){

    // Verify with BrowserUtils --> Tarayıcı Yardımcı Programları ile Doğrulayın
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText= "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),
                expectedText,"Verify that log in successfully");

        List<String>expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        // 1 way
        // Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList_loc),expectedList);

        //2 way
        List<String> actualList= BrowserUtils.getElementsText(dashboardPage.menuList_loc);

        Assert.assertEquals(actualList,expectedList);

    }

    @Test
    public void navigateSubMenu(){

        /** Class Task
         *  go to http://eurotech.study/login
         *  Login with teacher credentials --> Öğretmen kimlik bilgileriyle giriş yapın
         *  Navigate to My Post and verify that submit button is visible then
         *  Gönderimime gidin ve gönder düğmesinin görünür olduğunu doğrulayın, ardından
         *  Navigate to log out and verify that log out successfully
         *  Oturumu kapatmak için gezinin ve oturumu başarıyla kapattığınızı doğrulayın
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),
                expectedText,"Verify that log in successfully");


        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubMenu("My Posts");

        Assert.assertTrue(dashboardPage.submitBtn_loc.isDisplayed(),
                "Verify that submit button is displayed  ");

        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubMenu("Logout");

        Assert.assertTrue(loginPage.loginBtn_loc.isDisplayed(),
                "Verify that login button is displayed");

    }

}
