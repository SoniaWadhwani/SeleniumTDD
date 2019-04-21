package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	public LoginPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage= new LoginPage();
		loginPage.clickLogin();
	}
	
	@Test
	public void verifyLoginPageTitle(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRM");
	}
	@Test
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
