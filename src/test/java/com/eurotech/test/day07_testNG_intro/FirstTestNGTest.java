package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.Test;

public class FirstTestNGTest {
    // This is an annotations,it means the method after this @Test is TestNG method

    @Test
    public void Test1(){

        System.out.println("open the browser");
        System.out.println("First Test Case");
        System.out.println("closing Browser" );

    }

    @Test
    public void test2(){

        System.out.println("Test Case 2");

    }



}
