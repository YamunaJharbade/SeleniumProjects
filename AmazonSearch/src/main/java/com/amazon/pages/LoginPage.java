package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.base.TestBase;

public class LoginPage extends TestBase {
	private WebDriver driver;

	// Page Factory
	@FindBy(linkText = "Sign in")
	private WebElement SignIn;

	@FindBy(name = "email")
	private WebElement Email;

	@FindBy(id = "continue")
	private WebElement continuebutton;

	@FindBy(id = "ap_password")
	private WebElement Password;

	@FindBy(id = "signInSubmit")
	private WebElement Submit;

	// Initialize PageFactory
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // this means it is pointing to current class object
	}

	public void Login() throws Exception {
		SignIn.click();
		if (continuebutton.isDisplayed()) {
			Email.sendKeys("jharbadeyamuna@gmail.com");
			continuebutton.click();
			if (Password.isDisplayed()) {
				Password.sendKeys("blessmegod@1982");
				
				//Password.sendKeys("Ymxlc3NtZWdvZEAxOTgy");
				Thread.sleep(1000);
				Submit.click();
			} else {
				Assert.assertTrue(false);
			}
		} else {
			Assert.assertTrue(false);
		}

		/*
		 * String captchaText =
		 * "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below."
		 * ; try { while(captchaText.equals(LP.CaptchTxtMatch())) {
		 * 
		 * 
		 * // prompt user to enter captcha String captchaVal1 =
		 * JOptionPane.showInputDialog("Please enter the captcha value : ");
		 * LP.CaptchaEnter(captchaVal1); LP.EnterPassword(decoded); LP.SubmitAction();
		 * 
		 * } } catch (Exception e) { System.out.println("Captcha didn't appear.."); }
		 */
	}
}
