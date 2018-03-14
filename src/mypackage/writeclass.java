package mypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class writeclass {
	
	@BeforeSuite
	public static void startSetUp()
	{
	System.out.println("Execution is started..");
	}

	@SuppressWarnings("resource")
	@AfterSuite
	public static void endExecution()
	{
	try
	{
	System.out.println("Execution is Ended..");
	File loginFile = new File("/home/sevenbits/Music/login.xls");
	File docfile = new File("/home/sevenbits/Music/register.xls");
	FileInputStream out1 = null;
	FileInputStream out2 = null;

	if (loginFile.exists())
	{
	out1 = new FileInputStream(loginFile.getAbsolutePath());
	}

	if (docfile.exists())
	{
	out2 = new FileInputStream(docfile.getAbsolutePath());
	}

	List<InputStream> strFile = new ArrayList<InputStream>();
	if (out1 != null)
	{
	strFile.add(out1);
	}
	if (out2 != null)
	{
	strFile.add(out2);
	}

	File finalOutputfile = new File("/home/sevenbits/Music/results.xls");
	if (finalOutputfile.exists())
	{
	finalOutputfile.delete();
	finalOutputfile.createNewFile();
	}

	Workbook book = new HSSFWorkbook();

	book = copysheet.mergeExcelFiles(book, strFile);
	FileOutputStream out = new FileOutputStream(finalOutputfile, true);
	book.write(out);
	out.close();
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}

	}
	 

