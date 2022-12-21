package com.eurotech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

        private static Properties properties;

        static {

            try {
                // what file to read --> hangi dosyayı okumalı
                String path = "configuration.properties";
                // read the file into java, finds the file using the string path
                //dosyayı java'ya oku, dosyayı dize yolunu kullanarak bulur
                FileInputStream input = new FileInputStream(path);
                // properties --> class that store properties in key / value format
                // özellikler --> özellikleri anahtar/değer biçiminde saklayan sınıf
                properties = new Properties();
                // the values from the file input is loaded / fed in to the properties object
                // dosya girişindeki değerler, özellikler nesnesine yüklenir/beslenir
                properties.load(input);

                input.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        public static String get(String keyName){
            return properties.getProperty(keyName);
        }



    }

