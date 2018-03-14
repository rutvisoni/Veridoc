package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class soa {
	
	
	
	String geturl;
	String expurl="https://veridocglobal.com.au/SOA/List";
	
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
		
	
	}
	
	@Test
	public void selecttemplate() throws InterruptedException
	{
		
		m1.selecttemplate("FormTemplate1");
		blankdata();
				
	}
	
	
	public void blankdata() throws InterruptedException
	{
		WebElement code=dri.findElement(By.name("National_Provider_Code_No"));
		code.sendKeys(" ");
		
		WebElement name=dri.findElement(By.name("Name"));
		name.sendKeys(" ");

		WebElement coursecode=dri.findElement(By.name("Course_Code"));
		coursecode.sendKeys(" ");
		
		WebElement coursetitle=dri.findElement(By.name("Course_Title"));
		coursetitle.sendKeys(" ");

		WebElement sign=dri.findElement(By.name("Signing_Officer"));
		sign.sendKeys(" ");
		
		WebElement signposition=dri.findElement(By.name("Signing_Officer_Position"));
		signposition.sendKeys(" ");
		
		
		WebElement datepi=dri.findElement(By.name("Issued_Date"));
		datepi.click();
		Thread.sleep(1000);
		
		List<WebElement> allDates=dri.findElements(By.className("ui-state-default"));
		
	
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase(" "))
			{
				ele.click();
				break;
			}
			
		}
		
	
		WebElement docno=dri.findElement(By.name("Document_Number"));
		docno.sendKeys(" ");
		
		WebElement upload=dri.findElement(By.name("Command"));
		upload.submit();
		
		geturl=dri.getCurrentUrl();
		
		if(expurl.equals(geturl))
		{
			Assert.assertFalse(false);
		}
		else
		{
			Assert.assertFalse(true);
			
		}

	}
	
	
	@Test
	public  void validdata() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElement code=dri.findElement(By.name("National_Provider_Code_No"));
		code.sendKeys("1");
		
		WebElement name=dri.findElement(By.name("Name"));
		name.sendKeys("test");


		WebElement coursecode=dri.findElement(By.name("Course_Code"));
		coursecode.sendKeys("mca");
		
		WebElement coursetitle=dri.findElement(By.name("Course_Title"));
		coursetitle.sendKeys("fgfd");
		
	//	WebElement date=m1.getdri().findElement(By.id("Document_Number"));
	//	date.click();
		
		WebElement sign=dri.findElement(By.name("Signing_Officer"));
		sign.sendKeys("ghg");
		
		WebElement signposition=dri.findElement(By.name("Signing_Officer_Position"));
		signposition.sendKeys("hgfh");
		
		WebElement datepi=dri.findElement(By.id("Issued_Date"));
		Thread.sleep(2000);
		datepi.click();
		
		List<WebElement> allDates=dri.findElements(By.className("ui-state-default"));
		
		
		
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
			
		}

		WebElement docno=dri.findElement(By.id("Document_Number"));
		docno.sendKeys("4");
		
		WebElement upload=dri.findElement(By.name("Command"));
		upload.submit();
		
		geturl=dri.getCurrentUrl();
		
		if(expurl.equals(geturl))
		{
			assertEquals(expurl, geturl);
		}
		
			
	}
	
	@AfterClass
	public void close()
	{
		  dri.get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
		
	}
	
	
	
	
	
	
	

}
