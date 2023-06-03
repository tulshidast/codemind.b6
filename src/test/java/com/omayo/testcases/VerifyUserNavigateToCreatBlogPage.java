package com.omayo.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoCreatBlogPage;
import com.omayo.pages.OmayoHomePage;

public class VerifyUserNavigateToCreatBlogPage {

	WebDriver driver;
	OmayoHomePage omayoHomePage;
	OmayoCreatBlogPage omayoCreatBlogPage;

	@BeforeMethod
	public void setUp() throws IOException {
		this.driver = Utility.getWebDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		omayoHomePage = new OmayoHomePage(driver);
		omayoCreatBlogPage = new OmayoCreatBlogPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}

	@Test
	public void verifyUserAbleToSelectOptionsFromDropdown() {
		Utility.switchToFrame(driver, omayoHomePage.getFrame1());
		omayoHomePage.getCreatBlog().click();
		Utility.switchBackToDefaultContent(driver);
		Utility.waitForElementToBeAvailble(driver, 60, "//a[text()='Create your blog']");
		omayoCreatBlogPage.getCreatBlogLink().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
