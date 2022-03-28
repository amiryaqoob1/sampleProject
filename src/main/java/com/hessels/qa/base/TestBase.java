package com.hessels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hessels.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	
	  public TestBase() {
	  
	  try { 
		  prop = new Properties();
FileInputStream ip=new FileInputStream("C:\\Users\\amir.yaqoob\\eclipse-workspace\\ERPSystem\\src\\main\\java\\com\\hessels\\qa\\config\\config.properties");
		prop.load(ip);}
	  catch (FileNotFoundException e) {
		  e.printStackTrace();
	  } 
	  catch (IOException e) {
		 e.printStackTrace();
	  }
	  
	  }
	 

	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_Load_TimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	} 

	public void CloseBrowser() {
		driver.quit();

	}

}
