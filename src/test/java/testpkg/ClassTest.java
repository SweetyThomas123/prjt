package testpkg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.ClassPage;

public class ClassTest {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://cucumbabeautysalon.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test1() throws Exception
	{
		ClassPage ob=new ClassPage(driver);
		ob.method1();
		ob.method2();
		ob.method3();
		ob.loginvalidation();
	}

}
