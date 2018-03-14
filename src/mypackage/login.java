package mypackage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class login {

	WebDriver dri=null;
	
	String expectedurl="https://veridocglobal.com.au/CustomerTemplate/SelectTemplate";

	
	 HSSFWorkbook workbook1;
	
	 HSSFSheet sheet;
	 Map < String, Object[] > logininfo = 
		      new TreeMap < String, Object[] >();
		     
		    //  HSSFRow row;	      
	  masterclass m1=new masterclass();
	
	
	
	@BeforeClass
	public  void beforelogin() throws InterruptedException
	{
		
/*
		try {
			dri=masterclass.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		m1.setup();
		
		m1.getDriver().get("https://veridocglobal.com/login");
		workbook1 = new HSSFWorkbook();
		
		
		
		 sheet=workbook1.createSheet("Login");
	      
	    logininfo.put( "1", new Object[] { "No", "Email ID", "Password","Pass/Fail" });
	}
	
	@DataProvider(name = "Authentication")
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { " ", " " }};
	        
	  }
	@Test(dataProvider = "Authentication")
	public void emptydata(String emailid,String pass)
	{
		
		m1.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement loginlink=m1.getDriver().findElement(By.linkText("Login"));
		JavascriptExecutor executor = (JavascriptExecutor)m1.getDriver();
		executor.executeScript("arguments[0].click()", loginlink);
		
		m1.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement email=m1.getDriver().findElement(By.name("Email"));
		email.clear();
		email.sendKeys(emailid);
		
		WebElement password=m1.getDriver().findElement(By.name("Password"));
		password.clear();
		password.sendKeys(pass);
		
		WebElement loginbtn=m1.getDriver().findElement(By.className("login-button"));
		loginbtn.submit();
		
		String currenturl=m1.getDriver().getCurrentUrl();
		
		if(currenturl.equals(expectedurl))
		{
			Assert.assertFalse(false);
			logininfo.put( "2", new Object[] { "1", emailid, pass,"pass" });
		}
		else
		{
			logininfo.put( "2", new Object[] { "1", emailid, pass,"fail" });
			Assert.assertFalse(true);
		}
		
		
	}

	@DataProvider(name = "Authentication1")
	  public static Object[][] credentials1() {
	 
	        return new Object[][] { { " ", "abcdef" }};
	        
	  }
	@Test(dataProvider = "Authentication1")
	public void emptyemail(String emailid,String pass)
	{
		
		
		WebElement email=m1.getDriver().findElement(By.name("Email"));
		email.clear();
		email.sendKeys(emailid);
		
		WebElement password=m1.getDriver().findElement(By.name("Password"));
		password.clear();
		password.sendKeys(pass);
		
		WebElement loginbtn=m1.getDriver().findElement(By.className("login-button"));
		loginbtn.submit();
		
		String currenturl=m1.getDriver().getCurrentUrl();
		
		if(currenturl.equals(expectedurl))
		{
			
			Assert.assertFalse(false);
			logininfo.put( "3", new Object[] { "3", emailid, pass,"pass" });
			
		}
		else
		{
			logininfo.put( "3", new Object[] { "3", emailid, pass,"fail" });
			Assert.assertFalse(true);
			
		}
		
		
	}

	@DataProvider(name = "Authentication2")
	  public static Object[][] credentials2() {
	 
	        return new Object[][] { { "soni.rutvi@tristonsoft.com", "" }};
	        
	  }
	@Test(dataProvider = "Authentication2")
	
	public void emptypassword(String emailid,String pass)
	{
		
		
		WebElement email=m1.getDriver().findElement(By.name("Email"));
		email.clear();
		email.sendKeys("soni.rutvi@tristonsoft.com");
		
		WebElement password=m1.getDriver().findElement(By.name("Password"));
		password.clear();
		password.sendKeys(" ");
		
		WebElement loginbtn=m1.getDriver().findElement(By.className("login-button"));
		loginbtn.submit();
		
		String currenturl=m1.getDriver().getCurrentUrl();
		
		if(currenturl.equals(expectedurl))
		{
			logininfo.put( "4", new Object[] { "4", emailid, pass,"true" });
			Assert.assertFalse(false);
			
		}
		else
		{
			logininfo.put( "4", new Object[] { "4", emailid, pass,"fail" });
			Assert.assertFalse(true);
		}
		
		
	}
	
	@DataProvider(name = "Authentication3")
	  public static Object[][] credentials3() {
	 
	        return new Object[][] { { "5","fhgfhgf", "gfdhdgfh" },{"6","soni.rutvi@triston","abcdfjhgj"},{"7","soni.rutvitristonsoft.com","fgfdg"}};
	        
	  }
	@Test(dataProvider = "Authentication3")
	
	public void invaliddata(String id,String emailid,String pass)
	{
		
		WebElement email=m1.getDriver().findElement(By.name("Email"));
		email.clear();
		email.sendKeys(emailid);
		
		WebElement password=m1.getDriver().findElement(By.name("Password"));
		password.clear();
		password.sendKeys(pass);
		
		WebElement loginbtn=m1.getDriver().findElement(By.className("login-button"));
		loginbtn.submit();
		
		String currenturl=m1.getDriver().getCurrentUrl();
		
		if(currenturl.equals(expectedurl))
		{
			//testresultdata.put("3", new Object[] {3d, emailid, pass,"True"});
			Assert.assertFalse(false);
			logininfo.put( id, new Object[] { id, emailid, pass,"pass" });
		}
		else
		{
			logininfo.put( id, new Object[] { id, emailid, pass,"fail" });
			Assert.assertFalse(true);
			//testresultdata.put("3", new Object[] {3d, emailid, pass,"FAil"});
		}
		
		
	}
	
	@DataProvider(name = "Authentication4")
	  public static Object[][] credentials4() {
	 
	        return new Object[][] { { "soni.rutvi+51@tristonsoft.com", "creative2000" }};
	        
	  }
	@Test(dataProvider = "Authentication4")
	public void validdata(String emailid,String pass) throws InterruptedException
	{
		
		
		WebElement email=m1.getDriver().findElement(By.name("Email"));
		email.clear();
		email.sendKeys(emailid);
		
		WebElement password=m1.getDriver().findElement(By.name("Password"));																																																															
		password.clear();
		password.sendKeys(pass);
		
		WebElement loginbtn=m1.getDriver().findElement(By.className("login-button"));
		loginbtn.submit();
		
		String currenturl=m1.getDriver().getCurrentUrl();
																																																																																																																																					
		if(currenturl.equals(expectedurl))
		{
			Assert.assertTrue(false);
			logininfo.put( "6", new Object[] { "6", emailid, pass,"fail" });
			
		}
		else
		{
			logininfo.put( "6", new Object[] { "6", emailid, pass,"pass" });
			Assert.assertTrue(true);
		}
		
		
	}
	@AfterClass
	public void afterclassmethod() throws IOException
	{
		
		Set < String > keyid = logininfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	         HSSFRow row = sheet.createRow(rowid++);
	         Object [] objectArr = logininfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      FileOutputStream out = new FileOutputStream(new File("/home/sevenbits/Music/login.xls"));
	      	
	     
	      workbook1.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
		
		
	}
}
	

