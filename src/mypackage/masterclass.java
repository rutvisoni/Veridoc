package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;	
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;


public class masterclass {

	static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver","/home/sevenbits/Downloads/chromedriver");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable extension");
		driver=new ChromeDriver(option);
	 //	driver.manage().window().maximize();
	
		
	}

	public void login() 
	{
	
			driver.get("https://veridocglobal.com/login");
	
		 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		 	WebElement email=driver.findElement(By.id("Email"));
			email.sendKeys("soni.rutvi@tristonsoft.com");
			
			WebElement password=driver.findElement(By.id("password"));
			password.sendKeys("abcdef");
			
			WebElement login=driver.findElement(By.className("login-button"));
			login.submit();
			
			
	}
	public void selecttemplate(String v1) throws InterruptedException
	{
	
			
		List<WebElement> rdBtn = driver.findElements(By.name("Template_Type"));
			
		int size=rdBtn.size();
		
		for(int i=0;i<size;i++)
		{
			String val=rdBtn.get(i).getAttribute("value");
			System.out.println(val);
		
			if(val.equals(v1))
			{
				Thread.sleep(3000);
			//	String parentHandle = driver.getWindowHandle();
			
				rdBtn.get(i).click();
					
				Thread.sleep(4000);
				
				break;
			}
		}
		
		WebElement save=driver.findElement(By.name("register-button"));
		save.submit();

		
}
}
