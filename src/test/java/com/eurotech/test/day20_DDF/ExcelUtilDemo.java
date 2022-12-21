package com.eurotech.test.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile() {

        // Create an object from excel utils -->Excel yardımcı programlarından bir nesne oluşturun
        // it accepts zwo arguments --> zwo argümanlarını kabul eder
        // Argument 1 : Location of the file (path) --> Bağımsız Değişken 1: Dosyanın konumu (yol)
        // Argument 2 : sheet that we want to open (sheetName) --> Argüman 2 : açmak istediğimiz sayfa (sayfaAdı)

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTestB5.xls",
                "Test Data");

        //How many rows in the sheet -->Sayfada kaç satır var?
        System.out.println("testData.rowCount() = " + testData.rowCount());
        //How many columns in the sheet --> Sayfada kaç sütun var?
        System.out.println("testData.columnCount() = " + testData.columnCount());
        //get all columns names -->tüm sütun adlarını al
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());
        //get all data in list of String -->String listesindeki tüm verileri al
        List<Map<String, String>> dataList = testData.getDataList();
        //iter
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }
        //How can I get third row (hakan)  --> Üçüncü sırayı nasıl alabilirim (hakan
        System.out.println("dataList.get(2) = " + dataList.get(2));
        //get Aycan's company --> Aycan'ın şirketini al
        System.out.println("dataList.get(6).get(\"Company\") = " + dataList.get(6).get("Company"));
        //get gigi's title -->gigi'nin unvanını al
        System.out.println("dataList.get(3).get(\"Title\") = " + dataList.get(3).get("Title"));

        //get array -->dizi al
        String[][] dataArray = testData.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));

    }
}
