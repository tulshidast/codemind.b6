package com.omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoHomePage;

public class VerifyHomePage {

	WebDriver driver;
	OmayoHomePage omayoHomePage;
	SoftAssert softAssert;

	@BeforeMethod
	public void setUp() throws IOException {
		this.driver = Utility.getWebDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		omayoHomePage = new OmayoHomePage(driver);
		softAssert = new SoftAssert();
	}

	@Test
	public void verifyUserAbleToSelectOptionsFromDropdown() throws IOException {
		// hard aasertion
		/*
		 * assertEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com)");
		 * 
		 * assertTrue(omayoHomePage.getHomePageTitle().equals("omayo (QAFox.com)"));
		 * 
		 * assertNotEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com)");
		 * 
		 * System.out.println("After assertion failure");
		 * 
		 * assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));
		 */

		softAssert.assertEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com)");

		softAssert.assertTrue(omayoHomePage.getHomePageTitle().equals("omayo (QAFox.com)"));

		// softAssert.assertNotEquals(omayoHomePage.getHomePageTitle(), "omayo
		// (QAFox.com)");

		System.out.println("After assertion failure");

		softAssert.assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));

		// verify page url
		softAssert.assertEquals(omayoHomePage.getHomePageUrl(), "http://omayo.blogspot.com/");

		assertEquals(omayoHomePage.getOnePageLink().getText(), "Page One");

		softAssert.assertFalse(omayoHomePage.getMaleRadioButton().isSelected());

		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.takesScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
