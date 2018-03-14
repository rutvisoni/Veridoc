package mypackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//@Test(groups = "init")
public class TestNG {
	
	WebDriver dri=null;

	
	/*@BeforeMethod (alwaysRun=true)
	  public void beforeMethod() 
	  {
		    System.out.println("launching chrome browser");
		    System.setProperty("webdri.chrome.dri","/home/sevenbits/Downloads/chromedri");
		  //  System.setProperty("webdri.chrome.dri", "//home/viinfo/Downloads/chromedri");
			dri = new Chromedri();
			dri.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			dri.navigate().to("https://doctor.stage.heltha.co/physician/login");
			//dri.manage().window().maximize();
      }*/
	
	masterclass m1=new masterclass();
	
	
	

	@BeforeClass
	public  void setup()
	{	
		try {
			dri=masterclass.getDriver();
			dri.navigate().to("https://doctor.stage.heltha.co/physician/login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	  @Test
	  public void A()
	  {
	      String strng = "username";
		  System.out.println(strng);
		  m1.getDriver().findElement(By.id("username")).sendKeys("");
		  String strng1 = "password";
		  System.out.println(strng1);
		  m1.getDriver().findElement(By.id("password")).sendKeys("");
		  String strng11 = "submit";
		  System.out.println(strng11);
		  Assert.assertEquals("submit",  m1.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  m1.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse( m1.getDriver().getCurrentUrl().endsWith("both field are blank"));
	  }
	  @Test(dependsOnMethods="A")
	  public void B() 
	  {
		  String strng111 = "username";
		  System.out.println(strng111);
		  m1.getDriver().findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p45@gmail.com");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  m1.getDriver().findElement(By.id("password")).sendKeys("");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit",  m1.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  m1.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse( m1.getDriver().getCurrentUrl().endsWith("Enter wrong credicials"));
	  }
		 /*
		  
		  String strng111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p45@gmail.com");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));

		  dri.findElement(By.id("username")).clear();
		  String strng111111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("");
		  String strng1111111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng11111111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));

		  dri.findElement(By.id("password")).clear();
		  String strng111111111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p1000@gmail.com");
		  String strng7 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral1234");
		  String strng8 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));
		  dri.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		  dri.navigate().refresh();
		  //dri.findElement(By.id("username")).clear();
		  //dri.findElement(By.id("password")).clear();
		  String strng1111111111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p2000@gmail.com");
		  String strng9 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng10 = "submit";
		  System.out.println(strng11111);
		  dri.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));
		  dri.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		  
			dri.navigate().refresh();
		  //dri.findElement(By.id("username")).clear();
		  //dri.findElement(By.id("password")).clear();
		  String strng11111111111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p2004@gmail.com");
		  String strng12 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral1234");
		  String strng13 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));
		  dri.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		  
		  dri.navigate().refresh();
		  String strng14 = "username";
		  System.out.println(strng);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p45@gmail.com");
		  String strng15 = "password";
		  System.out.println(strng1);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng16 = "submit";
		  System.out.println(strng11);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertTrue(dri.getCurrentUrl().endsWith("successfully login"));
	 }*/
	
	  /*@Test(dependsOnMethods="B")
	  public void C() 
	  {
		  String strng111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));

	  }
	  @Test(dependsOnMethods="C")
	  public void D() 
	  {
		  String strng111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p45@gmail.com");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral1234");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));

	  }
	  @Test(dependsOnMethods="D")
	  public void E() 
	  {
		  String strng111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p465@gmail.com");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));
	  }
	  @Test(dependsOnMethods="E")
	  public void F() 
	  {
		  String strng111 = "username";
		  System.out.println(strng111);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p4655@gmail.com");
		  String strng1111 = "password";
		  System.out.println(strng1111);
		  dri.findElement(By.id("password")).sendKeys("Hiral1234");
		  String strng11111 = "submit";
		  System.out.println(strng11111);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertFalse(dri.getCurrentUrl().endsWith("Enter wrong credicials"));

	  }
	  @Test(dependsOnMethods="F")
	 public void G() 
	  {
		  String strng = "username";
		  System.out.println(strng);
		  dri.findElement(By.id("username")).sendKeys("hiralg.virtueinfo+p45@gmail.com");
		  String strng1 = "password";
		  System.out.println(strng1);
		  dri.findElement(By.id("password")).sendKeys("Hiral123");
		  String strng11 = "submit";
		  System.out.println(strng11);
		  Assert.assertEquals("submit", dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).getAttribute("type"));	  
		  dri.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/form/div[5]/div/button")).click();
		  Assert.assertTrue(dri.getCurrentUrl().endsWith("successfully login"));
      }  */
  
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("Test completed");
	  //dri.quit();
  }
/*public static void main(String[] args) {
	dri.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
*/
}
