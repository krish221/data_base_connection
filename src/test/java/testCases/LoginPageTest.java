package testCases;


import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage loginpageObj;
	
	@BeforeMethod
	public void setUp()
	{
		initializeDriver();
		loginpageObj=PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test
	public void LoginTest() throws ClassNotFoundException, SQLException
	{
		loginpageObj.enterUserName(DatabasePage.getData("username"));
		loginpageObj.enterPassword(DatabasePage.getData("password"));
		loginpageObj.clickSigninButton();		
	}
	@Test
	public void loginTestPage() throws ClassNotFoundException, SQLException
	{
		loginpageObj.enterUserName(DatabasePage.getData("username"));
		loginpageObj.enterPassword(DatabasePage.getData("password"));
		loginpageObj.clickSigninButton();
		String actualTitle = "Dashboard- iBilling";
		String expectedTitle= loginpageObj.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
