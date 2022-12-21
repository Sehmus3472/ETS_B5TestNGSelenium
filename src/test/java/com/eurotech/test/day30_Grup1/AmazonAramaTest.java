package com.eurotech.test.day30_Grup1;

import com.eurotech.pages.AmazonPage;
import com.eurotech.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBase {
    AmazonPage page= new AmazonPage();

    @Test
    public void AmazonSearch() {
        page.changeAdressBtn.click();

        Select select = new Select(page.katagoriList);
        select.selectByVisibleText("Automotive");
        page.searchBox.sendKeys("car phone holder" + Keys.ENTER );

        try { // Bir hata var ise hatayi gecip testimizi okumaya devam etmesi icin yapiyoruz.
            for (WebElement e :page.tümFiyatlar ) {
                WebElement fiyat=e.findElement(By.className("a-price-whole"));
                System.out.println("fiyat.getText() = " + fiyat.getText());
            }

        }catch (Exception e){

        }


    }
    @Test
    public void allTabTest(){
        page.changeAdressBtn.click();
        page.navigateAllMenu2("Amazon Music","Podcasts");

        WebElement actualMessage = driver.findElement(By.xpath("(//div/span[@class='macro'])[1]"));
        Assert.assertEquals(actualMessage.getText(),"Want access to top ad-free podcasts and 100 million songs? Try Amazon Music Unlimited");

    }
}
