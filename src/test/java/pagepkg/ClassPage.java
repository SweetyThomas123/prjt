package pagepkg;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class ClassPage {
	
	WebDriver driver;
	
	By services=By.xpath("//*[@id=\"menu-item-40\"]/a");
	By bridal=By.xpath("//*[@id=\"menu-item-109\"]/a");
	By photogallery=By.xpath("//*[@id=\"menu-item-41\"]/a");
	By hairblows=By.xpath("/html/body/div[5]/div/div/div[4]/a");
	By booking=By.xpath("//*[@id=\"menu-item-42\"]/a");
	By location=By.xpath("//*[@id=\"menu-item-325\"]/a");
	By name=By.xpath("//*[@id=\"wpcf7-f379-o2\"]/form/div[2]/div[1]/p/span/input");
	By mobnum=By.xpath("//*[@id=\"wpcf7-f379-o2\"]/form/div[2]/div[2]/p/span/input");
	By date=By.xpath("//*[@id=\"wpcf7-f379-o2\"]/form/div[2]/div[3]/p/span/input");
	By service=By.xpath("//*[@id=\"wpcf7-f379-o2\"]/form/div[2]/div[4]/p/span/select");
	By booknow=By.xpath("//*[@id=\"wpcf7-f379-o2\"]/form/div[2]/div[5]/p/input");
	By dismiss=By.xpath("//*[@id=\"quickModal1\"]/div/div/div/button");
	By aboutus=By.xpath("//*[@id=\"menu-item-38\"]/a");
	
	
	public ClassPage(WebDriver driver)                        //constructor
	{
		this.driver=driver;
	}
	
	
	public void method1() throws Exception
	{
		WebElement ser = driver.findElement(services);
		Actions act=new Actions(driver);
		act.moveToElement(ser).perform();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(bridal).click();
		Thread.sleep(1000);	
	}
	
	public void method2() throws Exception
	{
		driver.findElement(photogallery).click();
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)", ""); 
		
		driver.findElement(hairblows).click();
		Thread.sleep(1000);	
	}
	
	public void method3() throws Exception
	{
		 WebElement book = driver.findElement(booking);
		 Actions acts=new Actions(driver);
		 acts.moveToElement(book).perform();
		 Thread.sleep(1000);
		 driver.findElement(location).click();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(name).sendKeys("Mariya Paul");
		driver.findElement(mobnum).sendKeys("8281687440");
		driver.findElement(date).sendKeys("03/03/2025");
		driver.findElement(service).sendKeys("Hair");
		driver.findElement(booknow).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);                                
		FileHandler.copy(src, new File("C:\\ScrnshotWholepage\\msgpic.png"));
		
		driver.findElement(dismiss).click();	
	}
	
	public void loginvalidation()
	{
		driver.findElement(aboutus).click();
		
		String expurl="https://cucumbabeautysalon.com/about-us/";
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		if(expurl.equals(actualurl))
		{
			System.out.println("validation successful...");
		}
		else
		{
			System.out.println("validation failed...");
		}
		
	}
	
}
