package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Project {

	@BeforeSuite

	
	public void beforesuite()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	
	public void beforetest()
	{
		System.out.println("Before Test");
	}
	
	
	@BeforeClass
	
	public void beforeclass()
	{
		System.out.println("Before class");
	
	}
	
	@BeforeMethod
	
	public void beforemethod()
	{
		System.out.println("Before Method");

	}
	
	@Test(priority=1,groups="Regression")
	
	public void test()
	{
		System.out.println("Test");

	}

	@Test(priority=0,groups="Regression")
	
	public void testsecond()
	{
		System.out.println("Test Second runs ");
	}
	
	@Test(dependsOnMethods = "testsecond")
	
	public void testthird()
	{
		System.out.println("Test Third runs");
	}
	
	@Test(description="Test Summary", enabled= true, invocationCount=10)
	
		public void testfourth()
		{
			int i=1/10;
			System.out.println("i");
		}
	
	@AfterMethod
	
	public void aftermethod()
	{
		System.out.println("After method runs ");
	}
		
}
