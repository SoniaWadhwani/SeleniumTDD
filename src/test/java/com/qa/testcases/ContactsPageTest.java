package com.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
	}
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickonContactsLink();
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data = null ;
		return data;
	}
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String ftName, String ltName, String company)
	{
		contactsPage.clickOnNewContactsLink();
		contactsPage.CreateNewContact(ftName, ltName, company);
	}
}
