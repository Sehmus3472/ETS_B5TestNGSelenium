package com.eurotech.test.day19_review;

import com.eurotech.pages.ToolsQALOginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    ToolsQALOginPage toolsQALOginPage = new ToolsQALOginPage();

    @Test
    public void newUserCreate() {


        /**
         * Test1
         * Create new user
         *
         * Test2
         * Login as a new user --> Yeni bir kullanıcı olarak giriş yapın
         * verify that login is successful --> girişin başarılı olduğunu doğrulayın
         * click on Go To Book Store --> Kitapçıya Git'e tıklayın
         * Verify that went book store --> Kitapçıya gittiğini doğrulayın
         * Search 'Addy Osmani' in search button --> Arama düğmesinde 'Addy Osmani'yi arayın
         */


        extentLogger = report.createTest("User crate info verification");

        extentLogger.info("click on vew User button");
        toolsQALOginPage.newUserBtn.click();

        extentLogger.info("Enter first name");
        toolsQALOginPage.firstNameInput.sendKeys("Euro");

        extentLogger.info("Enter last name");
        toolsQALOginPage.lastNameInput.sendKeys("tech");

        extentLogger.info("Enter UserName");
        toolsQALOginPage.userNameInput.sendKeys("Eurotech");

        extentLogger.info("Enter password");
        toolsQALOginPage.passwordInput.sendKeys("Eurotech12!");

       // extentLogger.info("click on the I'm not robot");
        //'CAPTCHA's cannot be located  -->CAPTCHA'lar bulunamıyor hata veriyor
        //toolsQALOginPage.ImNotRobotBtn.click();

        extentLogger.info("click on the register");
        BrowserUtils.clickWithJS(toolsQALOginPage.registerBtn);

        //toolsQALOginPage.registerBtn.click();

    }

    @Test
    public void loginInfo() {

        extentLogger = report.createTest("user info verification");

        extentLogger.info("Enter User Name");
        toolsQALOginPage.userNameInput.sendKeys(ConfigurationReader.get("userToolsQA"));

        extentLogger.info("Enter password ");
        toolsQALOginPage.passwordLoginInput.sendKeys(ConfigurationReader.get("passwordTollsQA"));

        extentLogger.info("click on the login button");
        toolsQALOginPage.loginBtn.click();


        //1.way
        extentLogger.info("verify that login is successful");
        String expectedUrl = "https://demoqa.com/profile";
        BrowserUtils.waitFor(2);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        //2.way
        String expectedVerifyMessage = "Eurotech";
        extentLogger.info("verify that login is successful in Profile " + expectedVerifyMessage);
        String actualVerifyUser = toolsQALOginPage.verifyUserName.getText();
        Assert.assertEquals(actualVerifyUser, expectedVerifyMessage);

        extentLogger.info("click on the Go To Store button");
        actions.moveToElement(toolsQALOginPage.goToStoreBtn).click(); // Sayfayi asagi dogru kaydirir.
        //BrowserUtils.clickWithJS(toolsQALOginPage.goToStoreBtn); // Sayfayi tiklamak icin
        // toolsQALOginPage.goToStoreBtn.click();

        extentLogger.info("Enter search button 'Addy Osmani' ");
        toolsQALOginPage.typeTosearchBtn.sendKeys("Addy Osmani");

        extentLogger.info("PASSS");


    }
}
