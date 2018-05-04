// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ImportExcelUtil.java

package com.student_assessment.util;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcelUtil
{

	private static final String excel2003L = ".xls";
	private static final String excel2007U = ".xlsx";

	public ImportExcelUtil()
	{
	}

	public List getBankListByExcel(InputStream in, String fileName)
		throws Exception
	{
		List list = null;
		Workbook work = getWorkbook(in, fileName);
		if (work == null)
			throw new Exception("创建Excel工作薄为空！");
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		list = new ArrayList();
		for (int i = 0; i < work.getNumberOfSheets(); i++)
		{
			sheet = work.getSheetAt(i);
			if (sheet != null)
			{
				for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++)
				{
					row = sheet.getRow(j);
					if (row != null && row.getFirstCellNum() != j)
					{
						List li = new ArrayList();
						for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++)
						{
							cell = row.getCell(y);
							li.add(getCellValue(cell));
						}

						list.add(li);
					}
				}

			}
		}

		work.close();
		return list;
	}

	public Workbook getWorkbook(InputStream inStr, String fileName)
		throws Exception
	{
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (".xls".equals(fileType))
			wb = new HSSFWorkbook(inStr);
		else
		if (".xlsx".equals(fileType))
			wb = new XSSFWorkbook(inStr);
		else
			throw new Exception("解析的文件格式有误！");
		return wb;
	}

	public Object getCellValue(Cell cell)
	{
		Object value = null;
		DecimalFormat df = new DecimalFormat("0");
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		DecimalFormat df2 = new DecimalFormat("0.00");
		switch (cell.getCellType())
		{
		case 2: // '\002'
		default:
			break;

		case 1: // '\001'
			value = cell.getRichStringCellValue().getString();
			break;

		case 0: // '\0'
			if ("General".equals(cell.getCellStyle().getDataFormatString()))
			{
				value = df.format(cell.getNumericCellValue());
				break;
			}
			if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString()))
				value = sdf.format(cell.getDateCellValue());
			else
				value = df2.format(cell.getNumericCellValue());
			break;

		case 4: // '\004'
			value = Boolean.valueOf(cell.getBooleanCellValue());
			break;

		case 3: // '\003'
			value = "";
			break;
		}
		return value;
	}
}
