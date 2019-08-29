package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class ExpenseTracker {

	public String baseUrl = "http://thawing-shelf-73260.herokuapp.com/index.jsp";
	String driverPath = "./drivers/chromedriver.exe";
	public WebDriver driver ; 


	@BeforeTest

	public void RedirectURL()
	{

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[contains(text(),'Register new user')]")).click();

	}
	//@Test(dataProvider="dataset",priority=0)

	public void Registration(String UName , String Pwd , String CPwd)
	{
		WebElement username = driver.findElement(By.id("login"));
		username.sendKeys(UName);
		System.out.println("Username is :" + UName);

		WebElement password=driver.findElement(By.id("password1"));
		password.sendKeys(Pwd); 
		System.out.println("Password is :" + Pwd);

		WebElement password2=driver.findElement(By.id("password2"));
		password2.sendKeys(CPwd); 
		System.out.println("ConfirmPassword is :" + CPwd);

	}


	@DataProvider(name="dataset")
	public Object[] getData(){
		return new Object[][]
				{
			{ "Cirleen","Test@123","Test@123"}

				};

	}

	@Test(dataProvider="dataset1",priority=1)

	public void Login(String UName1,String Pwd)
	{
		//driver.findElement(By.id("submit")).click();
		WebElement username = driver.findElement(By.id("login"));
		username.sendKeys(UName1);
		System.out.println("Username is :" + UName1);

		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys(Pwd); 
		System.out.println("Password is :" + Pwd);
	}

	@DataProvider(name="dataset1")
	public Object[][] getDataLogin()
	{
		return new Object[][]
				{
			{"Cirleen","Test@123"}
				};
	}

	@Test(priority=2)
	public void LoginClick()
	{
		driver.findElement(By.id("submit")).click();
		System.out.println("login is clicked");
	}
	
	@Test(priority=3)
	
	public void ListCategory()
	{
		driver.findElement(By.id("go_list_categories")).click();
		driver.findElement(By.xpath("//a[@id='go_add_category']//img")).click();
		driver.findElement(By.id("name")).sendKeys("Fruits");
		driver.findElement(By.id("submit")).click();
		System.out.println("List category is added");
		
	}
	
	@Test(priority=4)
	public void addexpense()
	{
		driver.findElement(By.id("go_list_categories")).click();
		
	}
}

