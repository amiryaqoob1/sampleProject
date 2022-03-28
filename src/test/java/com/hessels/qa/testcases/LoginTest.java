package com.hessels.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hessels.qa.base.TestBase;
import com.hessels.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage login;
	
	@BeforeMethod
	public void StartBrowser() {
		initialization();
		login = new LoginPage();
	}
	
	@Test
	public void login() {	 
	boolean result =login.Login(prop.getProperty("email"), prop.getProperty("password"));	
	Assert.assertTrue(result, "Unable to login!");
	
	}

	@AfterMethod
	public void QuitBrowser() {
		CloseBrowser();	
	}
}
