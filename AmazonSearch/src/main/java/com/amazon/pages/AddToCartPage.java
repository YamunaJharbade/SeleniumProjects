package com.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.amazon.base.TestBase;


public class AddToCartPage extends TestBase {
	
	
private WebDriver driver;
	
	@FindBy(name = "dropdown_selected_size_name") private WebElement Dropdown;
	@FindBy(xpath = "//input[@id='add-to-cart-button']") private WebElement AddToCartBtn;
	
	//Locator to view the Shopping cart by clicking on 'Cart' button
	@FindBy(xpath = "//*[@id='hlb-view-cart-announce']") private WebElement CartBtn;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddtoCart() throws Exception {
		String MainWindow = driver.getWindowHandle();
		// To handle the new open window
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		while (it.hasNext()) {
			String childwindowid = it.next();
			if (!MainWindow.equalsIgnoreCase(childwindowid)) {
				// Switching to Child window
				driver.switchTo().window(childwindowid);
				
				try {
					WebElement selectdd = driver.findElement(By.xpath("//*[@id=\"native_dropdown_selected_size_name\"]"));
					selectdd.isDisplayed();
					System.out.println("Size selected from the Size dropdown");
					Select dropdown = new Select(Dropdown);
					dropdown.selectByIndex(2);
					//Thread.sleep(2000);
				} catch (Exception e) {
					System.out.println("Size is not required for this product");
				}
				 	  
				try {
					Select SelectQuantity = new Select(driver.findElement(By.id("quantity")));
					SelectQuantity.selectByIndex(1);
				} catch (Exception e) {
					System.out.println("Unable to select the quantity from the dropdown");
				}
				
			    try {
					WebElement emailbtn = driver.findElement(By.xpath("//a[@title='Email Me']"));
					emailbtn.isDisplayed();
					emailbtn.click();
					System.out.println("TC_02_Product is currently unavailable, Email will be sent when the product is available ");
					//driver.close();
    			} catch (Exception e) {
					System.out.println();
				}
		
				//Add to cart
				AddToCartBtn.click();
				try 
				{
				WebElement tickicon = driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1"));
				tickicon.isDisplayed();
				System.out.println("Product is successfully added to the cart");
				
				CartBtn.click();
				String pageHeading = "Shopping Cart";
				Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(), 'Shopping Cart')]")).getText(), pageHeading);
				}catch (Exception e) {
					System.out.print("Product is not added to the cart");
				}
				driver.navigate().refresh();
				driver.close(); // Close the child window
     		}	
		}
		// switch back to parent window
		driver.switchTo().window(MainWindow);
		driver.navigate().refresh();
		return;
	}
}

