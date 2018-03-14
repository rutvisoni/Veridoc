package mypackage;
import static org.testng.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gia {
	
	String geturl;
	String expurl="https://veridocglobal.com.au/GIA/List";

	
	
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
		
		m1.selecttemplate("GIATemplate1");
		blankdata();
			
	}
	
	
	public void blankdata() throws InterruptedException
	{
		WebElement giareportno=m1.getDriver().findElement(By.id("GIAReportNumber"));
		giareportno.sendKeys(" ");
		
		Thread.sleep(2000);
		
		WebElement issuedate=m1.getDriver().findElement(By.id("IssuedDate"));
		issuedate.click();
		
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
		
		WebElement laserregistry=m1.getDriver().findElement(By.id("LaserInscriptionRegistry"));
		laserregistry.sendKeys("");
		
		WebElement shapecutting=m1.getDriver().findElement(By.id("ShapeAndCuttingStyles"));
		shapecutting.sendKeys("");
		

		WebElement measurements=m1.getDriver().findElement(By.id("Measurements"));
		measurements.sendKeys("");
		
		WebElement carweight=m1.getDriver().findElement(By.id("CaratWeight"));
		carweight.sendKeys("");
		
		WebElement colorgrade=m1.getDriver().findElement(By.id("ValueId"));
		colorgrade.click();
		
		Select dropdown= new Select(colorgrade);
		dropdown.selectByIndex(1);
		
		WebElement claritygrade=m1.getDriver().findElement(By.name("ClarityValueId"));
		claritygrade.click();
		
		Select dropdown1= new Select(claritygrade);
		dropdown1.selectByIndex(1);
		
		WebElement cutgrade=m1.getDriver().findElement(By.id("CutGradeId"));
		claritygrade.click();
		
		Select dropdown2= new Select(cutgrade);
		dropdown2.selectByIndex(1);
		
		WebElement polish=m1.getDriver().findElement(By.id("Polish"));
		polish.sendKeys("");
		
		WebElement symmetry=m1.getDriver().findElement(By.id("Symmetry"));
		symmetry.sendKeys("");
		
		WebElement fluorence=m1.getDriver().findElement(By.id("Fluorescence"));
		fluorence.sendKeys("");
		
		
		WebElement upload=m1.getDriver().findElement(By.id("register-button gia-upload"));
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
		WebElement giareportno=m1.getDriver().findElement(By.id("GIAReportNumber"));
		giareportno.sendKeys("1");
		
		Thread.sleep(2000);
		
		WebElement issuedate=m1.getDriver().findElement(By.id("IssuedDate"));
		issuedate.click();
		
		List<WebElement> allDates=m1.getDriver().findElements(By.className("ui-state-default"));
			
		
		for(WebElement ele:allDates)
		{
			
			String date1=ele.getText();
			
			if(date1.equalsIgnoreCase("2"))
			{
				ele.click();
				break;
			}
			
		}
		
		WebElement laserregistry=m1.getDriver().findElement(By.id("LaserInscriptionRegistry"));
		laserregistry.sendKeys("test");
		
		WebElement shapecutting=m1.getDriver().findElement(By.id("ShapeAndCuttingStyles"));
		shapecutting.sendKeys("test");
		

		WebElement measurements=m1.getDriver().findElement(By.id("Measurements"));
		measurements.sendKeys("test");
		
		WebElement carweight=m1.getDriver().findElement(By.id("CaratWeight"));
		carweight.sendKeys("test");
		
		WebElement colorgrade=m1.getDriver().findElement(By.id("ValueId"));
		colorgrade.click();
		
		Select dropdown= new Select(colorgrade);
		dropdown.selectByIndex(1);
		
		WebElement claritygrade=m1.getDriver().findElement(By.name("ClarityValueId"));
		claritygrade.click();
		
		Select dropdown1= new Select(claritygrade);
		dropdown1.selectByIndex(1);
		
		WebElement cutgrade=m1.getDriver().findElement(By.id("CutGradeId"));
		claritygrade.click();
		
		Select dropdown2= new Select(cutgrade);
		dropdown2.selectByIndex(1);
		
		WebElement polish=m1.getDriver().findElement(By.id("Polish"));
		polish.sendKeys("test");
		
		WebElement symmetry=m1.getDriver().findElement(By.id("Symmetry"));
		symmetry.sendKeys("test");
		
		WebElement fluorence=m1.getDriver().findElement(By.id("Fluorescence"));
		fluorence.sendKeys("test");
		
		
		WebElement upload=m1.getDriver().findElement(By.id("register-button gia-upload"));
		upload.click();
		
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
