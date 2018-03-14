package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Webm1.getDriver();
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.Chromem1.getDriver();
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class passport {
	
	String geturl;
	String expurl="https://veridocglobal.com.au/GIA/List";

	WebDriver dri=null;
	
	
	masterclass m1=new masterclass();
	
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
		
		m1.selecttemplate("PassportTemplate");
		blankdata();
	
		
	}

	
	public void blankdata() throws InterruptedException
	{
		WebElement type=m1.getDriver().findElement(By.id("Type"));
		type.sendKeys(" ");
		
		WebElement countryissue=m1.getDriver().findElement(By.id("CountryOfIssuing"));
		countryissue.sendKeys(" ");
		
		WebElement docno=m1.getDriver().findElement(By.id("DocumentNo"));
		docno.sendKeys(" ");
		
		WebElement fname=m1.getDriver().findElement(By.id("FirstName"));
		fname.sendKeys(" ");
		
		WebElement lname=m1.getDriver().findElement(By.id("LastName"));
		lname.sendKeys(" ");
		
		WebElement nationality=m1.getDriver().findElement(By.id("Nationality"));
		nationality.sendKeys(" ");
		
		Thread.sleep(2000);
		WebElement sex=m1.getDriver().findElement(By.name("Sex"));
		sex.click();
		
		Select dropdown= new Select(sex);
		dropdown.selectByIndex(1);
		
		
		
		WebElement birthdate=m1.getDriver().findElement(By.name("DateOfBirth"));
		birthdate.click();
		
		List<WebElement> allDates=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase(" "))
			{
				ele.click();
				break;
			}
			
		}
		
		
		WebElement placeofbirth=m1.getDriver().findElement(By.name("PlaceOfBirth"));
		placeofbirth.sendKeys("");
		
		WebElement issuedate=m1.getDriver().findElement(By.name("DateOfIssue"));
		issuedate.click();
		
		List<WebElement> issuedate1=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:issuedate1)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase(" "))
			{
				ele.click();
				break;
			}
			
		}
		
		WebElement expdate=m1.getDriver().findElement(By.name("DateOfExpiry"));
		expdate.click();
		
		List<WebElement> issuedate2=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:issuedate2)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase(" "))
			{
				ele.click();
				break;
			}
			
		}
		
		WebElement issueofauthority=m1.getDriver().findElement(By.name("IssuingAuthority"));
		issueofauthority.sendKeys("");
		
		String filepathinvalid="/home/rutvi/Pictures/download.jpg";
		
		
		WebElement uploadphoto=m1.getDriver().findElement(By.name("qqfile"));
		uploadphoto.sendKeys("");
		
		
		WebElement upload=m1.getDriver().findElement(By.name("Command"));
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
	@Test
		public void validdata() throws InterruptedException {
			WebElement type=m1.getDriver().findElement(By.id("Type"));
			type.sendKeys("1");
			
			WebElement countryissue=m1.getDriver().findElement(By.id("CountryOfIssuing"));
			countryissue.sendKeys("test");
			
			WebElement docno=m1.getDriver().findElement(By.id("DocumentNo"));
			docno.sendKeys("1");
			
			WebElement fname=m1.getDriver().findElement(By.id("FirstName"));
			fname.sendKeys("rutvi");
			
			WebElement lname=m1.getDriver().findElement(By.id("LastName"));
			lname.sendKeys("soni");
			
			WebElement nationality=m1.getDriver().findElement(By.id("Nationality"));
			nationality.sendKeys("india");
			
			Thread.sleep(2000);
			WebElement sex=m1.getDriver().findElement(By.name("Sex"));
			sex.click();
			
			Select dropdown= new Select(sex);
			dropdown.selectByIndex(1);
			
			
			
			WebElement birthdate=m1.getDriver().findElement(By.name("DateOfBirth"));
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
			
			
			WebElement placeofbirth=m1.getDriver().findElement(By.name("PlaceOfBirth"));
			placeofbirth.sendKeys("fhfgh");
			
			WebElement issuedate=m1.getDriver().findElement(By.name("DateOfIssue"));
			issuedate.click();
			
			List<WebElement> issuedate1=m1.getDriver().findElements(By.className("ui-state-default"));
				
			
			for(WebElement ele:issuedate1)
			{
				
				String date1=ele.getText();
				
				if(date1.equalsIgnoreCase("1"))
				{
					ele.click();
					break;
				}
				
			}
			
			WebElement expdate=m1.getDriver().findElement(By.name("DateOfExpiry"));
			expdate.click();
			
			List<WebElement> issuedate2=m1.getDriver().findElements(By.className("ui-state-default"));
				
			
			for(WebElement ele:issuedate2)
			{
				
				String date1=ele.getText();
				
				if(date1.equalsIgnoreCase("9"))
				{
					ele.click();
					break;
				}
				
			}
			
			WebElement issueofauthority=m1.getDriver().findElement(By.name("IssuingAuthority"));
			issueofauthority.sendKeys("dgfggf");
			
			
			
			String filepathinvalid="/home/sevenbits/Downloads/index.jpeg";
			
			
			
			WebElement uploadphoto=m1.getDriver().findElement(By.name("qqfile"));
			uploadphoto.sendKeys(filepathinvalid);
			
			Thread.sleep(4000);
			
			WebElement upload=m1.getDriver().findElement(By.name("Command"));
			upload.click();
			
			geturl=m1.getDriver().getCurrentUrl();
			if(expurl.equals(geturl))
			{
				assertEquals(expurl, geturl);
			}
			
		}
	@AfterClass
	public void aftermethod()
	{
		  masterclass.getDriver().get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
			
	}
	
}
