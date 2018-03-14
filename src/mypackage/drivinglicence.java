package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class drivinglicence {


String geturl;
String expurl="https://veridocglobal.com.au/Licence/List";
	
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
		
			m1.selecttemplate("DrivingLicenceTemplate");
			
			blankdata();
				
	}
	@Test
	public  void validdata() throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement fname=m1.getDriver().findElement(By.id("FirstName"));
		fname.sendKeys("rutvi");
		
		WebElement lname=m1.getDriver().findElement(By.id("LastName"));
		lname.sendKeys("soni");
		
		WebElement licenceno=m1.getDriver().findElement(By.id("licenceno"));
		licenceno.sendKeys("1");
		
		Thread.sleep(2000);
		
		WebElement birthdate=m1.getDriver().findElement(By.id("dob"));
		birthdate.click();
		
		List<WebElement> allDates=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("13"))
			{
				ele.click();
				break;
			}
			
		}
		WebElement sex=m1.getDriver().findElement(By.id("drivingsex"));
		sex.click();
		
		Select dropdown= new Select(sex);
		dropdown.selectByIndex(1);
		
		Thread.sleep(2000);
		
		WebElement height=m1.getDriver().findElement(By.id("Height"));
		height.sendKeys("12");
		
		WebElement class1=m1.getDriver().findElement(By.id("Class"));
		class1.sendKeys("test");
		
		WebElement type=m1.getDriver().findElement(By.id("Type"));
		type.sendKeys("test");
		
		
		WebElement effective=m1.getDriver().findElement(By.id("effective"));
		effective.click();
		
		List<WebElement> eff=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:eff)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
			
		}
		
		WebElement expire=m1.getDriver().findElement(By.id("expiry"));
		expire.click();
		
		List<WebElement> ex=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:ex)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("31"))
			{
				ele.click();	
				break;
			}
			
		}
		
		String filepathinvalid="/home/rutvi/Pictures/index.jpeg";
		
		Thread.sleep(4000);
		
		WebElement uploadimg=m1.getDriver().findElement(By.name("qqfile"));
		uploadimg.sendKeys(filepathinvalid);
		
		Thread.sleep(4000);
		WebElement upload=m1.getDriver().findElement(By.id("register-button licence-upload"));
		upload.click();
		
		
		geturl=m1.getDriver().getCurrentUrl();
		
		if(expurl.equals(geturl))
		{
			assertEquals(expurl, geturl);
		}
		

		
	}
	
	public void blankdata() throws InterruptedException
	{
		WebElement fname=m1.getDriver().findElement(By.id("FirstName"));
		fname.sendKeys(" ");
		
		WebElement lname=m1.getDriver().findElement(By.id("LastName"));
		lname.sendKeys(" ");
		
		WebElement licenceno=m1.getDriver().findElement(By.id("licenceno"));
		licenceno.sendKeys(" ");
		
		Thread.sleep(2000);
		
		WebElement birthdate=m1.getDriver().findElement(By.id("dob"));
		birthdate.click();
		
		List<WebElement> allDates=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
			
		}
		WebElement sex=m1.getDriver().findElement(By.id("drivingsex"));
		sex.click();
		
		Select dropdown= new Select(sex);
		dropdown.selectByIndex(1);
		
		
		WebElement height=m1.getDriver().findElement(By.id("Height"));
		height.sendKeys(" ");
		
		WebElement class1=m1.getDriver().findElement(By.id("Class"));
		class1.sendKeys(" ");
		
		WebElement type=m1.getDriver().findElement(By.id("Type"));
		type.sendKeys(" ");
		
		
		WebElement effective=m1.getDriver().findElement(By.id("effective"));
		effective.click();
		
		List<WebElement> eff=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:eff)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
			
		}
		
		WebElement expire=m1.getDriver().findElement(By.id("expiry"));
		expire.click();
		
		List<WebElement> ex=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:ex)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("25"))
			{
				ele.click();	
				break;
			}
			
		}
		
		String filepathinvalid="/home/sevenbits/Downloads/index.jpeg";
		
		Thread.sleep(2000);
		
		WebElement uploadimg=m1.getDriver().findElement(By.name("qqfile"));
		uploadimg.sendKeys(filepathinvalid);
		
		Thread.sleep(4000);
		
		WebElement upload=m1.getDriver().findElement(By.id("register-button licence-upload"));
		upload.click();
		
		geturl=m1.getDriver().getCurrentUrl();
		
		if(expurl.equals(geturl))
		{
			Assert.assertFalse(false);
		}
		else
		{
			Assert.assertFalse(true);
			
		}
		
		
		
	}
	@AfterClass
	public void close()
	{
		  m1.getDriver().get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
		
	}
	
}
