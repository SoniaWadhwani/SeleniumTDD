package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream fis  = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Sonia/Desktop/Sonia/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
			else if(browserName.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver", "C:/Users/Sonia/.m2/repository/org/seleniumhq/selenium/selenium-ie-driver/3.14.0/selenium-ie-driver-3.14.0.exe");
				driver = new InternetExplorerDriver();
			}
			else if(browserName.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "C:/Users/Sonia/.m2/repository/org/seleniumhq/selenium/selenium-firefox-driver/3.14.0/selenium-firefox-driver-3.14.0.exe");
				driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
