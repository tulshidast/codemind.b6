package com.omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoHomePage;

public class VerifyUserAbleToSelectOptionsFromDropdown {

	WebDriver driver;
	OmayoHomePage omayoHomePage;

	@BeforeMethod
	public void setUp() throws IOException {
		this.driver = Utility.getWebDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		omayoHomePage = new OmayoHomePage(driver);
	}

	@Test
	public void verifyUserAbleToSelectOptionsFromDropdown() {
		omayoHomePage.selectMultiSelectDropdownOption("Audi");
		omayoHomePage.selectMultiSelectDropdownOption("Volvo");

		List<String> selectedOptions = omayoHomePage.getAllSelectedOptions();
		assertEquals(selectedOptions.size(), 2);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
