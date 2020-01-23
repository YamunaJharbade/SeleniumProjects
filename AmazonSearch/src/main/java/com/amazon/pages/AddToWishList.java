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
import com.util.captureScreenshot;

public class AddToWishList extends TestBase{
	private WebDriver driver;

	@FindBy(name = "dropdown_selected_size_name") private WebElement Dropdown;
	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']") private WebElement AddToWishListButton;
	
	//Locators for search by text
	@FindBy(xpath="//*[@class='sc-product-image']")private WebElement CLICKONBIKENAME;
	@FindBy(xpath="//input[@type='image']")private WebElement CREATEWISHLIST;

	public AddToWishList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Wishlist() throws Exception {
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
					Thread.sleep(1000);
					
				} catch (Exception e) {
					System.out.println("Size is not required for this product");
				}
				 	  
				try {
					Select SelectQuantity = new Select(driver.findElement(By.id("quantity")));
					SelectQuantity.selectByIndex(0);
					} catch (Exception e) {
					System.out.println("Unable to select the quantity");
				}

	            //Add to Wishlist
				AddToWishListButton.click();
				Assert.assertEquals("//span[@id='WLHUC_result_listName']", "Yamuna's Wish List");
				System.out.println(driver.findElement(By.xpath("//*[@class='w-success-msg']")).getText());
				//System.out.println(driver.findElement(By.xpath("//*[@id=\"WLHUC_result_success\"]/div")).getText());
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='View Wish List']")).click();
				Thread.sleep(1000);
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


