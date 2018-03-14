package mypackage;




import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class documents{

	WebDriver dri=null;
	
	String expectedurl="https://veridocglobal.com/CustomerTemplate/SelectTemplate";

	static String filepathinvalid="/home/sevenbits/Downloads/index.jpeg";
	String filepathinvalid1="/home/sevenbits/Music/Hanuman Chalisa By M.S.Subbulakshmi.mp3";
	static String filepathinvalid2="/home/sevenbits/Downloads/test.doc";
	String filepathinvalid3="/home/sevenbits/Music/kranti_2.11.apk";
	String filepath1="/home/sevenbits/Downloads/Test.pdf";
	
	
	String result="Document is Added.";	
	
	HSSFWorkbook workbook1;
	
	 HSSFSheet sheet;
	 Map < String, Object[] > uploadinfo = 
		      new TreeMap < String, Object[] >();
	
	
	masterclass m1=new masterclass();
	
	
	@BeforeClass
	public  void setup()
	{	

		try {
			dri=masterclass.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		workbook1 = new HSSFWorkbook();
		
		
		
		 sheet=workbook1.createSheet("Documents");
	      
	    uploadinfo.put( "1", new Object[] { "No", "Details of the upload file","Pass/Fail" });
	
	}
	/*@Test
	public void login() 
	{
		m1.login();
	}
	*/
	
	@Test
	public void selecttemplate() throws InterruptedException
	{
		m1.selecttemplate("Documents");
				
	}
	
	@DataProvider(name = "Authentication2")
	  public static Object[][] credentials2() {
	 
	        return new Object[][] { {"3","/home/sevenbits/Downloads/index.jpeg"},{"4","/home/sevenbits/Downloads/test.doc"},{"5","/home/sevenbits/Music/Hanuman Chalisa By M.S.Subbulakshmi.mp3"},{"6","/home/sevenbits/Music/kranti_2.11.apk"}};
	        
	  }
	@Test(dataProvider = "Authentication2",priority=2)
	
	public void Wrongdata(String id,String p1) throws InterruptedException {
		 
		Thread.sleep(2000);
		
		WebElement choosefile=m1.getDriver().findElement(By.name("files"));
		
		choosefile.sendKeys(p1);
		
		
		
			 WebElement upload=m1.getDriver().findElement(By.id("register-button"));
			 upload.submit();
			 
			 String url=m1.getDriver().getCurrentUrl();
				
				System.out.println("errorurl->"+url);
				String exppath="https://veridocglobal.com/errorpage.htm?aspxerrorpath=/Document/Create";
				
				if(url.equals(exppath))
				{
					uploadinfo.put(id, new Object[] {id,p1,"Display Error"});
					Assert.assertFalse(false);						
					m1.getDriver().navigate().back();
					
				}	
				
			 	WebElement dialog=m1.getDriver().findElement(By.id("dialog-notifications-error"));
				String errforinvaliddata=dialog.getText();
				

				System.out.println("err for invalid data->"+errforinvaliddata);
				
				String msg="Only pdf files are allowed.";
										
				
				if(msg.equals(errforinvaliddata))
				{
					
					uploadinfo.put(id, new Object[] {id,p1,"Testcases pass" });
					Assert.assertFalse(true);
			
					m1.getDriver().navigate().back();
					
				}
	}
	
	@DataProvider(name = "Authentication3")
	  public static Object[][] credentials3() {
	 
	        return new Object[][] { {"6","/home/sevenbits/Downloads/Test.pdf"}};
	        
	  }
	@Test(dataProvider = "Authentication3",priority=3)
	public void validdata(String id,String p1) {
		// TODO Auto-generated method stub
		
		
		WebElement choosefile=m1.getDriver().findElement(By.name("files"));
		choosefile.sendKeys(p1);
		

		WebElement upload=m1.getDriver().findElement(By.id("register-button"));
		upload.submit();
		

		WebElement dialog=m1.getDriver().findElement(By.id("dialog-notifications-success"));
		String success=dialog.getText();
		
		System.out.println("success msg->"+success);
		
		String msg="Document is Added.";
		

		if(success.equals(msg))
		{
			
			Assert.assertTrue(true);
			uploadinfo.put( id, new Object[] { id,p1,"pass"});
																																																																																																																
		}
				
	}
	
	@Test(priority=1)
	public void blankupload() throws InterruptedException {
		
		WebElement upload=m1.getDriver().findElement(By.id("register-button"));
		upload.submit();
		
		
		WebElement dialog=m1.getDriver().findElement(By.id("dialog-notifications-error"));
		String err=dialog.getText();
		
		System.out.println("err->"+err);
			
		String expectedstr="Please select file";
		

		if(err.equals(expectedstr))
		{
			uploadinfo.put( "2", new Object[] { "2"," ","Testcases Pass" });
			Assert.assertFalse(true);
			m1.getDriver().navigate().back();	
		}
		else
		{
			Assert.assertFalse(false);
			uploadinfo.put( "2", new Object[] { "2"," ","Testcases fail" });
			m1.getDriver().navigate().back();
		
		}
	}
	@AfterClass
	public void afterclassmethod() throws IOException
	{
		
		Set < String > keyid = uploadinfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	         HSSFRow row = sheet.createRow(rowid++);
	         Object [] objectArr = uploadinfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      FileOutputStream out = new FileOutputStream(new File("/home/sevenbits/Music/documents.xls"));
	      	
	     
	      workbook1.write(out);
	      out.close();
	      System.out.println("xlsx written successfully");
	      
	      m1.getDriver().get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
		
		
	}
}
						
						
	
	

