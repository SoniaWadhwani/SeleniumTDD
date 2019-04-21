package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage= new LoginPage();
		homePage= new HomePage();
		contactsPage = new ContactsPage();
		loginPage.clickLogin();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyUserName()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test
	public void verifyContactsLink()
	{
		homePage.clickonContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
