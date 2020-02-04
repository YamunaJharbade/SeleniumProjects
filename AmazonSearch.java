package com.amazon.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.AddToWishList;
import com.amazon.pages.LoginPage;
import com.amazon.util.WebEventListener;
import com.amazon.util.captureScreenshot;

import com.util.ReadExcel;


public class AmazonSearch extends TestBase{
	WebDriver driver;
	LoginPage LP;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public AmazonSearch() {
	 super();
	}
   
	@BeforeMethod
	public void launchBrowser() {
		initialization();
		//System.setProperty("org.freemarker.loggerLibrary", "none");
	}

	@Test
	public void LoginToApp() throws Exception {
	    LP = new LoginPage(driver);
		LP.Login();
		
	}
	
	 /*
	
	@Test(priority = 1)
	public void Login() throws Exception {
		System.out.println("TC01_Login to Amazon");
		LP = new LoginPage(driver);
		LP.Login();
		String actualresult = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).getText();
		Assert.assertEquals(actualresult, "Hello, Yamuna");
		System.out.println("Registered user successfully logged in to the application");
	
	}
	
	 /*
	// Test to search the product from 'Shop By Category' and 'Add to Cart'
	@Test(priority = 2)
	public void searchByCategoryCarttest() throws Exception {
     	System.out.println("TC02_Verify that registered user is able to Search the product from Category and Add it to cart");
     	AddToCartPage cart = new AddToCartPage(driver);
	    cart.searchByCategorytest();
	    cart.AddtoCart();
	}
	

	//Test to search the product from 'Shop By Text' and 'Add to Wishlist'
  	@Test(priority = 3, dataProvider = "getData")
	public void searchbyTextWLtest(String product) throws Exception {
	//extent.attachReporter(reporter);
	//	ExtentTest logger = extent.createTest("Search the product from search textbox and Add to Wishlist");
		//logger.log(Status.INFO, "Search the product from search texbox and 'Add to Wislist'");
  		System.out.println("TC03_Verify that registered user is able to search the product from search textbox and Add it to Wishlist");	
 		AddToWishList wl = new AddToWishList(driver);
  		wl.searchByText(product);
  		wl.Wishlist();
  	}
  	
    @DataProvider
   	public Object[][] getData() throws IOException{
   	//String currentDirectory = System.getProperty("user.dir");
    String datafile ="C:\\Yamuna Selenium\\AmazonSearch\\src\\main\\java\\com\\amazon\\testdata\\TestData.xlsx";  
   	System.out.println(datafile);
    Object[][] myTestData = ReadExcel.readTestData(datafile);
    return myTestData;		
   	}


	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=captureScreenshot.getScreenshot(driver);
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		//extent.flush();
		//driver.quit();
		
	}
	*/
}
