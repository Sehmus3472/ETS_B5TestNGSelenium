package com.eurotech.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver; // protected demek ayni paced icinde olacak yada inheritens yapilarak kullanimdir.
    protected Actions actions; // action elementleri eklemek icin

    protected WebDriverWait wait; // bekleme zamani eklemek icin

    //this class is used for starting and building reports -->bu sınıf, raporları başlatmak ve oluşturmak için kullanılır
    protected ExtentReports report;

    //this class is used to create HTML report file --> bu sınıf, HTML rapor dosyası oluşturmak için kullanılır
    protected ExtentHtmlReporter htmlReporter;

    // this will define a test , enable adding logs,authors and test steps
    // bu sınıf, HTML raporu oluşturmak için kullanılır
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //initialize the class --> sınıfı başlat
        report=new ExtentReports();

        //create a report path --> how can we find our project dynamicly
        //bir rapor yolu oluştur --> projemizi dinamik olarak nasıl bulabiliriz

        String projectPath=System.getProperty("user.dir");
        String path=projectPath + "/test-output/report.html";

        //initialize the html report with the report path --> html raporunu rapor yolu ile başlat
        htmlReporter=new ExtentHtmlReporter(path);

        //attach the html report to the report object --> html raporunu rapor nesnesine ekleyin
        report.attachReporter(htmlReporter);

        //title in report -->rapordaki başlık
        htmlReporter.config().setReportName("EuroTech Smoke Test");

        //set environment information -->ortam bilgilerini ayarla
        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Fatih");
    }

    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created -->bu, raporun gerçekten oluşturulduğu zamandır
        report.flush();
    }

  @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize(); // Sa<yfayi bututrur tiklamaya yardimci olur.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions=new Actions(driver); // aksiyon elementleri ekledim
        wait=new WebDriverWait(Driver.get(),15); // bekleme zamani ekledim

       // driver.get(ConfigurationReader.get("urlToolsQA"));  //Yapılandırma Okuyucu
        driver.get(ConfigurationReader.get("url3"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
/*
            // If test failes --> Test başarısız olursa
        if(result.getStatus()==ITestResult.FAILURE){
            // Record the name of failed test --> Başarısız testin adını kaydedin
            extentLogger.fail(result.getName());
            // Take the screenshot and return the location of screenshot
            // Ekran görüntüsünü alın ve ekran görüntüsünün konumunu döndürün
            String screenShotpath= BrowserUtils.getScreenshot(result.getName());
            // Add the screenshot to the report --> Ekran görüntüsünü rapora ekleyin
            extentLogger.addScreenCaptureFromPath(screenShotpath);
            // capture the exception and put inside the report
            // istisnayı yakalayın ve raporun içine koyun
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        driver.close();

 */
        // If test failes
        if (result.getStatus()==ITestResult.FAILURE){

            //Record the name of failed test --> Başarısız testin adını kaydedin
            extentLogger.fail(result.getName());
            //Take the screenshot  and return the location of screenshot
            // Ekran görüntüsünü alın ve ekran görüntüsünün konumunu döndürün
            String screenShotpath= BrowserUtils.getScreenshot(result.getName());
            //Add the screenshot to the report --> Ekran görüntüsünü rapora ekleyin
            extentLogger.addScreenCaptureFromPath(screenShotpath);
            //capture the exception and put inside the report
            // istisnayı yakalayın ve raporun içine koyun
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(2000);
        // driver.close();
        // Driver.closeDriver();
    }
}
