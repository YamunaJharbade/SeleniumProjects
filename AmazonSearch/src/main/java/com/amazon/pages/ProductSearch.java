package com.amazon.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductSearch {

	private WebDriver driver;
	//captureScreenshot cs;
	//String txtname;

	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']") private WebElement CategoryMenu;
	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul/li/a[@data-menu-id ='10']") private WebElement SelectCategory;
	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[9]/li[4]/a/div") private WebElement Option;
	@FindBy(xpath = "//span[text()= 'Top Brands']")	private WebElement AmazonFashionfilter;

	// PriceFilters
	@FindBy(id = "low-price") private WebElement LowPriceFilter;
	@FindBy(id = "high-price") private WebElement HighPriceFilter;
	@FindBy(xpath = "//span[@id='a-autoid-1']") private WebElement GoButton;
	
	//Sort by filter
	@FindBy(xpath = "//*[@id ='s-result-sort-select']")
	private WebElement SortDropdown;
	
	// select the product to add to cart
	@FindBy(xpath = "//img[@data-image-index ='4']")
	private WebElement SelectProduct;
	
	
	//Locators for SearchByText
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")private WebElement SearchItem;
	@FindBy(xpath="//*[@value='Go']")private WebElement Go;
    //@FindBy(xpath="//span[text()='Royal Enfield Ash Bike Miniature/Scale Model (RLCSML000007)']")private WebElement SearchedProduct;
	
	public ProductSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchByCategorytest() throws Exception {
		CategoryMenu.click();
	 	SelectCategory.click();
     	Option.click();
		Thread.sleep(1000);
		AmazonFashionfilter.click();
		Thread.sleep(1000);
		LowPriceFilter.sendKeys("1000");
		HighPriceFilter.sendKeys("2000");
		GoButton.click();
		Thread.sleep(1000);
		//Select dropdown = new Select(SortDropdown);
		//dropdown.selectByVisibleText("Newest Arrivals");
		Thread.sleep(1000);
		SelectProduct.click();
		}
	
	
public void searchByText(String product) throws Exception{
	    SearchItem.sendKeys(product);
		Go.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"search\"]//h2/a[1]")).click();
		//SearchedProduct.click();
		}


}

