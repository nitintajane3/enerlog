package com.qa.enerlog.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.qa.enerlog.pages.LoginPage;
import com.qa.enerlog.testbase.TestBase;

import com.qa.enerlog.utils.TestUtils;



public class LoginTest extends TestBase
{
	LoginPage loginPage ;
	
	String sheetname = "Sheet1";
	

	public LoginTest() throws IOException 
	{
		super();
		System.out.println("parent ");
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void initialiseBrowser() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@DataProvider
	public  Object[][] getDataExcel() throws IOException
	{
		 Object objects[][] = TestUtils.getTestData(sheetname);
		 return objects;
	}
	
	
	@Test(dataProvider="getDataExcel")
	public void loginTestCases(String username, String passwrod,ITestResult result) throws IOException
	{
		
		
		
		 loginPage.login(username,passwrod);
		System.out.println(username   +   passwrod);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		 driver.quit();
	}
	
	
}
