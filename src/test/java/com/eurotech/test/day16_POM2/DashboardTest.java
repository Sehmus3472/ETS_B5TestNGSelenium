package com.eurotech.test.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest  extends TestBase {

      LoginPage loginPage=new LoginPage();
      DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void dashboardMenu() {

        /**
         * Class Task
         *
         * go to http://92.205.106.232/login -->http://92.205.106.232/login adresine gidin
         * login with teacher credentials -->  öğretmen kimlik bilgileriyle giriş yapın
         * Get the text of the dashboard and verify following menu __>Panonun metnini alın ve aşağıdaki menüyü doğrulayın
         *     Developers
         *     All Posts
         *     My Account
         */

        driver.get(ConfigurationReader.get("urlIP"));
        loginPage.loginAsTeacher_Mtd();

        String expectedText = "Welcome Teacher";

        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(), expectedText,
                "Verify that log in successfully");

        /*
        // 1.way
        for (WebElement menu : dashboardPage.menuList_loc ) { // her ücünü de ortak alabilmek icin.
            System.out.println("menu.getText() = " + menu.getText());
        }

         */

        /*
        // 2.way
        List<WebElement>dashbordMenu=dashboardPage.menuList_loc;
        for (WebElement menu : dashbordMenu) {
            System.out.println("menu.getText() = " + menu.getText());
        }

         */
    }
        @Test
        public void navigatemenu(){

            /**
             * Class Task
             *
             * go to http://92.205.106.232/login -->http://92.205.106.232/login adresine gidin
             * login with teacher credentials -->  öğretmen kimlik bilgileriyle giriş yapın
             * Navigate to All Posts menu and verify url is http://eurotech.study/posts
             * Tüm Gönderiler menüsüne gidin ve url'nin http://eurotech.study/posts olduğunu doğrulayın
             * Navigate to Developers menu and verify url is http://eurotech.study/profiles
             * Geliştiriciler menüsüne gidin ve url'nin http://eurotech.study/profiles olduğunu doğrulayın
             */

            driver.get(ConfigurationReader.get("urlIP"));
            loginPage.loginAsTeacher_Mtd();
            String expectedText="Welcome Teacher";
            Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                    "Verify that log in successfully");

            dashboardPage.allPosts_loc.click();
            Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/posts");

            dashboardPage.developers_loc.click();
            Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/profiles");

        }


         @Test
         public void navigate2() {

        driver.get(ConfigurationReader.get("urlIP"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");

        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/profiles");
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://92.205.106.232/posts");

    }

    }

