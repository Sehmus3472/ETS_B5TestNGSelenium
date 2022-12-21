package com.eurotech.test.day20_DDF;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] tvAndRating() {

        String[][] data = {
                {"Game Of Thrones", "9"},
                {"Dark", "9"},
                {"The Office", "9"},
                {"Super Baba", "8"},
                {"Prison Break", "7"},
                {"80'ler", "8"},
                {"Lost", "6"},
                {"La Casa De Papel", "5"}

        };

        return data;
    }

    // If we use this data how many times it will run-> 8 test
    // Bu datayı kullanırsak kaç defa çalışacağı-> 8 test
    @Test(dataProvider = "tvAndRating")
    public void testTvShow(String tvShow, String rating) {

        System.out.println("Tv show " + tvShow + " has rating " + rating);

    }
}
