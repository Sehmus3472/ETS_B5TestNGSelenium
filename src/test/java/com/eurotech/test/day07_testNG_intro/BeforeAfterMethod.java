package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }

    @Test
    public void test1(){

        System.out.println("First Test Case");

    }
    //run once before each method @Test
    @BeforeMethod //// Bu methodta sürekli yazmamiz gereken kodlari tek kod altinda yazip sürekli tekrardan yazmamamizi saglar.
    public void setup(){

        System.out.println("Opening The Browser");

    }
    //run once after each method @Test Annotations
    @AfterMethod //// bu method acik olan sayfalari kapatmamizi saglar.
    public void tearDown(){

        System.out.println("Closing Browser");

    }
    @Test
    public void test2(){

        System.out.println("Test Case 2");
    }

    @BeforeClass
    public void SetupClass(){
        System.out.println("------BEFORE CLASSS-----");
        System.out.println("her class da bir defa calısır");

    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----AFTER CLASS-----");

    }

    @Test // @Ignore  Bunu test satirinin önüne yazarsak testimizi calistirmaz. Yada // komend yazarak.
    public void test4(){

        System.out.println("İgnore");
    }

}
