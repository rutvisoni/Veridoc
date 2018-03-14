package mypackage;

import java.io.File;
import java.io.FileNotFoundException;
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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class register {

	masterclass m1=new masterclass();

	 HSSFWorkbook workbook1;
	
	 HSSFSheet sheet;
	 Map < String, Object[] > registersinfo = 
		      new TreeMap < String, Object[] >();
		     
	
	WebDriver dri=null;
	String expurl="https://veridocglobal.com/selecttemplate";

	@BeforeClass
	public  void setup()
	{	
		try {
			dri=masterclass.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//m1.setup();
		m1.getDriver().get("https://veridocglobal.com/register");
		workbook1 = new HSSFWorkbook();
		
		 sheet=workbook1.createSheet("Register");
	      
	    registersinfo.put( "1", new Object[] { "First name", "Last name", "Email","Password","Confirm Password","Pass/Fail" });
	
	}
	@DataProvider(name = "Authentication")
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { " ", " "," "," "," "}};
	        
	  }
	@Test(dataProvider = "Authentication",priority=1)
	public void blankdata(String f, String l,String em,String pass,String conpas)
	{
		WebElement firstname=m1.getDriver().findElement(By.id("FirstName"));
		firstname.clear();
		firstname.sendKeys(f);
		
		WebElement lastname=m1.getDriver().findElement(By.id("LastName"));
		lastname.clear();
		lastname.sendKeys(l);
		
		WebElement email=m1.getDriver().findElement(By.id("email"));
		email.clear();
		email.sendKeys(em);
		
		WebElement pass1=m1.getDriver().findElement(By.id("password"));
		pass1.sendKeys(pass);
		
		WebElement conpass=m1.getDriver().findElement(By.id("confirmpassword"));
		conpass.clear();
		conpass.sendKeys(conpas);
		
		WebElement register=m1.getDriver().findElement(By.className("register-next-step-button"));
		Actions action = new Actions(m1.getDriver());
		action.moveToElement(register).click().perform();
		
		String cururl=m1.getDriver().getCurrentUrl();
		if(cururl.equals(expurl))
		{
			
			//registersinfo.put("2", new object [] {f,l,em,pass,conpas});
			Assert.assertFalse(true);
			registersinfo.put( "2", new Object[] { f, l, em,pass,conpas,"Test case fail" });
		}
		else
		{
			registersinfo.put( "2", new Object[] { f, l, em,pass,conpas,"Test Cases Pass" });
			Assert.assertFalse(true);
			
		}
	}
	@DataProvider(name = "Authentication2")
	  public static Object[][] credentials2() {
	 
	        return new Object[][] { { "3"," 646", "Soni "," soni.rutvi@tristonsoft.com"," 123456","1234567"},{"4","Rutvi", "78687"," soni.rutvi@tristonsoft.com"," 123456","1234567"},{"5","Rutvi", "Soni"," soni.rutvi@..tristonsoft.com"," 123456","123456"},{"6","Rutvi", "Soni"," soni.rutvi@..tristonsoft.com"," 1234567","1234567"},{"7","Rutvi", "Soni"," soni.rutvi@tristonsoft.com"," 123456","1234567"}};
	        
	  }
	@Test(dataProvider = "Authentication2",priority=1)
	public void invaliddata(String id,String f, String l,String em,String pass,String conpas)
	{
		WebElement firstname=m1.getDriver().findElement(By.id("FirstName"));
		firstname.clear();
		firstname.sendKeys(f);
		
		WebElement lastname=m1.getDriver().findElement(By.id("LastName"));
		lastname.clear();
		lastname.sendKeys(l);	
		
		WebElement email=m1.getDriver().findElement(By.id("email"));
		email.clear();
		email.sendKeys(em);
		
		WebElement pass1=m1.getDriver().findElement(By.id("password"));
		pass1.clear();
		pass1.sendKeys(pass);
		
		WebElement conpass=m1.getDriver().findElement(By.id("confirmpassword"));
		conpass.clear();
		conpass.sendKeys(conpas);
		
		WebElement register=m1.getDriver().findElement(By.className("register-next-step-button"));
		Actions action = new Actions(m1.getDriver());
		action.moveToElement(register).click().perform();
	//	register.click();
		
		String cururl=m1.getDriver().getCurrentUrl();
		if(cururl.equals(expurl))
		{
			
			//registersinfo.put("2", new object [] {f,l,em,pass,conpas});
			Assert.assertFalse(true);
			registersinfo.put( id, new Object[] { f, l, em,pass,conpas,"Test case fail" });
		}
		else
		{
			registersinfo.put( id, new Object[] { f, l, em,pass,conpas,"Test Cases Pass" });
			Assert.assertTrue(false);
			
		}
	}
	
	@DataProvider(name = "Authentication1")
	  public static Object[][] credentials1() {
	 
	        return new Object[][] { { "Rutvi", "Soni","test@gmail.com","creative2000 ","creative2000" }};
	        
	  }
	@Test(dataProvider = "Authentication1",priority=2)
	public void validdata(String f, String l,String em,String pass,String conpas) throws InterruptedException
	{
		WebElement firstname=m1.getDriver().findElement(By.id("FirstName"));
		firstname.clear();
		firstname.sendKeys(f);
		
		WebElement lastname=m1.getDriver().findElement(By.id("LastName"));
		lastname.clear();
		lastname.sendKeys(l);
		
		WebElement email=m1.getDriver().findElement(By.id("email"));
		email.clear();
		email.sendKeys(em);
		
		Thread.sleep(1000);
	//	m1.getDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		WebElement pass1=m1.getDriver().findElement(By.id("password"));
		pass1.clear();
		pass1.sendKeys(pass);
		
		WebElement conpass=m1.getDriver().findElement(By.id("confirmpassword"));
		conpass.clear();
		conpass.sendKeys(conpas);
		
		//WebElement showpass=m1.getDriver().findElement(By.id("show"));
		//showpass.click();
		
		WebElement register=m1.getDriver().findElement(By.className("register-next-step-button"));
		register.click();
		String cururl=m1.getDriver().getCurrentUrl();
		if(cururl.equals(expurl))
		{
			
			Assert.assertFalse(true);
			registersinfo.put( "8", new Object[] {f, l, em,pass,conpas,"Test case fail" });
		}
		else
		{
			registersinfo.put( "8", new Object[] {f, l, em,pass,conpas,"test cases Pass" });
			Assert.assertFalse(true);
			
		}
		
		
	}

	@AfterClass
	public void close() throws IOException
	{
		Set < String > keyid = registersinfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	         HSSFRow row = sheet.createRow(rowid++);
	         Object [] objectArr = registersinfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      FileOutputStream out = new FileOutputStream(new File("/home/sevenbits/Music/register.xls"));
	      	
	     
	      workbook1.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
		
		
	}

}
