package com.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    //this class is used for starting and building reports -->bu sınıf, raporları başlatmak ve oluşturmak için kullanılır
    ExtentReports report;

    //this class is used to create HTML report file --> bu sınıf, HTML rapor dosyası oluşturmak için kullanılır
    ExtentHtmlReporter htmlReporter;

    // this will define a test , enable adding logs,authors and test steps
    // bu sınıf, HTML raporu oluşturmak için kullanılır
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {

        //initialize the class --> sınıfı başlat
        report = new ExtentReports();

        //create a report path --> how can we find our project dynamicly
        //bir rapor yolu oluştur --> projemizi dinamik olarak nasıl bulabiliriz

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html report with the report path --> html raporunu rapor yolu ile başlat
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object --> html raporunu rapor nesnesine ekleyin
        report.attachReporter(htmlReporter);

        //title in report -->rapordaki başlık
        htmlReporter.config().setReportName("EuroTech Smoke Test");

        //set environment information -->ortam bilgilerini ayarla
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Fatih");


    }

    @Test
    public void test1() {

        //give a name to the current test mevcut teste bir isim verin
        extentLogger = report.createTest("TC01 Login Test");

        // Test steps -->Test adımları
        extentLogger.info("Open the browser");

        extentLogger.info("go to url http://eurotech.study/login");

        extentLogger.info("Login as Teacher");

        extentLogger.info("Enter teacher username");

        extentLogger.info("Enter teacher password");

        extentLogger.info("click login button");

        extentLogger.info("Verify logged in");

        extentLogger.info("TC01 Login Test is passed");

    }

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created -->bu, raporun gerçekten oluşturulduğu zamandır
        report.flush();

    }

}
