package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class qut {
	
	String geturl;
	String expurl="https://veridocglobal.com.au/QUT/List";

	
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
		m1.selecttemplate("QUTTemplate");		
		blankdata();
		
	}
	
	public void blankdata() throws InterruptedException
	{
		
		WebElement name=m1.getDriver().findElement(By.id("Name"));
		name.sendKeys("");
		
		WebElement coursename=m1.getDriver().findElement(By.id("CourseName"));
		coursename.sendKeys("");
		
		
		Thread.sleep(2000);
		WebElement dateofisue=m1.getDriver().findElement(By.id("effective"));
		dateofisue.click();
		
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
		WebElement docno=m1.getDriver().findElement(By.id("DocumentNo"));
		docno.sendKeys("");
		
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
	public void validdata() throws InterruptedException
	{
		WebElement name=m1.getDriver().findElement(By.id("Name"));
		name.sendKeys("rutvi");
		
		WebElement coursename=m1.getDriver().findElement(By.id("CourseName"));
		coursename.sendKeys("mca");
		
		Thread.sleep(2000);
		
		WebElement dateofisue=m1.getDriver().findElement(By.id("effective"));
		dateofisue.click();
		
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
		WebElement docno=m1.getDriver().findElement(By.id("DocumentNo"));
		docno.sendKeys("1");
		
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
		m1.getDriver().get("https://veridocglobal.com/CustomerTemplate/SelectTemplate");
			
	}

}
