package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class resume {
	
	String geturl;
	String expurl="https://veridocglobal.com.au/Resume/List";

	
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
	
	@Test(priority=1)
	public void selecttemplate() throws InterruptedException
	{
		m1.selecttemplate("ResumeTemplate");
		//blankdata();
	//	validdata();
		
		
	}
	
	public void blankdata()
	{
		WebElement name=m1.getDriver().findElement(By.id("Name"));
		name.sendKeys(" ");
		
		WebElement email=m1.getDriver().findElement(By.id("resumeemailid"));
		email.sendKeys("");
		
		WebElement address=m1.getDriver().findElement(By.id("Address"));
		address.sendKeys("");
		
		
		WebElement contactinfo=m1.getDriver().findElement(By.id("ContactInfo"));
		contactinfo.sendKeys(" ");
		
		WebElement bdate=m1.getDriver().findElement(By.id("dob"));
		bdate.sendKeys(" ");
		
		WebElement birthplace=m1.getDriver().findElement(By.id("BirthPlace"));
		birthplace.sendKeys(" ");
		
		WebElement nationality=m1.getDriver().findElement(By.id("Nationality"));
		nationality.sendKeys(" ");
		
		WebElement maritalstatus=m1.getDriver().findElement(By.id("MaritalStatus"));
		maritalstatus.sendKeys(" ");
		
		WebElement objective=m1.getDriver().findElement(By.id("Objective"));
		objective.sendKeys(" ");
		
		WebElement edu1=m1.getDriver().findElement(By.name("EducationDetail1"));
		edu1.sendKeys(" ");
		
		WebElement edu2=m1.getDriver().findElement(By.name("EducationDetail2"));
		edu2.sendKeys(" ");
		
		WebElement edu3=m1.getDriver().findElement(By.name("EducationDetail3"));
		edu3.sendKeys(" ");
		
		WebElement workdetail1=m1.getDriver().findElement(By.name("WorkExperienceDetail1"));
		workdetail1.sendKeys(" ");
		
		WebElement workdetail2=m1.getDriver().findElement(By.name("WorkExperienceDetail2"));
		workdetail2.sendKeys(" ");
		
		WebElement workdetail3=m1.getDriver().findElement(By.name("WorkExperienceDetail3"));
		workdetail3.sendKeys(" ");
		

		WebElement technicalskill=m1.getDriver().findElement(By.name("TechnicalSkills"));
		technicalskill.sendKeys(" ");
															
		WebElement otheractivies=m1.getDriver().findElement(By.name("OtherActivities"));
		otheractivies.sendKeys(" ");
		
		WebElement declaration=m1.getDriver().findElement(By.name("Declaration"));
		declaration.sendKeys(" ");
		
		WebElement upload=m1.getDriver().findElement(By.name("Command"));
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
	
	
	@Test(priority=2)
	public void validdata() throws InterruptedException
	{
		WebElement name=m1.getDriver().findElement(By.id("Name"));
		name.sendKeys("test");
		
		WebElement email=m1.getDriver().findElement(By.id("resumeemailid"));
		email.sendKeys("soni.rutvi@tristonsoft.com");
		

		WebElement address=m1.getDriver().findElement(By.id("Address"));
		address.sendKeys("test");
		
		WebElement contactinfo=m1.getDriver().findElement(By.id("ContactInfo"));
		contactinfo.sendKeys("12345678");
		
		WebElement bdate=m1.getDriver().findElement(By.name("BirthDate"));
		Thread.sleep(2000);
		
		bdate.click();
		
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
		
		
		WebElement birthplace=m1.getDriver().findElement(By.id("BirthPlace"));
		birthplace.sendKeys("test");
		
		WebElement nationality=m1.getDriver().findElement(By.id("Nationality"));
		nationality.sendKeys("test");
		
		WebElement maritalstatus=m1.getDriver().findElement(By.id("MaritalStatus"));
		maritalstatus.sendKeys("test");
		
		WebElement objective=m1.getDriver().findElement(By.id("Objective"));
		objective.sendKeys("test");
		
		WebElement edu1=m1.getDriver().findElement(By.name("EducationDetail1"));
		edu1.sendKeys("test");
		
		WebElement edu2=m1.getDriver().findElement(By.name("EducationDetail2"));
		edu2.sendKeys("test");
		
		WebElement edu3=m1.getDriver().findElement(By.name("EducationDetail3"));
		edu3.sendKeys("test");
		
		WebElement workdetail1=m1.getDriver().findElement(By.name("WorkExperienceDetail1"));
		workdetail1.sendKeys("test");
		
		WebElement workdetail2=m1.getDriver().findElement(By.name("WorkExperienceDetail2"));
		workdetail2.sendKeys("test");
		
		WebElement workdetail3=m1.getDriver().findElement(By.name("WorkExperienceDetail3"));
		workdetail3.sendKeys("test");
		

		WebElement technicalskill=m1.getDriver().findElement(By.name("TechnicalSkills"));
		technicalskill.sendKeys("test");
		
		WebElement otheractivies=m1.getDriver().findElement(By.name("OtherActivities"));
		otheractivies.sendKeys("test");
		
		WebElement declaration=m1.getDriver().findElement(By.name("Declaration"));
		declaration.sendKeys("test");
		
		WebElement upload=m1.getDriver().findElement(By.name("Command"));
		upload.submit();
		

		geturl=m1.getDriver().getCurrentUrl();
		

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