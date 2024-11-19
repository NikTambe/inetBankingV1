package com.inetbanking.utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ss;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String Xlfile, String Xlsheet) throws Exception {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ss = wb.getSheet(Xlsheet);
		int rowcount = ss.getLastRowNum();
		wb.close();
		fi.close();

		return rowcount;

	}

	public static int getCellCount(String Xlfile, String Xlsheet, int rownum) throws Exception {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ss = wb.getSheet(Xlsheet);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();

		return cellcount;

	}

	public static String getCellData(String Xlfile, String Xlsheet, int rownum, int colnum) throws Exception {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ss = wb.getSheet(Xlsheet);
		row = ss.getRow(rownum);
		cell = row.getCell(colnum);
		String data;

		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;

		} catch (Exception e) {

			data = "";
		}

		wb.close();
		fi.close();
		return data;

	}

	public static void setCellData(String Xlfile, String Xlsheet, int rownum, int colnum, String data)
			throws Exception {

		fi = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fi);
		ss = wb.getSheet(Xlsheet);
		row = ss.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fo = new FileOutputStream(Xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
