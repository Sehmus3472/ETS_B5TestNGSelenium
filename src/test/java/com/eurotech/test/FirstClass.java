package com.eurotech.test;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {

        Faker faker = new Faker();
        System.out.println("faker.animal().name() = " + faker.animal().name());  // Herhangi bir hayvan isim kullanmak istedigimizde yapabiliriz.

        System.out.println("faker.name().fullName() = " + faker.name().fullName()); // Herhangi bir isim kullanmak istedigimizde yapabiliriz.

        // Herhangi bir gameOfThrones krakterlerinden birini kullanabiliriz.
        System.out.println("faker.gameOfThrones().character() = " + faker.gameOfThrones().character());

        // Credi karti ile ilgili bir islemde istersek kullanabiliriz.
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());


        for (int i = 0; i <100 ; i++) {  // Yüz tane isism yazmak istedigimizde bu for döngüsünü kullanabiliriz.
            System.out.println("faker.address().cityName() = " + faker.address().cityName());

        }
    }

}
