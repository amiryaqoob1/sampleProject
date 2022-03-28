package com.hessels.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hessels.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Using Page Factory
	
	@FindBy(xpath = "//input[contains(@type,'email')]")
	WebElement Email;
	
	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement Password;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-primary py-3 px-4 w-full align-top')]")
	WebElement LoginButton;
	
	@FindBy(xpath = "//div[@class='toastify-content flex']//div[@class='ml-4 mr-4']//div[@class='text-gray-600 mt-1'][contains(text(),'These credentials do not match our records.')]")
	WebElement LoginSuccessMessage;
	
	@FindBy(xpath = "//div[@class='side-menu__title'][contains(.,'Dashboard')]")
	WebElement DashboardNavigation;

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		}
	
		
		public boolean Login(String email, String password) { 
		Email.sendKeys(email);
		Password.sendKeys(password); 
		LoginButton.click();
		  
		if (DashboardNavigation.isDisplayed()) {
			
			return true;
		}
		else {
			return false;
		}
  
		  }
		
	}
	
	
	
