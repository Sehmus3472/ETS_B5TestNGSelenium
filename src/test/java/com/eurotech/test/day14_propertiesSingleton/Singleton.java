package com.eurotech.test.day14_propertiesSingleton;

public class Singleton {

    // singleton class will have  private constructor  --> singleton sınıfının özel kurucusu olacak
    // it means other classes can NOT create an object of this class
    // bu, diğer sınıfların bu sınıfın bir nesnesini yaratamayacağı anlamına gelir.

    private Singleton(){

    }

    private static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str is null,assigning a value to it");
            str="some value";
        }else {
            System.out.println("it has value,just returning it");
        }

        return str;
    }
}
