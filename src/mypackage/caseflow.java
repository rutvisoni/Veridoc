package mypackage;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class caseflow {


	String expectedurl="https://veridocglobal.com/CustomerTemplate/SelectTemplate";

	String filepathinvalid="/home/rutvi/Pictures/download.jpg";
	String filepathinvalid1="/home/rutvi/Music/Shree_Hanuman_Chalisa-Hariharan[www.Mp3MaD.Com].mp3";
	String filepathinvalid2="/home/rutvi/Downloads/Standards.docx";
	//String filepathinvalid3="/home/rutvi/Downloads/documentScanner_1.0.23.apk";
	String filepath1="/home/rutvi/Downloads/test.pdf";
	
	
	String result="Document is Added.";	
	String exppath="https://veridocglobal.com/errorpage.htm?aspxerrorpath=/Caseflow/Create";
	
	HSSFWorkbook workbook1;
	
	 HSSFSheet sheet;
	 Map < String, Object[] > caseflowinfo = new TreeMap < String, Object[] >();
	
	 masterclass m1=new masterclass();
	
	WebDriver dri=null;
	 
	@BeforeClass
	public  void setup()
	{	
		try {
			dri=masterclass.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook1 = new HSSFWorkbook();
		
		sheet=workbook1.createSheet("CaseFlow");  
	    caseflowinfo.put( "1", new Object[] { "No", "Details of the upload file","Pass/Fail" });
	
	
	}
	
	
	@Test
	public void selecttemplate() throws InterruptedException
	{
		
	
		m1.selecttemplate("Caseflow");
		
		
	
				
	}
	
	@DataProvider(name = "Authentication2")
	  public static Object[][] credentials2() {
	 
	        return new Object[][] { {"3","/home/rutvi/Pictures/download.jpg"},{"4","/home/rutvi/Downloads/Standards.docx"},{"5","/home/rutvi/Music/Shree_Hanuman_Chalisa-Hariharan[www.Mp3MaD.Com].mp3"}};
	        
	  }
	@Test(dataProvider = "Authentication2",priority=2)
	
	public void Wrongdata(String id,String p1) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		 List<String> invaliddataList = Arrays.asList(filepathinvalid,filepathinvalid2);
		
		
		WebElement choosefile=m1.getDriver().findElement(By.name("files"));
		 //int size=invaliddataList.size();
		 choosefile.sendKeys(p1);
			 
			 WebElement upload=m1.getDriver().findElement(By.id("register-button"));
			 upload.submit();
			 Thread.sleep(1000);
			 
			 String url=m1.getDriver().getCurrentUrl();
			 System.out.println(url);
			 if(url.equals(exppath))
				{
					
					if(url.equals(exppath))
					{
						caseflowinfo.put(id, new Object[] {id,p1,"Display Error"});
						Assert.assertFalse(false);
						m1.getDriver().navigate().back();
						
					}		
				}	
			 	
			 	WebElement dialog=m1.getDriver().findElement(By.id("dialog-notifications-error"));
				String errforinvaliddata=dialog.getText();
				

				System.out.println("err for invalid data->"+errforinvaliddata);
				
				String msg="Only pdf files are allowed.";
				
				if(msg.equals(errforinvaliddata))
				{
				
					caseflowinfo.put(id, new Object[] {id,p1,"Testcases pass"});
					Assert.assertFalse(true);
					m1.getDriver().navigate().back();
					
				}
					

	}
	

	@DataProvider(name = "Authentication3")
	  public static Object[][] credentials3() {
	 
	        return new Object[][] { {"6","/home/rutvi/Downloads/test.pdf"}};
	        
	  }
	@Test(dataProvider = "Authentication3",priority=3)
	public void validdata(String id,String p1) {
		// TODO Auto-generated method stub
		
		
		WebElement choosefile=m1.getDriver().findElement(By.name("files"));
		choosefile.sendKeys(p1);
		

		WebElement upload=m1.getDriver().findElement(By.id("register-button"));
		upload.submit();
		

		WebElement dialog=m1.getDriver().findElement(By.className("ui-dialog-title"));
		String success=dialog.getText();
		
		System.out.println("success msg->"+success);
		
		String msg="Document is added.";
		
		if(success.equals(msg))
		{
			
			assertEquals(msg, success);
			caseflowinfo.put( id, new Object[] { id,p1,"pass"});
			
		}
			
	}
	@Test(priority=1)
	public void blankupload() {
		// TODO Auto-generated method stub
		
		
		WebElement upload=m1.getDriver().findElement(By.id("register-button"));
		upload.submit();
		
		
		WebElement dialog=m1.getDriver().findElement(By.id("dialog-notifications-error"));
		String err=dialog.getText();
		
		System.out.println("err->"+err);
			
		String expectedstr="Please select file";
		
		if(err.equals(expectedstr))
		{
			caseflowinfo.put( "2", new Object[] { "2"," ","Testcases Pass" });
			Assert.assertFalse(true);
			m1.getDriver().navigate().back();	
		}
		else
		{
			caseflowinfo.put( "2", new Object[] { "2"," ","Testcases Fail" });
			Assert.assertFalse(false);
			m1.getDriver().navigate().back();
		
		}
	}
	@AfterClass
	public void afterclassmethod() throws IOException
	{
		
		/*Set < String > keyid = caseflowinfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	         HSSFRow row = sheet.createRow(rowid++);
	         Object [] objectArr = caseflowinfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      FileOutputStream out = new FileOutputStream(new File("/home/rutvi/Music/caseflow.xlsx"));
	      	
	     
	      workbook1.write(out);
	      out.close();
	      System.out.println("xlsx written successfully");
		*/
		
		m1.getDriver().get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
		
		
	}
	
}