package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonPage extends BasePage {

    @FindBy(xpath = "//*[@class='a-button-inner'][1]")
    public WebElement changeAdressBtn;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "searchDropdownBox")
    public WebElement katagoriList;

    @FindBy(className = "a-price-whole")
    public List<WebElement>tümFiyatlar;

    public void navigateAllMenu2(String tab,String module){
        Driver.get().findElement(By.xpath("(//*[.='All'])[2]")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//div[text()='"+tab+"']")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//a[text()='"+module+"']")).click();
    }



}
