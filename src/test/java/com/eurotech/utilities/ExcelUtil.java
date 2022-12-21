package com.eurotech.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is a utility for reading from writing to excel files. --> Bu, yazmadan excel dosyalarına okumak için bir yardımcı programdır.
 * it works with xls and xlsx files. --> xls ve xlsx dosyalarıyla çalışır
 */


public class ExcelUtil{

    private Sheet workSheet;
    private Workbook workBook;
    private String path;

    public ExcelUtil(String path, String sheetName) { //Excel Yardımcı Programı
        this.path = path;
        try {
            // Open the Excel file --> Excel dosyasını aç
            FileInputStream ExcelFile = new FileInputStream(path);
            // Access the required test data sheet --> Gerekli test veri sayfasına erişin
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);
            // check if sheet is null or not. null means  sheetname was wrong
            // sayfanın boş olup olmadığını kontrol edin. null, sayfa adının yanlış olduğu anlamına gelir
            Assert.assertNotNull(workSheet, "Sheet: \""+sheetName+"\" does not exist\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int rowNum, int colNum) {  // Hücre Verilerini al
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] getDataArray() { // Veri Dizisini al

        String[][] data = new String[rowCount()][columnCount()];

        for (int i = 0; i <rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;

    }

    //this method will return data table as 2d array --> bu yöntem veri tablosunu 2d dizisi olarak döndürür
    //so we need this format because of data provider. --> bu nedenle veri sağlayıcı nedeniyle bu formata ihtiyacımız var.
    public String[][] getDataArrayWithoutFirstRow() { // İlk Satır Olmadan Veri Dizisini Al

        String[][] data = new String[rowCount()-1][columnCount()];

        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i-1][j] = value;
            }
        }
        return data;

    }

    public List<Map<String, String>> getDataList() { //Veri Listesini al
        // get all columns --> tüm sütunları al
        List<String> columns = getColumnsNames();
        // this will be returned --> bu iade edilecek
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            // get each row  --> her satırı al
            Row row = workSheet.getRow(i);
            // create map of the row using the column and value --> sütunu ve değeri kullanarak satırın haritasını oluşturun
            // column map key, cell value --> map bvalue --> sütun harita anahtarı, hücre değeri --> harita değeri
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }

            data.add(rowMap);
        }

        return data;
    }

    public List<String> getColumnsNames() { // Sütun Adlarını al
        List<String> columns = new ArrayList<>();

        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public void setCellData(String value, int rowNum, int colNum) { // Hücre Verilerini ayarla
        Cell cell;
        Row row;

        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workBook.write(fileOut);

            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCellData(String value, String columnName, int row) { // Hücre Verilerini ayarla
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    public int columnCount() { // sütun Sayısı
        return workSheet.getRow(0).getLastCellNum();
    }

    public int rowCount() { // satır Sayısı
        return workSheet.getLastRowNum()+1;
    }



}
