package com.eurotech.test.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title"); // Bu method da karsilastirmak istedigimiz kodlari yazip kontrol etmemizi saglar

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test2(){

        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3(){
        String expected="curo";
        String actual="Eurotech";

       Assert.assertTrue(actual.startsWith(expected));
       Assert.assertTrue(actual.startsWith(expected),"verify that title starting Euro");

      //  Assert.assertFalse(actual.startsWith(expected));
    }

    @Test
    public void test4(){
        String email="eurotechgmail.com";

        //   if (email.contains("@")){
        //       System.out.println("Pass");
        //   }else {
        //      System.out.println("Fail");
        //   }

        Assert.assertTrue(email.contains("@")); // Testimizin dogru dönüp donmedigini almak icin yazilip karsilastirma yapar
                                                // Bir nevi if else methodu yerine gecer.
    }

     @Test
     public void test5(){
       // Assert.assertFalse(0<1,"verify that 0 is not greater than 1");
        // false => expected (assertion)
        // true => actual  (condition)
        // test result Failed

         Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
         // expected : false
         // actual:  false
         // test:  Pass
     }

     @Test
     public void test6(){
        Assert.assertNotEquals("two","two");
         // expected : false
         // actual : true
         // test : Failed // did not expect[two] but found [two] -->[iki] beklemiyordum ama [iki] buldu

         Assert.assertNotEquals("two","one");
         // expected : false   (expected -> Beklenen)
         // actual : false      ( actual-> Gercek)
         // test : Pass         (test -> test)


     }

    @BeforeMethod
    public void setup(){

        System.out.println("Open The Browser"); // Test basladiginda bir kez calisisr

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser");
    } // Test bitiminde bir kez calisir.


}
