package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{



    @FindBy(id = "loginpage-input-email")  //Loc=kisaca Locater demek.
    public WebElement usernameInput_loc;

    @FindBy(name = "password")
    public WebElement passwordInput_loc;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn_loc;

    @FindBy(xpath = "//*[.='Invalid Credentials!']")
    public WebElement warningMessage_loc;

    @FindBy(css=".menu-list")
    public List<WebElement> menuList_Loc;





    public void login_Mtd(String username,String password){ // Mtd = Methodun kisaca yazilmasi demek.

        usernameInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        loginBtn_loc.click();
    }

    public void loginAsTeacher_Mtd(){
        String username=ConfigurationReader.get("usernameTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        usernameInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        understandBtn_Loc.click();
        loginBtn_loc.click();
    }

    public void loginAsStudent_Mtd(){
       usernameInput_loc.sendKeys(ConfigurationReader.get("usernameStudent"));
       passwordInput_loc.sendKeys(ConfigurationReader.get("passwordStudent"));
       loginBtn_loc.click();

    }





/*
* These are change with devEx web site -->Bunlar devEx web sitesi ile değişiklik yapildi.
* */

    @FindBy(id = "user-name")
    public WebElement usernameInput; //Locat ettigiz sayfalardaki locaterleri tanimlamamizi buraya aktarmamizi saglar.
    // Seleniyumdan gelir.
    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id= "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//form/div[3]/h3")
    public WebElement errorMessage;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understed;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsText;

    @FindBy(xpath = "//form/div[3]/h3") // Hepsi icin ortak kullanmak icin
    public List<WebElement>listElements;  // bIrden fazla elementi kullanmak icin List element loketrini kullaniyoruz.

    @FindAll({  // yazilan kodu gezip secenekler arasinda dogru olani bulup kullanmasi icin yapilan bir yöntemdir.
                // Veya mantigi var.
            @FindBy( id ="user-name"),
            @FindBy(name = "user-name")
    })
    public WebElement getUsernameInput;

    @FindBys({ // burda selenium arayip her iki kolektiri de bulmasi icin kullaniyoruz. Burda Ve mantigi var.ikisinide bul diyoruz.
            @FindBy(xpath = "//input[@type='text']"),
            @FindBy(id ="password")
    })
    public WebElement getPasswordInput;



    public void login(){
        usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginBtn.click();
    }

    public void loginAsPerform(){
        String username= ConfigurationReader.get("userPerform");
        String password= ConfigurationReader.get("passwordswag");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsProblem(){
        String username=ConfigurationReader.get("userProblem");
        String password=ConfigurationReader.get("passwordswag");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    /*
    * These are change with devEx websitesi -->Bunlar devEx web sitesi ile değişiklik (Yukaridaki ve asagidaki yildizli ara degisti.)
    * */





}
