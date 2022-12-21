package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public abstract class BasePage {
    // Her sayfada bulunan mooduller ve tablar icin olustururlmus tasklardir. Bunlar her sayfada oluyor.Isim olarak Basepage diyoruz.
    // burda en önemli özelligi kodlari abstrakclass olarak olusturacaz.
    // abstrak classin en önemli özelligi inherintes icin kullanacaz ve burdan bir objeckt cread edemiyoruz.

    public BasePage() {
        PageFactory.initElements(Driver.get(),this); // bu method olusturulan web elementleri okuyabilmemizi saglar.
    }

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn_Loc;
}
